package com.yuanjun.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuanjun.bean.SsmVipRecord;
import com.yuanjun.bean.SsmVipRecordExample;
import com.yuanjun.comm.viprecord.VipRecordDto;
import com.yuanjun.comm.viprecord.VipRecordVo;
import com.yuanjun.vo.frontRecord.RecordVo;

public interface SsmVipRecordService {
	   VipRecordDto getVipRecordByOutTradeNo( String out_trade_no );
		int updateByPrimaryKey(SsmVipRecord record);
	
	    int updateByExampleSelective( SsmVipRecord record,  SsmVipRecordExample example);

	   List<VipRecordVo>  getVipRecord( String phone );

	   RecordVo   getByUserId( String userId ) ;
	
	   long countByExample(SsmVipRecordExample example);

	    int deleteByExample(SsmVipRecordExample example);

	    int deleteByPrimaryKey(Integer id);

	    int insert(SsmVipRecord record);

	    int insertSelective(SsmVipRecord record);

	    List<SsmVipRecord> selectByExample(SsmVipRecordExample example);

	    SsmVipRecord selectByPrimaryKey(Integer id);
	    int updateByPrimaryKeySelective(SsmVipRecord record);

}
