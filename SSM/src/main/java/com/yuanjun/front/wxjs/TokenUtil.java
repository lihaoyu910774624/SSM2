package com.yuanjun.front.wxjs;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.yuanjun.bean.SsmWxToken;
import com.yuanjun.service.SsmWxTokenService;

@Service
public class TokenUtil {
	
	
	 @Autowired
    private  SsmWxTokenService ssmWxTokenService ;
	private String accessTokenUrl;
	private static final Logger DEBUG_LOGGER = Logger.getLogger(TokenUtil.class);
	
	public String getWxToken() throws Exception {
		
		String accessToken = "";
		Map<String,String> map = new HashMap<String,String>();
		//先查找数据库是否有数据
		SsmWxToken ssmWxToken  =  ssmWxTokenService.selectByPrimaryKey(WxjsConfig.TOKENID);
		if(ssmWxToken!=null&&ssmWxToken.getAccesstoken()!=null) {
			// 查找数据库 数据是否过时 
			
			long now  = new Date().getTime()/1000 -300;//取得当前时间 精确到秒 提前300秒
			if(now>ssmWxToken.getExpiretime()) {
				//token 无效 需要重新获取 调用接口
				   map=  getToken();
				// 取得数据后 更新数据库
				  if(map!=null) {
					  SsmWxToken ssmWxTokenTemp = new SsmWxToken ();
					  ssmWxTokenTemp.setId(WxjsConfig.TOKENID);
					  ssmWxTokenTemp.setAccesstoken(map.get("access_token"));
					  int expiretime = (int) (new Date().getTime()/1000 +Integer.valueOf(map.get("expires_in")));
					  ssmWxTokenTemp.setExpiretime(expiretime);
					  ssmWxTokenService.updateByPrimaryKeySelective(ssmWxTokenTemp);
					  accessToken = map.get("access_token");
				  } else {
						 DEBUG_LOGGER.error("accessToken获取失败");
				       	 return null;
					  
				  }
				
			}else {
				
				return ssmWxToken.getAccesstoken();
			}
			
		}else {
			// 没有数据重新获取 调用接口
			   map=  getToken();
				// 取得数据后 更新数据库
				  if(map!=null) {
					  SsmWxToken ssmWxTokenTemp = new SsmWxToken ();
					  ssmWxTokenTemp.setId(WxjsConfig.TOKENID);
					  ssmWxTokenTemp.setAccesstoken(map.get("access_token"));
					  int expiretime = (int) (new Date().getTime()/1000 +Integer.valueOf(map.get("expires_in")));
					  ssmWxTokenTemp.setExpiretime(expiretime);
					  ssmWxTokenService.updateByPrimaryKeySelective(ssmWxTokenTemp);
					  accessToken = map.get("access_token");
				  } else {
						 DEBUG_LOGGER.error("accessToken获取失败");
				       	 return null;					  
				  }
			
		}
		return  accessToken ;
		
	}
	
	
	public Map getToken() throws Exception {
		Map<String,String> map = new HashMap<String,String>();

		 accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+WxjsConfig.APPID+"&secret="+WxjsConfig.APPSECRET;
		 System.out.println("请求的地址"+accessTokenUrl);
        URL url = new URL(accessTokenUrl);
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
        System.out.println(result);
        
      //获取access_token
	     JSONObject jsonObject = JSONObject.parseObject(result);
	     
	     String accessToken = jsonObject.getString("access_token");
	     String expires_in = jsonObject.getString("expires_in");
        if(StringUtils.isBlank(accessToken)) {
       	 DEBUG_LOGGER.error("accessToken获取失败");
       	 return null;
	     }
        map.put("access_token", accessToken);
        map.put("expires_in", expires_in);
		
		return map ;
	}
	
	
	

}
