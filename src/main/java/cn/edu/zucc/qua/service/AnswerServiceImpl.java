package cn.edu.zucc.qua.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.zucc.qua.dao.AnswerDao;
import cn.edu.zucc.qua.dao.QuestionDao;
import cn.edu.zucc.qua.pojo.Answer;
import cn.edu.zucc.qua.pojo.Question;

/**
 * @author tzj
 */
@Service
public class AnswerServiceImpl implements AnswerService {
 
	@Autowired
	private AnswerDao answerDao;
	
	@Autowired
	QuestionDao questionDao;
	
	@Override
    public boolean appendAnswer(String answerContent, List<String> answerImage, List<String> bestAnswer, String questionId, String userId) {
    	Answer answer = new Answer(answerImage, answerContent, null, null, 0, 0, 0, bestAnswer, null, userId, questionId);
    	try {
    		answerDao.save(answer);
    		Question question = new Question();
    		question=questionDao.findById(questionId).orElse(null);  
    		question.setReplyNumber(question.getReplyNumber()+1);
    		questionDao.save(question);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
    	
    	return true;
    }

    @Override
    public boolean deleteAnswer(String answerId) {
    	try {
    		answerDao.deleteById(answerId);
    		
    		Answer answer = answerDao.findById(answerId).orElse(null);
    		Question question = new Question();
    		question=questionDao.findById(answer.getQuestionId()).orElse(null);  
    		question.setReplyNumber(question.getReplyNumber()-1);
    		questionDao.save(question);
    		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
    	
        return true;
    }

    @Override
    public Answer searchSingleAnswer(String answerId) {
    	Answer answer = answerDao.findById(answerId).orElse(null);
        return answer;
    }

    @Override
    public boolean alterSingleAnswer(String answerId, String answerContent, List<String> answerImage) {
//        Answer answer=new Answer(answerId, answerImage, answerContent, null, null, 0, 0, 0, null, null, null, null);
    	try {
			Answer answer=answerDao.findById(answerId).orElse(null);
			answer.setId(answerId);
			answer.setContent(answerContent);
			answer.setImage(answerImage);
			answerDao.save(answer);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
    	return true;
    }
}
