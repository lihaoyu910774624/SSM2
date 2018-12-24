package com.yuanjun.dao;

import com.yuanjun.bean.SsmVipRecord;
import com.yuanjun.bean.SsmVipRecordExample;
import com.yuanjun.comm.viprecord.VipRecordDto;
import com.yuanjun.comm.viprecord.VipRecordVo;
import com.yuanjun.vo.frontRecord.RecordVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SsmVipRecordMapper {
	VipRecordDto getVipRecordByOutTradeNo(@Param("out_trade_no") String out_trade_no );
	 List<VipRecordVo>  getVipRecord(@Param("phone") String phone );
	RecordVo   getByUserId(@Param("userId") String userId ) ;
    long countByExample(SsmVipRecordExample example);

    int deleteByExample(SsmVipRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SsmVipRecord record);

    int insertSelective(SsmVipRecord record);

    List<SsmVipRecord> selectByExample(SsmVipRecordExample example);

    SsmVipRecord selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(SsmVipRecord record);

    int updateByPrimaryKey(SsmVipRecord record);

    int updateByExampleSelective(@Param("record") SsmVipRecord record, @Param("example") SsmVipRecordExample example);

    int updateByExample(@Param("record") SsmVipRecord record, @Param("example") SsmVipRecordExample example);

   
}