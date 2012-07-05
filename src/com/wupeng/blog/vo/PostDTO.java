package com.wupeng.blog.vo;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

/**
 * @author WuPeng
 * @date 2012.7.5
 * @description 文章或日志表实体
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION,detachable = "true")
public class PostDTO 
{
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY )
	private Key key;
	
	@Persistent
	private UserDTO user;					//作者对象
	
	@Persistent
	private Date createdDate;				//初次发表时间
	
	@Persistent
	private String title;					//题目
	
	@Persistent
	private String content;					//内容
	
	@Persistent
	private String excerpt;					//文章摘要
	
	@Persistent
	private int postStatus;					//文章状态 0删除 1正常 2草稿
	
	@Persistent
	private int comentStatus;				//评论状态 评论设置的状态 0不允许评论 1正常  (待定吧，这个字段应该会用到)

	@Persistent
	private Date modefiedDate;				//文章修改日期
	
	@Persistent
	private String postType;				//文章类型 1文章 2日志
	
	@Persistent
	private long commentCount;				//文章评论次数
	
	@Persistent
	private long browseCount;				//文章浏览次数
	
	@Persistent 
	private Set<Key> labels;				//标签集合
	
	@Persistent(mappedBy = "post")
	private List<CommentDTO> comments;		//评论列表

	public List<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

	public String getExcerpt() {
		return excerpt;
	}

	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}

	public int getPostStatus() {
		return postStatus;
	}

	public void setPostStatus(int postStatus) {
		this.postStatus = postStatus;
	}

	public int getComentStatus() {
		return comentStatus;
	}

	public void setComentStatus(int comentStatus) {
		this.comentStatus = comentStatus;
	}

	public Date getModefiedDate() {
		return modefiedDate;
	}

	public void setModefiedDate(Date modefiedDate) {
		this.modefiedDate = modefiedDate;
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(long commentCount) {
		this.commentCount = commentCount;
	}

	public long getBrowseCount() {
		return browseCount;
	}

	public void setBrowseCount(long browseCount) {
		this.browseCount = browseCount;
	}

	public Set<Key> getLabels() {
		return labels;
	}

	public void setLabels(Set<Key> labels) {
		this.labels = labels;
	}
}