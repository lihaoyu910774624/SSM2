package com.yuanjun.control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanjun.bean.SsmVipProduct;
import com.yuanjun.bean.SsmVipProductExample;
import com.yuanjun.comm.AdminUtil;
import com.yuanjun.comm.MapMessage;
import com.yuanjun.comm.Message;
import com.yuanjun.comm.ProductListMessage;
import com.yuanjun.service.SsmVipProductService;
import com.yuanjun.vo.ProductInfo;

@Controller
@RequestMapping("/Product")
@CrossOrigin
public class ProductControl {
	
	@Autowired
	private AdminUtil util ;
	@Autowired
	 private  SsmVipProductService ssmVipProductService;
	
	@RequestMapping(value = "/findAll",method=RequestMethod.POST)
	@ResponseBody	
	public ProductListMessage findAll(
				
			) {
		ProductListMessage plm = new ProductListMessage();
		List<SsmVipProduct> list = new ArrayList<SsmVipProduct>();
		
		
		
		SsmVipProductExample example = new SsmVipProductExample();
		SsmVipProductExample.Criteria criteria = example.createCriteria();
		criteria.andFlagEqualTo(new Byte("1") );				
		list=ssmVipProductService.selectByExample(example);
		List<ProductInfo> data = new ArrayList<ProductInfo>() ;		
		for(int i=0;i<list.size();i++) {
			ProductInfo info = new ProductInfo();
			info.setProductId(list.get(i).getProductId());
			info.setTitle(list.get(i).getTitle());
			info.setPrice(list.get(i).getPrice());
			info.setEffectdays(list.get(i).getEffectdays());
			info.setAddtime(list.get(i).getAddtime());
			data.add(info);
		}
		plm.setCode("1");
		plm.setMsg("数据查询成功");
		plm.setData(data);		
		return plm ;
		
	}
	@RequestMapping(value = "/findById",method=RequestMethod.POST)
	@ResponseBody	
	public MapMessage findById(
			@RequestParam(value="adminId") String adminId,

			@RequestParam(value="productId") String productId) {
		
		MapMessage message = new  MapMessage();
		Boolean isAdmin =   util.isAdmin(adminId);
		if(!isAdmin) {			
			message.setCode("0");
			message.setMsg("0");
			return message ;
		}
		Map<String,String> data =new  HashMap<String,String>();		
		List<SsmVipProduct> list = new ArrayList<SsmVipProduct>();
		SsmVipProductExample example = new SsmVipProductExample();
		SsmVipProductExample.Criteria criteria = example.createCriteria();
		criteria.andFlagEqualTo(new Byte("1") );
		criteria.andProductIdEqualTo(productId);
		list =  ssmVipProductService.selectByExample(example);
		if(null!=list&&list.size()>0)
		{
			SsmVipProduct svp = list.get(0);
			data.put("productId", svp.getProductId());
			data.put("title", svp.getTitle());
			data.put("price", String.valueOf(svp.getPrice()));
			data.put("effectdays", String.valueOf(svp.getEffectdays()));
			message.setCode("1");
			message.setMsg("数据查询成功");
			message.setData(data);
		}else {
			data.put("code", "");
			message.setCode("0");
			message.setMsg("数据查询失败");
			message.setData(data);
			return message ;
		}
		
		return message ;
	}
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	@ResponseBody
	public Message addProduct(
			@RequestParam(value="adminId") String adminId,
			@RequestParam(value="title") String title,
			@RequestParam(value="price") Integer price,
			@RequestParam(value="effectdays") Integer effectdays			
			) 
	{
		Message message = new Message() ;
		Boolean isAdmin =   util.isAdmin(adminId);
		if(!isAdmin) {			
			message.setCode("0");
			message.setMsg("0");
			return message ;
		}
		String productId = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		SsmVipProduct product = new SsmVipProduct();
		product.setProductId(productId);
		product.setTitle(title);		
		product.setPrice(price*100);
		product.setEffectdays(effectdays);
		int index=ssmVipProductService.insertSelective(product);
		if(index>0) {
			message.setCode("1");
			message.setMsg("数据添加成功");
		}else {
			message.setCode("0");
			message.setMsg("添加失败");
		}
		
		return message ;
	}
	
	@RequestMapping(value = "/delete",method=RequestMethod.POST)
	@ResponseBody
	public Message deleteProduct(
			@RequestParam(value="adminId") String adminId,
			@RequestParam(value="productId") String productId					
			) 
	{
		
		Message message = new Message() ;
		Boolean isAdmin =   util.isAdmin(adminId);
		if(!isAdmin) {			
			message.setCode("0");
			message.setMsg("0");
			return message ;
		}	
		SsmVipProductExample example = new SsmVipProductExample();
		SsmVipProductExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		
		SsmVipProduct product = new SsmVipProduct();		
		product.setFlag((byte)0);
		
		int index=ssmVipProductService.updateByExampleSelective(product, example);
		if(index>0) {
			message.setCode("1");
			message.setMsg("成功");
		}else {
			message.setCode("0");
			message.setMsg("失败");
		}
		
		return message ;
	}
	
	
	
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	@ResponseBody
	public Message updateProduct(
			@RequestParam(value="adminId") String adminId,
			@RequestParam(value="productId") String productId,
			@RequestParam(value="title") String title,
			@RequestParam(value="price") Integer price,
			@RequestParam(value="effectdays") Integer effectdays
			) 
	{
		
		Message message = new Message() ;
		Boolean isAdmin =   util.isAdmin(adminId);
		if(!isAdmin) {			
			message.setCode("0");
			message.setMsg("0");
			return message ;
		}
		SsmVipProductExample example = new SsmVipProductExample();
		SsmVipProductExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		criteria.andFlagEqualTo(new Byte("1"));
		SsmVipProduct product = new SsmVipProduct();
		product.setProductId(productId);
		product.setTitle(title);
		
		product.setPrice(price*100);
		product.setEffectdays(effectdays);
		
		int index=ssmVipProductService.updateByExampleSelective(product, example);
		if(index>0) {
			message.setCode("1");
			message.setMsg("成功");
		}else {
			message.setCode("0");
			message.setMsg("失败");
		}
		
		return message ;
	}

}
