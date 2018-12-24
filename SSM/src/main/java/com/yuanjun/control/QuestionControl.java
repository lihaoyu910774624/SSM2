package com.yuanjun.control;

import com.alibaba.fastjson.JSONObject;
import com.yuanjun.bean.SsmQuestion;
import com.yuanjun.bean.SsmQuestionExample;
import com.yuanjun.bean.SsmQuestionExample.Criteria;
import com.yuanjun.bean.SsmQuestionOption;
import com.yuanjun.bean.SsmQuestionOptionExample;
import com.yuanjun.comm.AdminUtil;
import com.yuanjun.comm.Message;
import com.yuanjun.comm.QuestionVoListMessage;
import com.yuanjun.service.SsmQuestionOptionService;
import com.yuanjun.service.SsmQuestionService;
import com.yuanjun.vo.Option;
import com.yuanjun.vo.QuestionVo;
import com.yuanjun.vo.question.QuestionDtoMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/Question"})
@CrossOrigin
public class QuestionControl
{

  @Autowired
  private AdminUtil util;

  @Autowired
  private SsmQuestionService ssmQuestionService;

  @Autowired
  private SsmQuestionOptionService ssmQuestionOptionService;

  @Transactional
  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message addQuestion(@RequestParam("adminId") String adminId, @RequestParam("title") String title, @RequestParam("correctanswer") String correctanswer, @RequestParam("category_pid") String category_pid, @RequestParam("category_id") String category_id, @RequestParam("chapter_id") String chapter_id, @RequestParam("sort_no") String sort_no, @RequestParam("type") String type, @RequestParam(value="kind", defaultValue="2") String kind, @RequestParam("fraction") String fraction, @RequestParam("analysis") String analysis, @RequestParam("brief") String brief, @RequestParam("option") String option, @RequestParam("status") String status)
  {
    Message message = new Message();

    Boolean isAdmin = this.util.isAdmin(adminId);
    if (!isAdmin.booleanValue()) {
      message.setCode("0");
      message.setMsg("0");
      return message;
    }

    if (StringUtils.isBlank(status)) {
      message.setCode("0");
      message.setMsg("status字段不能为空");
      return message;
    }

    if (StringUtils.isBlank(type)) {
      message.setCode("0");
      message.setMsg("type字段不能为空");
      return message;
    }
    if (StringUtils.isBlank(kind)) {
      message.setCode("0");
      message.setMsg("kind字段不能为空");
      return message;
    }
    if (StringUtils.isBlank(fraction)) {
      message.setCode("0");
      message.setMsg("fraction字段不能为空");
      return message;
    }
    if (StringUtils.isBlank(option)) {
      message.setCode("0");
      message.setMsg("option字段不能为空");
      return message;
    }

    if (StringUtils.isBlank(title)) {
      message.setCode("0");
      message.setMsg("title字段不能为空");
      return message;
    }
    if (StringUtils.isBlank(category_pid)) {
      message.setCode("0");
      message.setMsg("category_pid字段不能为空");
      return message;
    }
    if (StringUtils.isBlank(chapter_id)) {
      message.setCode("0");
      message.setMsg("chapter_id字段不能为空");
      return message;
    }
    if (StringUtils.isBlank(sort_no)) {
      message.setCode("0");
      message.setMsg("sort_no字段不能为空");
      return message;
    }

    if (StringUtils.isNotBlank(title))
    {
      if (title.length() > 255) {
        message.setCode("0");
        message.setMsg("title长度大于255");
        return message;
      }
    }
    if (StringUtils.isBlank(correctanswer)) {
      message.setCode("0");
      message.setMsg("correctanswer字段不能为空");
      return message;
    }
    try
    {
      String questionid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
      SsmQuestion question = new SsmQuestion();
      question.setQuestionid(questionid);
      question.setTitle(title);
      if ("1".equals(kind)) {
        question.setCategoryid(Byte.valueOf("0"));
        question.setSubjectid(Byte.valueOf("0"));
        question.setChapterid("0");
      } else {
        question.setCategoryid(Byte.valueOf(category_pid));
        question.setSubjectid(Byte.valueOf(category_id));
        question.setChapterid(chapter_id);
      }
      question.setFraction(Integer.valueOf(fraction));
      question.setType(Byte.valueOf(type));
      question.setCorrectanswer(correctanswer);

      question.setStatus(Byte.valueOf(status));
      question.setKind(Byte.valueOf(kind));
      question.setAnalysis(analysis);
      question.setBrief(brief);
      question.setSortNo(Short.valueOf(sort_no));

      int a = this.ssmQuestionService.insertSelective(question);

      List optionList = JSONObject.parseArray(option, Option.class);
      List ssmOptions = new ArrayList();

      for (int i = 0; i < optionList.size(); i++) {
        SsmQuestionOption ssmOption = new SsmQuestionOption();
        ssmOption.setQuestionid(questionid);
        ssmOption.setNo(((Option)optionList.get(i)).getOption_no());
        ssmOption.setTitle(((Option)optionList.get(i)).getOption_title());
        ssmOption.setSortNo(((Option)optionList.get(i)).getOption_sn());
        ssmOptions.add(ssmOption);
      }

      int b = this.ssmQuestionOptionService.saveOptionAll(ssmOptions);
      if ((a == 0) || (b == 0))
        throw new Exception();
    }
    catch (Exception e)
    {
      message.setCode("0");
      message.setMsg("异常，数据保存失败");
      e.printStackTrace();
      return message;
    }
    message.setCode("1");
    message.setMsg("数据保存成功");

    return message;
  }

  @Transactional
  @RequestMapping(value={"/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message deleteQuestion(@RequestParam("adminId") String adminId, @RequestParam("questionid") String questionid)
  {
    Message message = new Message();

    Boolean isAdmin = this.util.isAdmin(adminId);
    if (!isAdmin.booleanValue()) {
      message.setCode("0");
      message.setMsg("0");
      return message;
    }
    try
    {
      SsmQuestionExample questionExample = new SsmQuestionExample();
      SsmQuestionExample.Criteria questionCriteria = questionExample.createCriteria();
      questionCriteria.andQuestionidEqualTo(questionid);
      questionCriteria.andFlagEqualTo(Byte.valueOf("1"));
      SsmQuestion ssmQuestion = new SsmQuestion();
      ssmQuestion.setFlag(new Byte("0"));
      this.ssmQuestionService.updateByExampleSelective(ssmQuestion, questionExample);

      SsmQuestionOptionExample ssmQuestionOptionExample = new SsmQuestionOptionExample();
      SsmQuestionOptionExample.Criteria optionCriteria = ssmQuestionOptionExample.createCriteria();
      optionCriteria.andQuestionidEqualTo(questionid);
      optionCriteria.andFlagEqualTo(Byte.valueOf("1"));
      SsmQuestionOption ssmQuestionOption = new SsmQuestionOption();
      ssmQuestionOption.setFlag("0");
      this.ssmQuestionOptionService.updateByExampleSelective(ssmQuestionOption, ssmQuestionOptionExample);
    } catch (Exception e) {
      message.setCode("0");
      message.setMsg("数据删除失败");
      e.printStackTrace();
    }
    message.setCode("1");
    message.setMsg("数据删除成功");
    return message;
  }

  @Transactional
  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message updateQuestion(@RequestParam("adminId") String adminId, @RequestParam("questionid") String questionid, @RequestParam("title") String title, @RequestParam("correctanswer") String correctanswer, @RequestParam("category_pid") String category_pid, @RequestParam("category_id") String category_id, @RequestParam("chapter_id") String chapter_id, @RequestParam("sort_no") String sort_no, @RequestParam("type") String type, @RequestParam(value="kind", defaultValue="2") String kind, @RequestParam("fraction") String fraction, @RequestParam("analysis") String analysis, @RequestParam("brief") String brief, @RequestParam("option") String option, @RequestParam("status") String status)
  {
    Message message = new Message();

    Boolean isAdmin = this.util.isAdmin(adminId);
    if (!isAdmin.booleanValue()) {
      message.setCode("0");
      message.setMsg("0");
      return message;
    }
    try
    {
      List optionList = JSONObject.parseArray(option, Option.class);
      List ssmOptions = new ArrayList();
      SsmQuestionOptionExample ssmQuestionOptionExample = new SsmQuestionOptionExample();
      SsmQuestionOptionExample.Criteria optionCriteria = ssmQuestionOptionExample.createCriteria();
      optionCriteria.andQuestionidEqualTo(questionid);
      optionCriteria.andFlagEqualTo(Byte.valueOf("1"));
      this.ssmQuestionOptionService.deleteByExample(ssmQuestionOptionExample);

      for (int i = 0; i < optionList.size(); i++) {
        SsmQuestionOption ssmOption = new SsmQuestionOption();
        ssmOption.setQuestionid(questionid);
        ssmOption.setNo(((Option)optionList.get(i)).getOption_no());
        ssmOption.setTitle(((Option)optionList.get(i)).getOption_title());
        ssmOption.setSortNo(((Option)optionList.get(i)).getOption_sn());
        ssmOptions.add(ssmOption);
      }

      this.ssmQuestionOptionService.saveOptionAll(ssmOptions);

      SsmQuestionExample questionExample = new SsmQuestionExample();
      SsmQuestionExample.Criteria questionCriteria = questionExample.createCriteria();
      questionCriteria.andQuestionidEqualTo(questionid);
      questionCriteria.andFlagEqualTo(Byte.valueOf("1"));
      SsmQuestion question = new SsmQuestion();
      question.setQuestionid(questionid);
      question.setTitle(title);
      question.setFraction(Integer.valueOf(fraction));
      question.setType(Byte.valueOf(type));
      question.setCorrectanswer(correctanswer);
      if ("1".equals(kind)) {
        question.setCategoryid(Byte.valueOf("0"));
        question.setSubjectid(Byte.valueOf("0"));
        question.setChapterid("0");
      } else {
        question.setCategoryid(Byte.valueOf(category_pid));
        question.setSubjectid(Byte.valueOf(category_id));
        question.setChapterid(chapter_id);
      }
      question.setStatus(Byte.valueOf(status));
      question.setKind(Byte.valueOf(kind));
      question.setAnalysis(analysis);
      question.setBrief(brief);
      question.setSortNo(Short.valueOf(sort_no));
      this.ssmQuestionService.updateByExampleSelective(question, questionExample);
    } catch (Exception e) {
      message.setCode("0");
      message.setMsg("数据更新失败");
      e.printStackTrace();
      return message;
    }
    message.setCode("1");
    message.setMsg("数据更新成功");
    return message;
  }

  @RequestMapping(value={"/findById"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public QuestionVoListMessage getById(@RequestParam("adminId") String adminId, @RequestParam("questionid") String questionid)
  {
    QuestionVoListMessage vo = new QuestionVoListMessage();
    QuestionVo qv = new QuestionVo();

    Boolean isAdmin = this.util.isAdmin(adminId);
    if (!isAdmin.booleanValue()) {
      vo.setCode("0");
      vo.setMsg("0");
      return vo;
    }
    try {
      SsmQuestionExample questionExample = new SsmQuestionExample();
      SsmQuestionExample.Criteria questionCriteria = questionExample.createCriteria();
      questionCriteria.andQuestionidEqualTo(questionid);
      questionCriteria.andFlagEqualTo(Byte.valueOf("1"));
      List questionList = new ArrayList();
      questionList = this.ssmQuestionService.selectByExample(questionExample);

      SsmQuestionOptionExample ssmQuestionOptionExample = new SsmQuestionOptionExample();
      SsmQuestionOptionExample.Criteria optionCriteria = ssmQuestionOptionExample.createCriteria();
      optionCriteria.andQuestionidEqualTo(questionid);
      optionCriteria.andFlagEqualTo(Byte.valueOf("1"));
      if ((questionList != null) && (questionList.size() > 0))
      {
        SsmQuestion ssmQuestion = new SsmQuestion();
        ssmQuestion = (SsmQuestion)questionList.get(0);
        qv.setTitle(ssmQuestion.getTitle());
        qv.setCorrectanswer(ssmQuestion.getCorrectanswer());
        qv.setCategory_id(String.valueOf(ssmQuestion.getSubjectid()));
        qv.setCategory_pid(String.valueOf(ssmQuestion.getCategoryid()));
        qv.setChapter_id(ssmQuestion.getChapterid());
        qv.setType(String.valueOf(ssmQuestion.getType()));
        qv.setKind(String.valueOf(ssmQuestion.getKind()));
        qv.setFraction(String.valueOf(ssmQuestion.getFraction()));
        qv.setAnalysis(ssmQuestion.getAnalysis());
        qv.setBrief(ssmQuestion.getBrief());
        qv.setSort_no(String.valueOf(ssmQuestion.getSortNo()));
        qv.setStatus(String.valueOf(ssmQuestion.getStatus()));

        List ssmOptions = new ArrayList();
        optionCriteria.andQuestionidEqualTo(ssmQuestion.getQuestionid());
        optionCriteria.andFlagEqualTo(Byte.valueOf("1"));
        ssmOptions = this.ssmQuestionOptionService.selectByExample(ssmQuestionOptionExample);
        List optionList = new ArrayList();
        for (int j = 0; j < ssmOptions.size(); j++) {
          Option op = new Option();
          op.setOption_title(((SsmQuestionOption)ssmOptions.get(j)).getTitle());
          op.setOption_no(((SsmQuestionOption)ssmOptions.get(j)).getNo());
          op.setOption_sn(((SsmQuestionOption)ssmOptions.get(j)).getSortNo());
          optionList.add(op);
        }
        qv.setOptionList(optionList);

        vo.setData(qv);
      }
    }
    catch (Exception e)
    {
      vo.setCode("0");
      vo.setMsg("数据查询失败");
      e.printStackTrace();
    }

    vo.setCode("1");
    vo.setMsg("数据查询成功");
    return vo;
  }

  @Transactional
  @RequestMapping(value={"/findAll"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public QuestionDtoMessage getAll(@RequestParam("adminId") String adminId, @RequestParam("category_pid") String category_pid, @RequestParam("category_id") String category_id, @RequestParam("chapter_id") String chapter_id, @RequestParam(value="currPage", required=false, defaultValue="1") String currPage, @RequestParam(value="pageSize", required=false, defaultValue="10") String pageSize, @RequestParam("title") String title, @RequestParam("kind") String kind)
  {
    QuestionDtoMessage vo = new QuestionDtoMessage();
    List data = new ArrayList();
    Boolean isAdmin = this.util.isAdmin(adminId);
    if (!isAdmin.booleanValue()) {
      vo.setCode("0");
      vo.setMsg("0");
      return vo;
    }
    try {
      int start = (Integer.valueOf(currPage).intValue() - 1) * Integer.valueOf(pageSize).intValue();

      int end = Integer.valueOf(currPage).intValue() * Integer.valueOf(pageSize).intValue();

      SsmQuestionExample questionExample = new SsmQuestionExample();
      SsmQuestionExample.Criteria questionCriteria = questionExample.createCriteria();
      questionCriteria.andFlagEqualTo(Byte.valueOf("1"));
      long sumCount = this.ssmQuestionService.countByExample(questionExample);
      int sumPage = (int)Math.ceil(Double.valueOf(sumCount).doubleValue() / Integer.valueOf(pageSize).intValue());
      data = this.ssmQuestionService.getAll(title, start, end, category_pid, category_id, chapter_id, kind);

      vo.setCurrPage(currPage);
      vo.setSumPage(String.valueOf(sumPage));
      vo.setData(data);
    } catch (Exception e) {
      vo.setCode("0");
      vo.setMsg("数据查询失败");
      e.printStackTrace();
      return vo;
    }

    vo.setData(data);
    vo.setCode("1");
    vo.setMsg("数据查询成功");
    return vo;
  }
}