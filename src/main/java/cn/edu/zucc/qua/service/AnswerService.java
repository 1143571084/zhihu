package cn.edu.zucc.qua.service;


import java.util.List;

import cn.edu.zucc.qua.pojo.Answer;
/**
* 类说明 
*
* @author  朱子祺
* @date 2020年7月4日  新建
*/
public interface AnswerService {

    /**
     * 发布回答
     * @param answerContent
     * @param answerImage
     * @param bestAnswer
     * @param questionId
     * @param userId
     * @return
     */
    boolean appendAnswer(String answerContent, List<String> answerImage, List<String> bestAnswer, String questionId, String userId);


    /**
     * 删除回答
     * @param answerId
     * @return
     */
    boolean deleteAnswer(String answerId);


    /**
     * 查询单个回答
     * @param answerId
     * @return
     */
    Answer searchSingleAnswer(String answerId);


    /**
     * 修改单个回答
     * @param answerId
     * @param answerContent
     * @param answerImage
     * @return
     */
    boolean alterSingleAnswer(String answerId, String answerContent, List<String> answerImage);
}
