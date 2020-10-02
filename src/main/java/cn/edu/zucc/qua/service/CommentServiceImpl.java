package cn.edu.zucc.qua.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.zucc.qua.dao.AnswerDao;
import cn.edu.zucc.qua.dao.QuestionDao;
import cn.edu.zucc.qua.pojo.Answer;
import cn.edu.zucc.qua.pojo.Comment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author tzj
 */
@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    AnswerDao answerDao;


    @Override
    public boolean appendComment(String answerId, String commentContent, String userId) {
    	Answer answer = new Answer();
    	Comment comment = new Comment(userId, commentContent, new Date(), 0, null , answerId);
    	try {
    		answer=answerDao.findById(answerId).orElse(null); 
    	    answer.getComments().add(comment);
    	    answerDao.save(answer);
		} catch (Exception e) {	
			e.printStackTrace();
			return false;
		}
            return true;
    }

    @Override
    public boolean deleteComment(String commentId, String answerId) {
    	Answer answer = new Answer();
    	try {
    	 answer = answerDao.findById(answerId).orElse(null);
           if(answer == null) {
        	   return false;
           }
            else {
                List<Comment> listcComments = answer.getComments();
                boolean flag = false;
                for(Comment comment : listcComments) {
                    if(commentId.equals(comment.getId())) {
                        flag = true;
                        listcComments.remove(comment);
                        break;
                    }
                }
                if(!flag) {
                    return false;
                }
                answerDao.save(answer);
            }

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
        return true;
    }

    @Override
    public boolean replyComment(String answerId, String commentId, String commentContent, String userId) {
         Answer answer = new Answer();
         try {
			answer=answerDao.findById(answerId).orElse(null);
			if(answer == null) {
				return false;
			}
			else {
				Comment comment =new Comment(userId, commentContent, new Date(), 0, commentId, answerId);
				answer.getComments().add(comment);
	            answerDao.save(answer);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
         return true;
    }
}
