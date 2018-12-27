package com.yuanjun.service;

import java.util.List;

import com.yuanjun.bean.SsmSimulateQuestion;
import com.yuanjun.vo.simulateQuestion.simulateQuestionVo;

public interface SsmSimulateQuestionService {
	
	 int insertSelective(SsmSimulateQuestion record);
	 int saveAllSimulateQuestion(List<simulateQuestionVo> list);

}
