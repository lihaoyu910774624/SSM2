package com.yuanjun.front.weixinpay;

public abstract interface IWXPayDomain
{
  public abstract void report(String paramString, long paramLong, Exception paramException);

  public abstract DomainInfo getDomain(WXPayConfig paramWXPayConfig);

  public static class DomainInfo
  {
    public String domain;
    public boolean primaryDomain;

    public DomainInfo(String domain, boolean primaryDomain)
    {
      this.domain = domain;
      this.primaryDomain = primaryDomain;
    }

    public String toString()
    {
      return "DomainInfo{domain='" + this.domain + '\'' + ", primaryDomain=" + this.primaryDomain + '}';
    }
  }
}