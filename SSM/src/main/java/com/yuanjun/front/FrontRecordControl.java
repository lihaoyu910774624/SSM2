package com.yuanjun.front;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanjun.comm.MapMessage;
import com.yuanjun.service.SsmVipRecordService;
import com.yuanjun.vo.frontRecord.RecordDto;
import com.yuanjun.vo.frontRecord.RecordMessage;
import com.yuanjun.vo.frontRecord.RecordVo;

@Controller
@RequestMapping("/Record")
@CrossOrigin
public class FrontRecordControl {
	@Autowired
	private SsmVipRecordService ssmVipRecordService ;
	
	@RequestMapping(value="/getByUserId", method=RequestMethod.POST)	
	@ResponseBody
	public RecordMessage getByUserId (@RequestParam(value="userId") String userId) {
		RecordMessage message = new RecordMessage ();
		List<RecordDto> data = new ArrayList<RecordDto>();
		RecordDto  dto = new RecordDto();
		RecordVo vo = ssmVipRecordService.getByUserId(userId);
		if(vo!=null) {			
			Date date = new Date(vo.getExprietime()*1000L);
		    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			dto.setTitle(vo.getTitle());			
			dto.setAddtime( sd.format(vo.getAddtime()) );			 
		    dto.setExprietime(sd.format(date));
			data.add(dto);
			message.setCode("1");
			message.setMsg("数据查询成功");
			message.setData(data);
		}else {
			message.setCode("0");
			message.setMsg("查不到数据");
			
		}
		
		return message ;
	}
	
	
	
	
	
	
	
	
	

}
