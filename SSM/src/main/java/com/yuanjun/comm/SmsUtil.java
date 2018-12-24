package com.yuanjun.comm;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SmsUtil {
	
	private String requestUrl = "http://api.zthysms.com/sendSms.do";
	private String username = "zylzhy";
	private String password = "pZBfIC";
	private String mobile ;
	private String code ;
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean sendSms () throws Exception {
		Boolean isSuccess = false;
				
		String tkey =  new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		String passWordMd5 =  encryption(password)+tkey; 
		String md5 = encryption(passWordMd5).toLowerCase();
		System.out.println(md5);
		String contentTemp = "【卓悦丽兹管家】您的验证码："+code+"。验证码10分钟内有效，请尽快完成验证。";
		String content = URLEncoder.encode(contentTemp, "utf-8");
        StringBuilder sb = new StringBuilder();
        sb.append("username").append("=").append(username).append("&").
            append("tkey").append("=").append(tkey).append("&").
	        append("password").append("=").append(md5).append("&").
	        append("mobile").append("=").append(mobile).append("&").
	        append("content").append("=").append(content);
    	
        URL url = new URL(requestUrl+"?"+sb.toString());
       
        
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
        
        String str2= result.substring(0,result.indexOf(",",0));
        if("1".equals(str2)) {        	
        	isSuccess = true;
        }
		return isSuccess ;
		
	}
	
	
	public String encryption(String plainText) {
		String re_md5 = new String();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}

			re_md5 = buf.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return re_md5;
	}
	
	
	
	
	
	
	

}
