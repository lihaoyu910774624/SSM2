package com.yuanjun.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanjun.bean.SsmVipRecord;
import com.yuanjun.bean.SsmVipRecordExample;
import com.yuanjun.comm.Message;
import com.yuanjun.comm.viprecord.VipRecordDto;
import com.yuanjun.comm.viprecord.VipRecordDtoMessage;
import com.yuanjun.comm.viprecord.VipRecordListMessage;
import com.yuanjun.comm.viprecord.VipRecordVo;
import com.yuanjun.service.SsmVipRecordService;

@Controller
@RequestMapping("/VipRecord")
@CrossOrigin
public class VipRecordControl {
	@Autowired
	private SsmVipRecordService ssmVipRecordService ;
	
	@RequestMapping(value = "/getVipRecord",method=RequestMethod.POST)
	@ResponseBody	
	public VipRecordListMessage getVipRecord (@RequestParam(value="phone") String phone) {
		VipRecordListMessage vipRecordListMessage  = new VipRecordListMessage ();
		List<VipRecordVo> list = new ArrayList<VipRecordVo>();
		list = ssmVipRecordService.getVipRecord(phone);
		
		if(list!=null&&list.size()>0)
		{
			vipRecordListMessage.setCode("1");
			vipRecordListMessage.setMsg("数据查询成功");
			vipRecordListMessage.setList(list);
		}else {
			
			vipRecordListMessage.setCode("0");
			vipRecordListMessage.setMsg("数据查询失败");
			
		}	
		return vipRecordListMessage ;
	}
	
	@RequestMapping(value = "/deleteVipRecord",method=RequestMethod.POST)
	@ResponseBody	
	public Message deleteVipRecord (
			@RequestParam(value="outTradeNo") String outTradeNo
			) {
		Message message = new Message();
		
		SsmVipRecordExample ssmVipRecordExample = new SsmVipRecordExample();
		SsmVipRecordExample.Criteria  ssmVipRecordExampleCriteria =  ssmVipRecordExample.createCriteria();
		ssmVipRecordExampleCriteria.andFlagEqualTo((byte)1);
		ssmVipRecordExampleCriteria.andOutTradeNoEqualTo(outTradeNo);
		SsmVipRecord ssmVipRecord = new SsmVipRecord ();
		ssmVipRecord.setFlag((byte)0);
		 int index =  ssmVipRecordService.updateByExampleSelective(ssmVipRecord, ssmVipRecordExample);
		if(index>0) {
			message.setCode("1");
			message.setMsg("更新成功");
		}else {
			message.setCode("0");
			message.setMsg("更新失败");
		}
		
		return message ;
	}
	@RequestMapping(value = "/getVipRecordByOutTradeNo",method=RequestMethod.POST)
	@ResponseBody	
	public  VipRecordDtoMessage   getVipRecordByOutTradeNo(
			@RequestParam(value="outTradeNo") String outTradeNo) {
		VipRecordDtoMessage vipRecordDtoMessage = new VipRecordDtoMessage();
		VipRecordDto vipRecordDto = new VipRecordDto();
		
		vipRecordDto=ssmVipRecordService.getVipRecordByOutTradeNo(outTradeNo);
		if(vipRecordDto!=null) {
			vipRecordDtoMessage.setCode("1");
			vipRecordDtoMessage.setMsg("查找成功");
			vipRecordDtoMessage.setVipRecordDto(vipRecordDto);
		}else {
			vipRecordDtoMessage.setCode("0");
			vipRecordDtoMessage.setMsg("查找失败");
		}
		return vipRecordDtoMessage ;
	}
}
