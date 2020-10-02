package cn.edu.zucc.qua.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;


import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.zucc.qua.pojo.Question;
import cn.edu.zucc.qua.pojo.Result;
import cn.edu.zucc.qua.pojo.ResultList;
import cn.edu.zucc.qua.service.QuestionService;
import cn.edu.zucc.qua.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
* 问题类接口 
*
* @author 屠哲俊
* @date 2020年7月4日  新建
*/
@Api(value = "questioncontroller")
@RestController
public class QuestionController {
	

		@Autowired
		QuestionService questionService;
	
	/**
	 * 发布问题
	 * @param questionTitle
	 * @param questionContent
	 * @param questionImage
	 * @return
	 */
	@PostMapping("/appendQuestion")
	@ApiOperation(value = "appendQuestion",notes = "发布问题")
    @ApiImplicitParams({
	@ApiImplicitParam(paramType="query", name = "questionTitle", value = "标题", required = true, dataType = "String"),
	@ApiImplicitParam(paramType="query", name = "questionContent", value = "主体", required = true, dataType = "String"),
	@ApiImplicitParam(paramType="query", name = "questionImage", value = "图片", required = true, dataType = "List<String>")
	})
	public Result appendQuestion(@RequestParam("questionTitle")String questionTitle,
			                     @RequestParam("questionContent")String questionContent,
			                     @RequestParam("questionImage")List<String> questionImage){
		if(questionTitle == null || questionContent == null ) {
			return ResultUtil.error(500, "传入参数为空");
		}
		String aString = "tzj1";
		if(questionService.appendQuestion(questionTitle, questionContent, questionImage, aString)) {
			return  ResultUtil.success(true);
		}
		else {
			return ResultUtil.error(405,"发布问题失败");
		}
	
	}

	
	/**
	 * 显示问题列表
	 * @return
	 */
	@PostMapping("/showQuestionList")
	@ApiOperation(value = "showQuestionList",notes = "显示问题列表")
	public List<Question> showQuestionList(){
		List<Question> test=new ArrayList<>();
		return test;
	}
		
	
	
	/**
	 * 查询单个问题
	 * @param questionId
	 * @return
	 */
	@PostMapping("/searchSingleQuestion")
	@ApiOperation(value = "searchSingleQuestion",notes = "查询单个问题")
	@ApiImplicitParam(paramType="query", name = "questionId", value = "问题id", required = true, dataType = "String")
	public Result searchSingleQuestion(@RequestParam("questionId")String questionId) {
		if(questionId == null) {
			return ResultUtil.error(500, "传入参数为空");
		}
		Question question = new Question();
	    try {
			question=questionService.searchSingleQuestion(questionId);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error(405, "查询单个问题失败");
		}
		return ResultUtil.success(question);
	}
	
	
	/**
	 * 修改单个问题
	 * @param questionId
	 * @param questionTitle
	 * @param questionContent
	 * @param questionImage
	 * @return
	 */
	@PostMapping("/alterSingleQuestion")
	@ApiOperation(value = "alterSingleQuestion",notes = "修改单个问题")
	@ApiImplicitParams({
	@ApiImplicitParam(paramType="query", name = "questionId", value = "问题id", required = true, dataType = "String"),
    @ApiImplicitParam(paramType="query", name = "questionTitle", value = "标题", required = true, dataType = "String"),
	@ApiImplicitParam(paramType="query", name = "questionContent", value = "主体", required = true, dataType = "String"),
	@ApiImplicitParam(paramType="query", name = "questionImage", value = "图片", required = true, dataType = "List<String>")
	})
	public Result alterSingleQuestion(@RequestParam("questionId")String questionId,
			                           @RequestParam("questionTitle") String questionTitle,
			                           @RequestParam("questionContent") String questionContent,
			                           @RequestParam("questionImage") List<String> questionImage) {
		if(questionId == null || questionTitle ==null || questionContent == null ) {
			return ResultUtil.error(500, "传入参数为空");
		}	
		if(questionService.alterSingleQuestion(questionId, questionTitle, questionContent, questionImage)) {
			return  ResultUtil.success(true);
		}
		else {
		    return ResultUtil.error(405, "修改单个问题失败");		
		}


	}
	
	
	/**
	 * 删除问题
	 * @param questionId
	 * @return
	 */
	@PostMapping("/deleteQuestion")
	@ApiOperation(value = "deleteQuestion",notes = "删除问题")
	@ApiImplicitParam(paramType="query", name = "questionId", value = "问题id", required = true, dataType = "Long")
	public Result deleteQuestion(@RequestParam("questionId")String questionId) {	
		if(questionId == null) {
			return ResultUtil.error(500, "传入参数为空");
		}

		if(questionService.deleteQuestion(questionId)){
		   return ResultUtil.success(true);
		}
		else {
		   return ResultUtil.error(405, "删除问题失败");
		}
	}
}
