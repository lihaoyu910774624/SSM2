package com.yuanjun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanjun.bean.SsmQuestionOption;
import com.yuanjun.bean.SsmQuestionOptionExample;
import com.yuanjun.dao.SsmQuestionOptionMapper;
@Service
public class SsmQuestionOptionServiceImpl implements SsmQuestionOptionService {

	@Autowired
	 private SsmQuestionOptionMapper ssmQuestionOptionMapper ;
	@Override
	public int insertSelective(SsmQuestionOption record) {
		
		return ssmQuestionOptionMapper.insertSelective(record);
	}

	@Override
	public List<SsmQuestionOption> selectByExample(SsmQuestionOptionExample example) {
		
		return ssmQuestionOptionMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(SsmQuestionOption record, SsmQuestionOptionExample example) {
		
		return ssmQuestionOptionMapper.updateByExampleSelective(record, example);
	}

	@Override
	public long countByExample(SsmQuestionOptionExample example) {
		
		return ssmQuestionOptionMapper.countByExample(example);
	}

	@Override
	public int saveOptionAll(List<SsmQuestionOption> list) {
		
		return ssmQuestionOptionMapper.saveOptionAll(list);
	}

	@Override
	public int deleteByExample(SsmQuestionOptionExample example) {
		
		return ssmQuestionOptionMapper.deleteByExample(example);
	}

	/*@Override
	public List<SsmQuestionOption> getAll(String title, String start, String end) {
		
		return ssmQuestionOptionMapper.getAll(title, start, end);
	}
*/
}
