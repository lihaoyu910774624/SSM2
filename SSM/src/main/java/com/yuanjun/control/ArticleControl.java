package com.yuanjun.control;

import com.yuanjun.bean.SsmArticle;
import com.yuanjun.bean.SsmArticleExample;
import com.yuanjun.bean.SsmArticleExample.Criteria;
import com.yuanjun.comm.AdminUtil;
import com.yuanjun.comm.ArticleListMessage;
import com.yuanjun.comm.MapMessage;
import com.yuanjun.comm.Message;
import com.yuanjun.service.SsmArticleService;
import com.yuanjun.service.SsmCategoryService;
import com.yuanjun.vo.ArticlInfo;
import com.yuanjun.vo.articlvo.ArticleTitleIdList;
import com.yuanjun.vo.articlvo.ArticleTitleIdListMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/Article"})
@CrossOrigin
public class ArticleControl
{

  @Autowired
  private AdminUtil util;

  @Autowired
  private SsmArticleService ssmArticleService;

  @Autowired
  private SsmCategoryService ssmCategoryService;

  @RequestMapping(value={"/findById"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public MapMessage getById(@RequestParam("adminId") String adminId, @RequestParam(value="id", required=true) String id)
  {
    MapMessage message = new MapMessage();
    Boolean isAdmin = this.util.isAdmin(adminId);
    if (!isAdmin.booleanValue()) {
      message.setCode("0");
      message.setMsg("0");
      return message;
    }

    Map data = new HashMap();
    List catalogList = new ArrayList();
    ArticlInfo info = this.ssmArticleService.getById(id);
    data.put("id", info.getId());
    data.put("addtime", info.getAddtime());
    data.put("categorypid", info.getCategoryId());
    data.put("categoryTitle", info.getCategoryTitle());
    data.put("title", info.getTitle());
    data.put("content", info.getContent());
    message.setCode("1");
    message.setMsg("数据查询成功");
    message.setData(data);
    return message;
  }

  @RequestMapping(value={"/findAll"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public ArticleListMessage getAll(@RequestParam("adminId") String adminId, @RequestParam("title") String title, @RequestParam(value="currPage", required=false, defaultValue="1") Integer currPage, @RequestParam(value="pageSize", required=false, defaultValue="10") Integer pageSize)
  {
    ArticleListMessage message = new ArticleListMessage();
    List data = new ArrayList();
    Boolean isAdmin = this.util.isAdmin(adminId);
    if (!isAdmin.booleanValue()) {
      message.setCode("0");
      message.setMsg("0");
      return message;
    }
    if ((title != null) && (!"".equals(title)))
    {
      if (title.length() > 255) {
        message.setCode("0");
        message.setMsg("title长度大于255");
        return message;
      }
    }

    int start = (currPage.intValue() - 1) * pageSize.intValue();
    int end = currPage.intValue() * pageSize.intValue();
    int sumCount = this.ssmArticleService.getCount().intValue();
    int sumPage = (int)Math.ceil(Double.valueOf(sumCount).doubleValue() / pageSize.intValue());
    data = this.ssmArticleService.getAll(title, start, end);
    message.setData(data);
    message.setCurrPage(currPage);
    message.setSumPage(Integer.valueOf(sumPage));
    message.setCode("1");
    message.setMsg("成功");
    return message;
  }

  @RequestMapping(value={"/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message deleteArticle(@RequestParam("adminId") String adminId, @RequestParam(value="id", required=true) String id)
  {
    Message message = new Message();
    Boolean isAdmin = this.util.isAdmin(adminId);
    if (!isAdmin.booleanValue()) {
      message.setCode("0");
      message.setMsg("0");
      return message;
    }
    SsmArticleExample example = new SsmArticleExample();
    SsmArticleExample.Criteria criteria = example.createCriteria();
    criteria.andFlagEqualTo(Byte.valueOf("1"));
    criteria.andIdEqualTo(Integer.valueOf(id));
    SsmArticle article = new SsmArticle();
    article.setFlag(Byte.valueOf("0"));
    int index = this.ssmArticleService.updateByExampleSelective(article, example);
    if (index > 0) {
      message.setCode("1");
      message.setMsg("数据删除成功");
    } else {
      message.setCode("0");
      message.setMsg("数据删除失败");
      return message;
    }
    return message;
  }

  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message updateArticle(@RequestParam("adminId") String adminId, @RequestParam(value="id", required=true) String id, @RequestParam(value="categoryId", required=true) String categoryId, @RequestParam(value="title", required=true) String title, @RequestParam(value="content", required=true) String content)
  {
    Message message = new Message();
    Boolean isAdmin = this.util.isAdmin(adminId);
    if (!isAdmin.booleanValue()) {
      message.setCode("0");
      message.setMsg("0");
      return message;
    }
    if ((title != null) && (!"".equals(title)))
    {
      if (title.length() > 255) {
        message.setCode("0");
        message.setMsg("title长度大于255");
        return message;
      }
    }

    List ids = new ArrayList();
    ids.add("0");
    ids.add("1");
    ids.add("2");
    ids.add("3");
    if ((categoryId != null) && (!"".equals(categoryId)) && 
      (!ids.contains(categoryId))) {
      message.setCode("0");
      message.setMsg("pid不在有效取值范围内");
      return message;
    }

    SsmArticleExample example = new SsmArticleExample();
    SsmArticleExample.Criteria criteria = example.createCriteria();
    criteria.andFlagEqualTo(Byte.valueOf("1"));
    criteria.andIdEqualTo(Integer.valueOf(id));
    SsmArticle article = new SsmArticle();
    article.setCategoryId(Byte.valueOf(categoryId));
    article.setTitle(title);
    article.setContent(content);
    int index = this.ssmArticleService.updateByExampleSelective(article, example);
    if (index > 0) {
      message.setCode("1");
      message.setMsg("数据更新成功");
    } else {
      message.setCode("0");
      message.setMsg("数据更新失败");
      return message;
    }
    return message;
  }

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message addArticle(@RequestParam("adminId") String adminId, @RequestParam(value="categoryId", required=true) String categoryId, @RequestParam(value="title", required=true) String title, @RequestParam(value="content", required=true) String content)
  {
    Message message = new Message();

    Boolean isAdmin = this.util.isAdmin(adminId);
    if (!isAdmin.booleanValue()) {
      message.setCode("0");
      message.setMsg("0");
      return message;
    }
    if ((title != null) && (!"".equals(title)))
    {
      if (title.length() > 255) {
        message.setCode("0");
        message.setMsg("title长度大于255");
        return message;
      }
    }

    List ids = new ArrayList();
    ids.add("0");
    ids.add("1");
    ids.add("2");
    ids.add("3");
    if ((categoryId != null) && (!"".equals(categoryId)) && 
      (!ids.contains(categoryId))) {
      message.setCode("0");
      message.setMsg("pid不在有效取值范围内");
      return message;
    }

    SsmArticle article = new SsmArticle();
    article.setCategoryId(Byte.valueOf(categoryId));
    article.setTitle(title);
    article.setContent(content);
    int index = this.ssmArticleService.insertSelective(article);
    if (index > 0) {
      message.setCode("1");
      message.setMsg("数据添加成功");
    } else {
      message.setCode("0");
      message.setMsg("数据添加失败");
      return message;
    }
    return message;
  }

  @RequestMapping(value={"/getFive"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public ArticleTitleIdListMessage getArticleTopFive(@RequestParam("adminId") String adminId, @RequestParam(value="userid", required=true) String userid) {
    ArticleTitleIdListMessage message = new ArticleTitleIdListMessage();
    ArticleTitleIdList data = new ArticleTitleIdList();
    Boolean isAdmin = this.util.isAdmin(adminId);
    if (!isAdmin.booleanValue()) {
      message.setCode("0");
      message.setMsg("0");
      return message;
    }

    List zhongjieList = this.ssmArticleService.getFive("1");
    List shouxianList = this.ssmArticleService.getFive("2");
    List chanxianList = this.ssmArticleService.getFive("3");
    data.setZhongjieList(zhongjieList);
    data.setShouxianList(shouxianList);
    data.setChanxianList(chanxianList);
  
    return message;
  }
}