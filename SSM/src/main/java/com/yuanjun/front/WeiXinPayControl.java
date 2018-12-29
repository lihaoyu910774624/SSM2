package com.yuanjun.front;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.yuanjun.bean.SsmVipProduct;
import com.yuanjun.bean.SsmVipProductExample;
import com.yuanjun.bean.SsmVipRecord;
import com.yuanjun.bean.SsmVipRecordExample;
import com.yuanjun.comm.MapMessage;
import com.yuanjun.comm.Message;
import com.yuanjun.comm.ipUtil.IpUtil;
import com.yuanjun.front.weixinpay.MyConfig;
import com.yuanjun.front.weixinpay.WXPay;
import com.yuanjun.front.weixinpay.WXPayConfig;
import com.yuanjun.front.weixinpay.WXPayUtil;
import com.yuanjun.front.wxjs.WxjsConfig;
import com.yuanjun.service.SsmUserService;
import com.yuanjun.service.SsmVipProductService;
import com.yuanjun.service.SsmVipRecordService;
import com.yuanjun.vo.UserInfo;

@Controller
@RequestMapping("/WeiXinPay")
@CrossOrigin
public class WeiXinPayControl {
	@Autowired
	private SsmVipProductService ssmVipProductService ;
	@Autowired
	private   SsmUserService ssmUserService;
	@Autowired
	private SsmVipRecordService ssmVipRecordService ;
	private static Logger logger = Logger.getLogger(WeiXinPayControl.class);  
	@RequestMapping(value="/getOpenId", method=RequestMethod.POST)
	@ResponseBody 
	public MapMessage getOpenId (@RequestParam(value="code") String code) throws Exception {		
		MapMessage message = new MapMessage ();
		Map<String,String> data = new HashMap<String,String>();
		if(StringUtils.isBlank(code)) {
			
			message.setCode("0");
        	message.setMsg("参数为空");
        	return  message ; 
			
		}
		String appid = WxjsConfig.APPID;
		String secret = WxjsConfig.APPSECRET;
		String strUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?";
		StringBuffer sb = new StringBuffer ();
		sb.append(strUrl).append("appid=").append(appid).
		   append("&secret=").append(secret).append("&code=").append(code).append("&grant_type=authorization_code");
		URL url = new URL(sb.toString());
		logger.info("获取openid调用地址"+url.toString());
		//System.out.println(url.toString());
		    HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();  
	        httpUrlConn.setDoInput(true);  
	        httpUrlConn.setRequestMethod("GET");  
	        httpUrlConn.connect(); 
	        InputStream inputStream = httpUrlConn.getInputStream();  
	        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
	        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  

	       
	    	StringBuffer buffer = new StringBuffer();
	        String str = null;  
	        while ((str = bufferedReader.readLine()) != null) {  
	            buffer.append(str);  
	        }  
	       
	        bufferedReader.close();  
	        inputStreamReader.close();  
	        inputStream.close();  
	        inputStream = null;  	        
	        httpUrlConn.disconnect();	       
	        String result = buffer.toString();	      
	        logger.info("接口调用返回结果"+result);
	        Map maps = (Map)JSON.parse(result);
	        if(!maps.containsKey("errcode")) {
	        	message.setCode("1");
	        	message.setMsg("数据获取成功");
	        	data.put("openid", (String)maps.get("openid"));
	        	message.setData(data);
	        }else {
	        	message.setCode("0");
	        	message.setMsg("appid获取失败"+result);
	        	data.put("", "");
	        }
		
		return message ;
		
	}
	
	
	@RequestMapping(value="/unifiedorder", method=RequestMethod.POST)
	@ResponseBody 
	public MapMessage unifiedorder(
			HttpServletRequest request,
			@RequestParam(value="userid") String userid,			
			@RequestParam(value="product_id") String product_id,
			@RequestParam(value="category_pid" ,defaultValue="") String category_pid,
			@RequestParam(value="category_id") String category_id,
			@RequestParam(value="openid") String openid,
			@RequestParam(value="type") String type //支付方式
			
			) throws Exception{
		MapMessage message = new MapMessage();
			//校验用户 是否存在
		UserInfo user    =ssmUserService.getUserInfoById(userid);	
		if(user==null) {
			message.setCode("0");
			message.setMsg("0");			
			return message ;
		}
		// 产品校验  product_id 
		SsmVipProductExample ssmVipProductExample = new SsmVipProductExample();
		SsmVipProductExample.Criteria   ssmVipProductExampleCriteria = ssmVipProductExample.createCriteria();
		ssmVipProductExampleCriteria.andFlagEqualTo((byte)1);
		ssmVipProductExampleCriteria.andProductIdEqualTo(product_id);
		List<SsmVipProduct> ssmVipProductList = ssmVipProductService.selectByExample(ssmVipProductExample);
		SsmVipProduct ssmVipProduct = new SsmVipProduct();
		if(ssmVipProductList!=null&&ssmVipProductList.size()>0) {
			ssmVipProduct = ssmVipProductList.get(0);
		}else {
			message.setCode("0");
			message.setMsg("入参不合法");			
			return message ;
		}
		
		        String nonce_str =WXPayUtil.generateNonceStr();
		        String body = ssmVipProduct.getTitle();
				MyConfig  config = new MyConfig();
		   		Map<String,String> wxRequestData = new HashMap<String,String>();
		        wxRequestData.put("appid", config.getAppID());// appid   WxjsConfig.APPID 
		        wxRequestData.put("mch_id",config.getMchID());// mch_id：1521812891
		        wxRequestData.put("device_info","WEB");//device_info  WEB

		        Map<String,String> signData = new HashMap<String,String>();
		        signData.put("appid", config.getAppID());// appid   WxjsConfig.APPID 
		        signData.put("mch_id",config.getMchID());// mch_id：1521812891
		        signData.put("device_info","WEB");//device_info  WEB
		        signData.put("body",body);
		        signData.put("nonce_str",nonce_str);
		        wxRequestData.put("nonce_str",nonce_str);// nonce_str  String(32)
		        // sign
		        String sign = WXPayUtil.generateSignature(signData, config.getKey());
		        wxRequestData.put("sign", sign);
				// sign_type
		        wxRequestData.put("sign_type","MD5");
		        wxRequestData.put("body", body);// body   : ssm_vip_product title属性
		        
				//  out_trade_no：自己生成  String(32)	
		       String out_trade_no = UUID.randomUUID().toString().replace("-", "");
		       wxRequestData.put("out_trade_no", out_trade_no);
				//  total_fee  分为单位  
		       wxRequestData.put("total_fee", String.valueOf(ssmVipProduct.getPrice()));
				//  spbill_create_ip  服务器ip
		       String    spbill_create_ip =  IpUtil.getIpAdrress(request);
		       wxRequestData.put("spbill_create_ip", spbill_create_ip);
				// time_start  String(14)	20091225091010
		      // Date date = new Date();
		       long currentTime = System.currentTimeMillis();
		       SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
		       String time_start=sdf.format(new Date(currentTime));		       
				// time_expire    10分钟后过期
		       long  expireTime= currentTime+1000*60*10;//10分钟时间
		       String time_expire =sdf.format(new Date(expireTime));
		       wxRequestData.put("time_start", time_start);
		       wxRequestData.put("time_expire", time_expire);
				//通知地址	notify_url	是	接口获取  
		       wxRequestData.put("notify_url", config.getNotify_url());
				// attach 同type 保持一致
		       wxRequestData.put("attach", type);
		       //交易类型	trade_type	是	String(16)	JSAPI	
		       wxRequestData.put("trade_type", "JSAPI");
               //商品ID	product_id	否	String(32)	12235413214070356458058	
		       wxRequestData.put("product_id", ssmVipProduct.getProductId());
		       // openid 入参
		       wxRequestData.put("openid", openid);
		       
		      
		       WXPay wxPay = new   WXPay( config);
		       // 调用方法请求 统一下单
		       Map<String, String> response = new HashMap<String, String>();
		       //准备好数据 调用统一支付接口  https://api.mch.weixin.qq.com/pay/unifiedorder  官方sdk
		       response = wxPay.unifiedOrder(wxRequestData);
		       logger.info("统一下单返回数据："+response);
		       String returnCode = response.get("return_code");
		       String resultCode = response.get("result_code");
		       
		       if (!"SUCCESS".equals(returnCode)) {
		    	    message.setCode("0");
					message.setMsg("请求失败"+response.get("return_msg"));			
					return message ;
		       }
		       if(!"SUCCESS".equals(resultCode)) {
		    	   
		    	    message.setCode("0");
					message.setMsg("请求失败"+response.get("err_code"));			
					return message ;
		    	   
		    	   
		       }
		      
		       String prepay_id = response.get("prepay_id");
		       if (prepay_id == null) {
		    	    message.setCode("0");
					message.setMsg("请求失败,prepay_id没有值");			
					return message ;
		       }
		       
		         //返参
				// nonce_str   sign  prepay_id  二维码链接	code_url
		       Map<String, String> data = new HashMap<String, String>();
		       
		       data.put("appId",config.getAppID());
		       data.put("timeStamp",String.valueOf(WXPayUtil.getCurrentTimestamp()));
		       data.put("nonceStr",WXPayUtil.generateNonceStr());
		       data.put("package","prepay_id="+response.get("prepay_id"));
		       data.put("signType", "MD5");
		       data.put("paySign",WXPayUtil.generateSignature(data, config.getKey()));
		  
		     //新增一条记录 保留付款流水信息
	    		SsmVipRecord newRecord = new SsmVipRecord ();
	    		newRecord.setOutTradeNo(out_trade_no);
	    		newRecord.setUserId(userid);
	    		newRecord.setOpenid(openid);
	    		newRecord.setPrepayId(prepay_id);
	    		newRecord.setCategoryid(Integer.valueOf(category_id));
	    		newRecord.setCategorypid(Integer.valueOf(category_pid));
	    		newRecord.setTotalFee(ssmVipProduct.getPrice());
	    		newRecord.setProductId(product_id);
	    		newRecord.setProductPrice(ssmVipProduct.getPrice());
	    		newRecord.setPayexprietime(Integer.valueOf(String.valueOf(expireTime/1000)));
	    		newRecord.setType(Byte.valueOf(type));
	    		ssmVipRecordService.insertSelective(newRecord);
		
	    		message.setCode("1");
	    		message.setMsg("调用成功"); 
	    		message.setData(data);
		
		return message ;
	}
	
	@RequestMapping(value="/getNotifyUrl", method=RequestMethod.POST)	
	@ResponseBody
	public  String getNotifyUrl(HttpServletRequest request, HttpServletResponse response) {
		logger.info("统一下发回调地址调用开始");
		
		 String resXml="";
		 try{
		        //
		        InputStream is = request.getInputStream();
		        //将InputStream转换成String
		        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		        StringBuilder sb = new StringBuilder();
		        String line = null;
		        try {
		            while ((line = reader.readLine()) != null) {
		                sb.append(line + "\n");
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        } finally {
		            try {
		                is.close();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		        resXml=sb.toString();
		        if (StringUtils.isBlank(resXml)) {
					logger.error("微信支付回调通知失败,报文为空xx");
					String xmlBack = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
							+ "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
					return xmlBack;
				}
		        logger.info("微信支付异步通知请求包: {} "+ resXml);
		        String checkRexXml = payBack(resXml);
		        return checkRexXml ;
		    }catch (Exception e){
		        logger.error("微信支付回调通知失败",e);
		        String result = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>" + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
		        return result;
		    }

		
		
		
		
		
		
		
		// gengxin  recordvip
		
		// // attach 同type 保持一致 入库
		
		
		
		/*SsmVipRecordExample  ssmVipRecordExample = new SsmVipRecordExample ();
		SsmVipRecordExample.Criteria ssmVipRecordCriteria = ssmVipRecordExample.createCriteria();
		ssmVipRecordCriteria.andFlagEqualTo((byte)1);
		ssmVipRecordCriteria.andCategorypidEqualTo(Integer.valueOf(category_pid));
		ssmVipRecordCriteria.andCategoryidEqualTo(Integer.valueOf(category_id));
		ssmVipRecordCriteria.andUserIdEqualTo(userid);
		ssmVipRecordCriteria.andProductIdEqualTo(product_id);
		List<SsmVipRecord> ssmVipRecordList = ssmVipRecordService.selectByExample(ssmVipRecordExample);
		 if(ssmVipRecordList!=null&&ssmVipRecordList.size()>0) {		    	
		    	SsmVipRecord ssmVipRecord = ssmVipRecordList.get(0); 
		    	long exprietime = ssmVipRecord.getExprietime();
		    	long now = System.currentTimeMillis()/1000;
		    	if(now<exprietime) {
		    		// vip 还在有效期内 
		    		//判断是否有购买记录  没有超时  累加
		    		
		    		//购买时间
		    		int effectdays = ssmVipProduct.getEffectdays();//有效天数
		    		//累加过期时间
		    		exprietime=exprietime+60*60*24*effectdays;
		    		ssmVipRecord.setExprietime(Integer.valueOf(String.valueOf(exprietime)));
		    		ssmVipRecordService.updateByExampleSelective(ssmVipRecord, ssmVipRecordExample);
		    		//新增一条记录 保留付款流水信息
		    		SsmVipRecord newRecord = new SsmVipRecord ();
		    		newRecord.setOutTradeNo(out_trade_no);
		    		newRecord.setUserId(userid);
		    		newRecord.setOpenid(openid);
		    		newRecord.setPrepayId(prepay_id);
		    		newRecord.setCategoryid(Integer.valueOf(category_id));
		    		newRecord.setCategorypid(Integer.valueOf(category_pid));
		    		newRecord.setTotalFee(ssmVipProduct.getPrice());
		    		newRecord.setProductId(product_id);
		    		newRecord.setProductPrice(ssmVipProduct.getPrice());
		    		newRecord
		    		newRecord
		    		newRecord
		    		newRecord
		    		
		    	}else {
		    		// 如果超时   新增一条数据
		    		
		    		
		    		
		    		
		    	}
		
		 }else {
			 //如果不存在充值记录 则新增一条
			 
			 
			 
			 
		 }*/
		
		
		
		
		
	}
	
	
	public String payBack(String notifyData) {
	    logger.info("payBack() start, notifyData={}"+notifyData);
	    String xmlBack="";
	    Map<String, String> notifyMap = null;
	    try {
	    	
	    	MyConfig  iWxPayConfig = new MyConfig();
	        WXPay wxpay = new WXPay(iWxPayConfig);
           
	        notifyMap = WXPayUtil.xmlToMap(notifyData);         // 转换成map
	        if (wxpay.isPayResultNotifySignatureValid(notifyMap)) {
	            // 签名正确
	            // 进行处理。
	            // 注意特殊情况：订单已经退款，但收到了支付结果成功的通知，不应把商户侧订单状态从退款改成支付成功
	            String return_code = notifyMap.get("return_code");//状态
	            String out_trade_no = notifyMap.get("out_trade_no");//订单号

	            if (out_trade_no == null) {
	                logger.info("微信支付回调失败订单号: {}"+notifyMap);
	                xmlBack = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>" + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
	                return xmlBack;
	            }
                
	            // 业务逻辑处理 ****************************
	            logger.info("微信支付回调成功订单号: {}"+notifyMap);
	            xmlBack = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>" + "<return_msg><![CDATA[SUCCESS]]></return_msg>" + "</xml> ";
	            return xmlBack;
	        } else {
	            logger.error("微信支付回调通知签名错误");
	            xmlBack = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>" + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
	            return xmlBack;
	        }
	    } catch (Exception e) {
	        logger.error("微信支付回调通知失败",e);
	        xmlBack = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>" + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
	    }
	    return xmlBack;
	}

	

	

}
