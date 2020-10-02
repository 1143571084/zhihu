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
@Document("question")
public class Question  {
	/**
	 id 
	 */
	@Id
    private String id;                 
	
    /**
            标题
     */
    private String title;              
    
    /**
           主体
     */
    private String content;             
    
    /**
           图片
     */
    private List<String> images;                   
    
    /**
            发布时间
     */
    private  Date createTime;   
    
	/**问题推荐值数*/
    private Double questionRate;  
    
    /**标签*/
    private List<String> tags;         
    
    /**
           点赞数 
     */
    private int likeNumber;    
    
    /**回答数*/
    private int replyNumber;         
      
    /**
            收藏数
     */
    private int collectionNumber;    
    
    /**教师推荐*/
    private List<String> bestQuestion;

    /**user_id*/
    private String userid;

    
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Double getQuestionRate() {
		return questionRate;
	}

	public void setQuestionRate(Double questionRate) {
		this.questionRate = questionRate;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public int getLikeNumber() {
		return likeNumber;
	}

	public void setLikeNumber(int likeNumber) {
		this.likeNumber = likeNumber;
	}

	public int getReplyNumber() {
		return replyNumber;
	}

	public void setReplyNumber(int replyNumber) {
		this.replyNumber = replyNumber;
	}

	public int getCollectionNumber() {
		return collectionNumber;
	}

	public void setCollectionNumber(int collectionNumber) {
		this.collectionNumber = collectionNumber;
	}

	public List<String> getBestQuestion() {
		return bestQuestion;
	}

	public void setBestQuestion(List<String> bestQuestion) {
		this.bestQuestion = bestQuestion;
	}    
         

	
}
