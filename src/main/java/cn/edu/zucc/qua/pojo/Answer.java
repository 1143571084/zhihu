package cn.edu.zucc.qua.pojo;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
* 类说明 
*
* @author 屠哲俊
* @date 2020年7月4日  新建
*/
@Document("answer")
public class Answer {
	
	/**id*/
	@Id
    private String id;    
	
	/**图片*/
    private List<String> image; 
    
    /**主体*/
    private String content;       
    
    /**发布时间*/
    private Date time;
    
    /**上一次修改时间*/
    private Date updateTime; 
    
    /**点赞数*/
    private int likeNumber;         
        
    /**收藏数*/
    private int collectNumber;        
    
    /**回答推荐值*/
    private double answerRate;      
    
    /**教师推荐*/
    private List<String> bestAnswer; 
    
    /**评论*/
    private List<Comment> comments; 
    
    /**用户id*/
    private String userId;
    
    /**问题id*/
    private String questionId;
    
    
    public Answer() {
    	
	}

	public Answer(List<String> image, String content, Date time, Date updateTime, int likeNumber,
			int collectNumber, double answerRate, List<String> bestAnswer, List<Comment> comments, String userId,
			String questionId) {
		super();
		this.image = image;
		this.content = content;
		this.time = time;
		this.updateTime = updateTime;
		this.likeNumber = likeNumber;
		this.collectNumber = collectNumber;
		this.answerRate = answerRate;
		this.bestAnswer = bestAnswer;
		this.comments = comments;
		this.userId = userId;
		this.questionId = questionId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getImage() {
		return image;
	}

	public void setImage(List<String> image) {
		this.image = image;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getLikeNumber() {
		return likeNumber;
	}

	public void setLikeNumber(int likeNumber) {
		this.likeNumber = likeNumber;
	}


	public int getCollectNumber() {
		return collectNumber;
	}

	public void setCollectNumber(int collectNumber) {
		this.collectNumber = collectNumber;
	}

	public double getAnswerRate() {
		return answerRate;
	}

	public void setAnswerRate(double answerRate) {
		this.answerRate = answerRate;
	}

	public List<String> getBestAnswer() {
		return bestAnswer;
	}

	public void setBestAnswer(List<String> bestAnswer) {
		this.bestAnswer = bestAnswer;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	
    
    
    
}
