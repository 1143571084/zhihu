package cn.edu.zucc.qua.dao;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import cn.edu.zucc.qua.pojo.Question;

/**
* 接口说明 
*
* @author 屠哲俊
* @date 2020年7月4日  新建
*/
public interface QuestionDao extends MongoRepository<Question,Serializable>{


}
