package com.yuanjun.front.weixinpay;


import java.io.*;

import org.springframework.web.bind.annotation.RequestParam;


 
public class MyConfig extends WXPayConfig{
 
    private byte[] certData;
 
    public MyConfig() throws Exception {
       /* String certPath = "/path/to/apiclient_cert.p12";
        File file = new File(certPath);
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();*/
    }
 
    public String getAppID() {
        return "wxe82d18c4c4bf00da";
    }
 
    public String getMchID() {
        return "1521812891";
    }
 
    public String getKey() {
        return "1a69e6e8d41b433389bbf8f965a71d73";
    }
 
    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }
 
    public int getHttpConnectTimeoutMs() {
        return 8000;
    }
 
    public int getHttpReadTimeoutMs() {
        return 10000;
    }

    @Override
    public IWXPayDomain getWXPayDomain() { // 这个方法需要这样实现, 否则无法正常初始化WXPay
        IWXPayDomain iwxPayDomain = new IWXPayDomain() {
            @Override
            public void report(String domain, long elapsedTimeMillis, Exception ex) {

            }
            @Override
            public DomainInfo getDomain(WXPayConfig config) {
                return new IWXPayDomain.DomainInfo(WXPayConstants.DOMAIN_API, true);
            }
        };
        return iwxPayDomain;
    }


}
