package com.yuanjun.front;

import com.alibaba.fastjson.JSON;
import com.yuanjun.comm.MapMessage;
import com.yuanjun.front.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanjun.front.wxjs.SHA1;
import com.yuanjun.front.wxjs.TicketUtil;
import com.yuanjun.front.wxjs.TokenUtil;
import com.yuanjun.front.wxjs.WxjsConfig;

@Controller
@RequestMapping("/wx")
@CrossOrigin
public class valatetokenControl {
	private static final Logger DEBUG_LOGGER = Logger.getLogger(valatetokenControl.class);
	@Autowired
	private TokenUtil  tokenUtil;
	@Autowired
	private TicketUtil ticketUtil ;
	@RequestMapping(value="/valatetoken", method=RequestMethod.GET)	
	@ResponseBody
	public String valatetoken ( HttpServletResponse response,
			@RequestParam(value="signature",defaultValue="")String signature,
			@RequestParam(value="echostr",defaultValue="")String echostr,
			@RequestParam(value="timestamp",defaultValue="")String timestamp,
			@RequestParam(value="nonce",defaultValue="")String nonce
			) throws Exception {
		
		String[] str = { "crq0625", timestamp, nonce };
        Arrays.sort(str); // 字典序排序
        String bigStr = str[0] + str[1] + str[2];
        // SHA1加密
        String digest = new SHA1().encode(bigStr).toLowerCase();
       System.err.println(digest);
        // 确认请求来至微信
       if (digest.equals(signature)) {
           
    	   return echostr;
        }
		
       return "";
		
		
	}
	@RequestMapping(value="/getToken", method=RequestMethod.GET)
	public  String  gettoken () throws Exception {
		    String token = "";
		    token=tokenUtil.getWxToken();
		    if(StringUtils.isNotBlank(token)) {
		    	
		    	DEBUG_LOGGER.info("token获取成功："+token);
		    	
		    }
		
		
		  return token;
	}
	
@RequestMapping(value="/getTicket", method=RequestMethod.GET)
	public  String  getTicket (
			@RequestParam(value="token") String token 
			) throws Exception {
		    String ticket = "";
		    ticket=ticketUtil.getWxTicket(token);
		    if(StringUtils.isNotBlank(ticket)) {
		    	
		    	DEBUG_LOGGER.info("token获取成功："+ticket);
		    	
		    }
		
		
		  return ticket;
	}
	
@RequestMapping(value="/config", method=RequestMethod.GET)
@ResponseBody
 public MapMessage  wxConfig(   
		 @RequestParam(value="url",defaultValue="") String url) throws Exception {
	
	MapMessage   message = new MapMessage();
	
	if("".equals(url)) {
		message.setCode("0");
		message.setMsg("url没有数据");
		 return message;
	}
	 Map<String, String> ret = new HashMap<String, String>();
     String nonce_str = UUID.randomUUID().toString();
     String timestamp = Long.toString(System.currentTimeMillis() / 1000);
     String string1;
     String signature = "";
     String jsapi_ticket = ticketUtil.getWxTicket(tokenUtil.getWxToken());
     	
     //注意这里参数名必须全部小写，且必须有序
     string1 = "jsapi_ticket=" + jsapi_ticket +
               "&noncestr=" + nonce_str +
               "&timestamp=" + timestamp +
               "&url=" + url;
     System.out.println(string1);
     try
     {
         MessageDigest crypt = MessageDigest.getInstance("SHA-1");
         crypt.reset();
         crypt.update(string1.getBytes("UTF-8"));
         Formatter formatter = new Formatter();
         for (byte b : crypt.digest()){
             formatter.format("%02x", b);
         }
         signature = formatter.toString();
         formatter.close();
     }
     catch (NoSuchAlgorithmException e)
     {
         e.printStackTrace();
     }
     catch (UnsupportedEncodingException e)
     {
         e.printStackTrace();
     }

          
     ret.put("nonceStr", nonce_str);
     ret.put("timestamp", timestamp);
     ret.put("signature", signature);
     ret.put("appId", WxjsConfig.APPID);
     message.setCode("1");
     message.setMsg("数据加密成功");
     message.setData(ret);
     return message;
 }

@RequestMapping(value="/OpenId", method=RequestMethod.GET)
@ResponseBody
public MapMessage  getOpenId(@RequestParam(value="code",defaultValue="")String code
		) throws Exception {
	MapMessage   message = new MapMessage();
	Map<String, String> data = new HashMap<String, String>();
	
	String appid =WxjsConfig.APPID ;
	String secret = WxjsConfig.APPSECRET;
	String grant_type = "authorization_code";
	String strUrl = "https://api.weixin.qq.com/sns/oauth2/access_token";
	StringBuffer sb = new StringBuffer ();
	sb.append(strUrl).append("appid").append("=").append(appid).append("&").
	   append("secret").append("=").append(secret).append("&").
	   append("code").append("=").append(code).append("&").
	   append("grant_type").append("=").append(grant_type);
	
	    URL url = new URL(strUrl+"?"+sb.toString());
	
	
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
        Map maps = (Map)JSON.parse(result);
        if(!maps.containsKey("errcode")) {
        	message.setCode("1");
        	message.setMsg("数据获取成功");
        	data.put("openid", (String)maps.get("openid"));
        }else {
        	message.setCode("1");
        	message.setMsg("数据获取成功");
        	data.put("", "");
        }
	
	
	return message ;
}
}
