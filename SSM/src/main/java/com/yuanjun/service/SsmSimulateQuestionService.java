package com.yuanjun.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuanjun.bean.SsmSimulateQuestion;
import com.yuanjun.bean.SsmSimulateQuestionExample;
import com.yuanjun.vo.simulate.WrongSimulateVo;
import com.yuanjun.vo.simulateQuestion.simulateQuestionVo;

public interface SsmSimulateQuestionService {
	 int updateByExampleSelective( SsmSimulateQuestion record,  SsmSimulateQuestionExample example);
	 List<WrongSimulateVo>   getWrongSimulate( String simulateid);
	 int insertSelective(SsmSimulateQuestion record);
	 int saveAllSimulateQuestion(List<simulateQuestionVo> list);

}
