package cn.edu.zucc.qua.pojo;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
* 类说明 
*
* @author 屠哲俊
* @date 2020年7月4日  新建
*/

public class Comment {
	/**
	 id 
	 */
	@Id
    private String id;              
	
    /**
     userId 
     */
    private String userId;         
    
    /**
          主体
     */
    private String content;           
    
    /**
          发布时间
     */
    private Date createTime;              
    
    /**
          点赞数
     */
    private int likeNumber;          
    
    /**
           被评论id
     */
    private String commentId;       
    
    /**
    answerId
    */
    private String answerId;
    
    
    

	public Comment(String userId, String content, Date createTime, int likeNumber, String commentId,
			String answerId) {
		super();		
		this.id=String.valueOf(new ObjectId());
		this.userId = userId;
		this.content = content;
		this.createTime = createTime;
		this.likeNumber = likeNumber;
		this.commentId = commentId;
		this.answerId = answerId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getLikeNumber() {
		return likeNumber;
	}

	public void setLikeNumber(int likeNumber) {
		this.likeNumber = likeNumber;
	}



	public String getCommentId() {
		return commentId;
	}

	public void setCommentID(String commentId) {
		this.commentId = commentId;
	}

	public String getAnswerId() {
		return answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}    


}
