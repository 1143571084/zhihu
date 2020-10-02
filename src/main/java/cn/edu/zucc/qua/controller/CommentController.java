package cn.edu.zucc.qua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.zucc.qua.pojo.Result;
import cn.edu.zucc.qua.service.CommentService;
import cn.edu.zucc.qua.util.ResultUtil;

/**
* 类说明 
*
* @author 屠哲俊
* @date 2020年7月6日  新建
*/
@RestController
public class CommentController {

	@Autowired
	CommentService commentService;
	
	/**
	 * 发布评论
	 * @param answerId
	 * @param commentContent
	 * @param userId
	 * @return
	 */
	@PostMapping("/appendComment")
	public Result appendComment(@RequestParam("answerId")String answerId, 
		                        @RequestParam("commentContent") String commentContent, 
		                        @RequestParam("userId")String userId) {
		if(answerId == null || commentContent == null || userId == null) {
			return ResultUtil.error(500, "传入参数为空");
		}
		
		if(commentService.appendComment(answerId, commentContent, userId)) {
			return ResultUtil.success(true);
		}
		else {
			return ResultUtil.error(405, "发布评论失败");
		}
	}
	
	
    /**
     * 删除评论
     * @param commentId
     * @param answerId
     * @return
     */
    @PostMapping("/deleteComment")
    public Result deleteComment(@RequestParam("commentId")String commentId, 
		                       @RequestParam("answerId")String answerId) {
    	if(commentId == null || answerId == null) {
    		return ResultUtil.error(500, "传入参数为空");
    	}
    	if(commentService.deleteComment(commentId, answerId)) {
    		return ResultUtil.success(true);
    	}
    	else {
			return ResultUtil.error(405, "删除评论失败");
		}
    }
    
    
    /**
     * 评论另一个评论
     * @param answerId
     * @param commentId
     * @param commentContent
     * @param userId
     * @return
     */
    @PostMapping("/replyComment")
    public Result replyComment(@RequestParam("answerId")String answerId, 
    		                   @RequestParam("commentId") String commentId, 
    		                   @RequestParam("commentContent")String commentContent, 
    		                   @RequestParam("userId")String userId) {
    	if(answerId == null || commentId == null ||commentContent == null || userId == null) {
    		return ResultUtil.error(500, "传入参数为空");
    	}
    	if(commentService.replyComment(answerId, commentId, commentContent, userId)) {
    		return ResultUtil.success(true);
    	}
    	else {
			return ResultUtil.error(405, "评论另一个评论失败");
		}
    }
	
}

