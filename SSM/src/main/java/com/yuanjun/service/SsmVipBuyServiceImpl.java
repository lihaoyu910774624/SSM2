package com.yuanjun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanjun.bean.SsmVipBuy;
import com.yuanjun.bean.SsmVipBuyExample;
import com.yuanjun.dao.SsmVipBuyMapper;
@Service
public class SsmVipBuyServiceImpl implements SsmVipBuyService {
	@Autowired
   private SsmVipBuyMapper ssmVipBuyMapper ;
	@Override
	public int insertSelective(SsmVipBuy record) {
		
		return ssmVipBuyMapper.insertSelective(record);
	}

	@Override
	public int updateByExampleSelective(SsmVipBuy record, SsmVipBuyExample example) {
		
		return ssmVipBuyMapper.updateByExampleSelective(record, example);
	}

	@Override
	public List<SsmVipBuy> selectByExample(SsmVipBuyExample example) {
		
		return ssmVipBuyMapper.selectByExample(example);
	}

	@Override
	public SsmVipBuy findByUseridAndCategory(String user_id, String categoryid, String categorypid) {
		
		return ssmVipBuyMapper.findByUseridAndCategory(user_id, categoryid, categorypid);
	}

	@Override
	public int updateByPrimaryKeySelective(SsmVipBuy record) {
		
		return ssmVipBuyMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public SsmVipBuy findByOutTradeNo(String out_trade_no) {
		
		return ssmVipBuyMapper.findByOutTradeNo(out_trade_no);
	}

	@Override
	public List<String> getCloseOrderRecord() {
		
		return ssmVipBuyMapper.getCloseOrderRecord();
	}

	

}
