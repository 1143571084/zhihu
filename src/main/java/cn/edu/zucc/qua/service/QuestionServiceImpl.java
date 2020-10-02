package cn.edu.zucc.qua.service;



import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.zucc.qua.dao.QuestionDao;
import cn.edu.zucc.qua.pojo.Question;
import cn.edu.zucc.qua.util.ResultUtil;

import java.util.Date;
import java.util.List;
import java.util.Optional;
/**
 * @author tzj
 */
@Service
public class QuestionServiceImpl implements QuestionService {


       @Autowired
       QuestionDao questionDao;

    @Override
    public List<Question> showQuestionList() {
        return null;
    }

    @Override
    public Boolean appendQuestion(String questionTitle, String questionContent, List<String> questionImage, String userId) {
    	Question question=new Question();
    	try {
    		question.setTitle(questionTitle);
        	question.setContent(questionContent);
        	question.setImages(questionImage);
        	question.setCreateTime(new Date());
        	question.setQuestionRate(0.0);
        	question.setTags(null);
        	question.setLikeNumber(0);
        	question.setReplyNumber(0);
        	question.setCollectionNumber(0);
        	question.setBestQuestion(null);
        	question.setUserid(userId);
        	questionDao.save(question);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

        return true;
    }

    @Override
    public Question searchSingleQuestion(String questionId) {
    	Question question = new Question();   	
    	question=questionDao.findById(questionId).orElse(null);   		
    	return question;
    }

    @Override
    public Boolean alterSingleQuestion(String questionId, String questionTitle, String questionContent, List<String> questionImage) {
    	Question question =new Question();
    	try {
        	question=questionDao.findById(questionId).orElse(null);  
        	question.setId(questionId);
        	question.setTitle(questionTitle);
        	question.setContent(questionContent);
        	question.setImages(questionImage);
        	questionDao.save(question);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
   	
        return true;
    }

    @Override
    public Boolean deleteQuestion(String questionId) {
    	try {
    		questionDao.deleteById(questionId);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    	
        return true;
    }
}
