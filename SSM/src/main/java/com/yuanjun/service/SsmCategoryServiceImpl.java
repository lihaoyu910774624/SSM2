package com.yuanjun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanjun.bean.SsmCategory;
import com.yuanjun.bean.SsmCategoryExample;
import com.yuanjun.dao.SsmCategoryMapper;
import com.yuanjun.vo.CategoryInfo;
@Service
public class SsmCategoryServiceImpl implements SsmCategoryService {
	@Autowired
	private SsmCategoryMapper ssmCategoryMapper ;

	public SsmCategoryMapper getSsmCategoryMapper() {
		return ssmCategoryMapper;
	}

	public void setSsmCategoryMapper(SsmCategoryMapper ssmCategoryMapper) {
		this.ssmCategoryMapper = ssmCategoryMapper;
	}

	@Override
	public SsmCategory selectByPrimaryKey(Integer id) {
		
		return ssmCategoryMapper.selectByPrimaryKey(id);
	}

	
	@Override
	public int insertSelective(SsmCategory record) {
		
		return ssmCategoryMapper.insertSelective(record);
	}

	@Override
	public List<SsmCategory> selectByExample(SsmCategoryExample example) {
		
		return ssmCategoryMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(SsmCategory record, SsmCategoryExample example) {
		
		return ssmCategoryMapper.updateByExampleSelective(record, example);
	}

	@Override
	public List<CategoryInfo> selectAll(Integer pid) {
		
		return ssmCategoryMapper.selectAll( pid);
	}

	@Override
	public CategoryInfo selectById(Integer id) {
		
		return ssmCategoryMapper.selectById(id);
	}

}
