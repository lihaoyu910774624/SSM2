package com.yuanjun.front;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.yuanjun.comm.MapMessage;

@Controller
@RequestMapping("/WeiXinPay")
@CrossOrigin
public class WeiXinPayControl {
	
	@RequestMapping(value="/getOpenId", method=RequestMethod.POST)
	@ResponseBody 
	public MapMessage getOpenId (@RequestParam(value="code") String code) throws Exception {		
		MapMessage message = new MapMessage ();
		Map<String,String> data = new HashMap<String,String>();
		String appid = "";
		String secret = "";
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
