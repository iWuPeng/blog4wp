package com.wupeng.blog.vo;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

/**
 * @author WuPeng
 * @date 2012.7.5
 * @description 评论表
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION,detachable = "true")
public class CommentDTO 
{
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY )
	private Key key;
	
	@Persistent
	private PostDTO post;					//评论对应文章
	
	@Persistent
	private UserDTO	user;					//评论者对象，如果是游客，则为空
	
	@Persistent
	private String author;					//评论的游客姓名
	
	@Persistent
	private String authorUrl;				//评论游客个人网址
	
	@Persistent 
	private String authorIP;				//评论游客IP地址
	
	@Persistent
	private String authorEmail;				//评论者邮箱
	
	@Persistent
	private Date createDate;				//评论日期
	
	@Persistent
	private String content;					//评论内容
	
	@Persistent
	private int status;						//0删除评论 1正常评论，未审核  2正常评论，已审核  ,用户评论默认为2
	
	@Persistent
	private Key parent;						//父级评论,文章评论则为空

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public PostDTO getPost() {
		return post;
	}

	public void setPost(PostDTO post) {
		this.post = post;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthorUrl() {
		return authorUrl;
	}

	public void setAuthorUrl(String authorUrl) {
		this.authorUrl = authorUrl;
	}

	public String getAuthorIP() {
		return authorIP;
	}

	public void setAuthorIP(String authorIP) {
		this.authorIP = authorIP;
	}

	public String getAuthorEmail() {
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Key getParent() {
		return parent;
	}

	public void setParent(Key parent) {
		this.parent = parent;
	}
}
