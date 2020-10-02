package cn.edu.zucc.qua.service;
/**
* 类说明 
*
* @author 屠哲俊
* @date 2020年7月4日  新建
*/
public interface CommentService {

    /**
     * 发布评论
     * @param answerId
     * @param commentContent
     * @param userId
     * @return
     */
    boolean appendComment(String answerId, String commentContent, String userId);


    /**
     * 删除评论
     * @param commentId
     * @param answerId
     * @return
     */
    boolean deleteComment(String commentId, String answerId);


    /**
     * 评论评论
     * @param answerId
     * @param commentId
     * @param commentContent
     * @param userId
     * @return
     */
    boolean replyComment(String answerId, String commentId, String commentContent, String userId);
}
