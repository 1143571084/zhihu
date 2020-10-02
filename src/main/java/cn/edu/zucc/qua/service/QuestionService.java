package cn.edu.zucc.qua.service;

/**
* 类说明 
*
* @author 屠哲俊
* @date 2020年7月4日  新建
*/

import java.util.List;

import org.bson.types.ObjectId;

import cn.edu.zucc.qua.pojo.Question;

public interface QuestionService {


    /**
     * 显示问题列表
     * @return
     */
    List<Question> showQuestionList();

    /**
     * 发布问题
     * @param questionTitle
     * @param questionContent
     * @param questionImage
     * @param userId
     * @return
     */
    Boolean appendQuestion(String questionTitle, String questionContent, List<String> questionImage, String userId);


    /**
     * 查询单个问题
     * @param questionId
     * @return
     */
    Question searchSingleQuestion(String questionId);


    /**
     * 修改单个问题
     * @param questionId
     * @param questionTitle
     * @param questionContent
     * @param questionImage
     * @return
     */
    Boolean alterSingleQuestion(String questionId, String questionTitle, String questionContent, List<String> questionImage);


    /**
     * 删除问题
     * @param questionId
     * @return
     */
    Boolean deleteQuestion(String questionId);


}
