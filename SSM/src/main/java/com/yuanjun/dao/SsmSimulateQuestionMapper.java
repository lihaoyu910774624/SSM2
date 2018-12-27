package com.yuanjun.dao;

import com.yuanjun.bean.SsmSimulateQuestion;
import com.yuanjun.bean.SsmSimulateQuestionExample;
import com.yuanjun.vo.simulate.SimulateInfo;
import com.yuanjun.vo.simulate.WrongSimulateVo;
import com.yuanjun.vo.simulateQuestion.simulateQuestionVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SsmSimulateQuestionMapper {
	List<SimulateInfo>   getSimulateInfo(@Param("userid")String userid);
	List<WrongSimulateVo>   getWrongSimulate(@Param("simulateid") String simulateid);
	
	int saveAllSimulateQuestion(List<simulateQuestionVo> list);
    long countByExample(SsmSimulateQuestionExample example);

    int deleteByExample(SsmSimulateQuestionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SsmSimulateQuestion record);

    int insertSelective(SsmSimulateQuestion record);

    List<SsmSimulateQuestion> selectByExample(SsmSimulateQuestionExample example);

    SsmSimulateQuestion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SsmSimulateQuestion record, @Param("example") SsmSimulateQuestionExample example);

    int updateByExample(@Param("record") SsmSimulateQuestion record, @Param("example") SsmSimulateQuestionExample example);

    int updateByPrimaryKeySelective(SsmSimulateQuestion record);

    int updateByPrimaryKey(SsmSimulateQuestion record);
}