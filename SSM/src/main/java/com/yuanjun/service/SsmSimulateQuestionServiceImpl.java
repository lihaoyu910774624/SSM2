package com.yuanjun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanjun.bean.SsmSimulateQuestion;
import com.yuanjun.bean.SsmSimulateQuestionExample;
import com.yuanjun.dao.SsmSimulateQuestionMapper;
import com.yuanjun.vo.simulate.WrongSimulateVo;
import com.yuanjun.vo.simulateQuestion.simulateQuestionVo;
@Service
public class SsmSimulateQuestionServiceImpl implements SsmSimulateQuestionService {
	@Autowired
	private SsmSimulateQuestionMapper ssmSimulateQuestionMapper ;

	@Override
	public int insertSelective(SsmSimulateQuestion record) {
		
		return ssmSimulateQuestionMapper.insertSelective(record);
	}

	@Override
	public int saveAllSimulateQuestion(List<simulateQuestionVo> list) {
		
		return ssmSimulateQuestionMapper.saveAllSimulateQuestion(list);
	}

	@Override
	public List<WrongSimulateVo> getWrongSimulate(String simulateid) {
		
		return ssmSimulateQuestionMapper.getWrongSimulate(simulateid);
	}

	@Override
	public int updateByExampleSelective(SsmSimulateQuestion record, SsmSimulateQuestionExample example) {
		
		return ssmSimulateQuestionMapper.updateByExampleSelective(record, example);
	}

}
