
package cn.edu.zucc.qua.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import cn.edu.zucc.qua.pojo.Answer;

import cn.edu.zucc.qua.pojo.Result;
import cn.edu.zucc.qua.service.AnswerService;
import cn.edu.zucc.qua.util.ResultUtil;
import io.swagger.annotations.Api;


/**
* 类说明 
*
* @author 朱子祺
* @date 2020年7月6日  新建
*/
@Api(value = "answercontroller")
@RestController
public class AnswerController {

	@Autowired
	AnswerService answerService;
	
	/**
	 * 添加回答
	 * @param answerContent
	 * @param answerImage
	 * @param questionId
	 * @param userId
	 * @return
	 */
	@PostMapping("/appendAnswer")
	public Result appendAnswer(@RequestParam("answerContent")String answerContent,
							   @RequestParam("answerImage")List<String> answerImage,
							   @RequestParam("bestAnswer")List<String> bestAnswer,
							   @RequestParam("questionId")String questionId,
							   @RequestParam("userId")String userId){
		if (answerContent == null || questionId == null || userId == null) {
			return ResultUtil.error(500, "传入参数为空");
		}
		
		if (answerService.appendAnswer(answerContent, answerImage,bestAnswer, questionId, userId)) {
			return ResultUtil.success(true);
		}
		else {
			return ResultUtil.error(405,"发布回答失败");
		}
		
		
	}
	
	/**
	 * 删除单个回答
	 * @param answerId
	 * @return
	 */
	@PostMapping("/deleteAnswer")
	public Result deleteAnswer(@RequestParam("answerId")String answerId){
		
		if(answerId == null) {
			return ResultUtil.error(500, "传入参数为空");
		}
		if(answerService.deleteAnswer(answerId)){
		   return ResultUtil.success(true);
		}
		else {
		   return ResultUtil.error(405, "删除回答失败");
		}
		
	}
	
	
	/**
	 * 查询单个回答
	 * @param answerId
	 * @return
	 */
	@PostMapping("/searchSingleAnswer")
	public Result searchSingleAnswer(@RequestParam("answerId")String answerId) {
		if(answerId == null) {
			return ResultUtil.error(500, "传入参数为空");
		}
		 Answer answer=answerService.searchSingleAnswer(answerId);
	    if (answer!=null) {
	    	return ResultUtil.success(answer);
		}
	    else {
	    	return ResultUtil.error(405, "查询单个回答失败");
		}
			
	}
	
	
	/**
	 * 修改单个问题
	 * @param answerId
	 * @param answerContent
	 * @param answerImage
	 * @return
	 */
	@PostMapping("/alterSingleAnswer")
	public Result alterSingleAnswer(@RequestParam("answerId")String answerId,
								    @RequestParam("answerContent")String answerContent,
								    @RequestParam("answerImage")List<String> answerImage) {
		
		if(answerId == null || answerContent == null || answerImage == null) {
			return ResultUtil.error(500, "传入参数为空");
		}
		
	    if (answerService.alterSingleAnswer(answerId, answerContent, answerImage)) {
	    	return ResultUtil.success(true);
		}
	    else {
	    	return ResultUtil.error(405, "修改单个回答失败");
		}
		
		
		
		
	}
			
	
	
}
