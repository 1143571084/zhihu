package cn.edu.zucc.qua.dao;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.edu.zucc.qua.pojo.Answer;


/**
* 类说明 
*
* @author 屠哲俊
* @date 2020年7月6日  新建
*/
public interface AnswerDao extends MongoRepository<Answer,Serializable>{

}

