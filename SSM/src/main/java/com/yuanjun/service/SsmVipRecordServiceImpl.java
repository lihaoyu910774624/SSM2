package com.yuanjun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanjun.bean.SsmVipRecord;
import com.yuanjun.bean.SsmVipRecordExample;
import com.yuanjun.comm.viprecord.VipRecordDto;
import com.yuanjun.comm.viprecord.VipRecordVo;
import com.yuanjun.dao.SsmVipRecordMapper;
import com.yuanjun.vo.frontRecord.RecordVo;
@Service
public class SsmVipRecordServiceImpl implements SsmVipRecordService {
   @Autowired
	private SsmVipRecordMapper ssmVipRecordMapper ;

	@Override
	public long countByExample(SsmVipRecordExample example) {
		
		return ssmVipRecordMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SsmVipRecordExample example) {
		
		return ssmVipRecordMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		
		return ssmVipRecordMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SsmVipRecord record) {
		
		return ssmVipRecordMapper.insert(record);
	}

	@Override
	public int insertSelective(SsmVipRecord record) {
		
		return ssmVipRecordMapper.insertSelective(record);
	}

	@Override
	public List<SsmVipRecord> selectByExample(SsmVipRecordExample example) {
		
		return ssmVipRecordMapper.selectByExample(example);
	}

	@Override
	public SsmVipRecord selectByPrimaryKey(Integer id) {
		
		return ssmVipRecordMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SsmVipRecord record) {
		
		return ssmVipRecordMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public RecordVo getByUserId(String userId) {
		
		return ssmVipRecordMapper.getByUserId(userId);
	}

	@Override
	public List<VipRecordVo> getVipRecord(String phone) {
		
		return ssmVipRecordMapper.getVipRecord(phone);
	}

	@Override
	public int updateByPrimaryKey(SsmVipRecord record) {
		
		return ssmVipRecordMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByExampleSelective(SsmVipRecord record, SsmVipRecordExample example) {
		
		return ssmVipRecordMapper.updateByExampleSelective(record, example);
	}

	@Override
	public VipRecordDto getVipRecordByOutTradeNo(String out_trade_no) {
		
		return ssmVipRecordMapper.getVipRecordByOutTradeNo(out_trade_no);
	}

}
