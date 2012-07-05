package com.wupeng.blog.vo;

import java.util.Date;
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
 * @description 标签表实体
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION,detachable = "true")
public class LevelDTO 
{
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY )
	private Key key;
	
	private String content;					//标签内容
	
	private Date createDate;				//编辑创建时间
	
	private Set<Key> posts;					//标签所含文章

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Set<Key> getPosts() {
		return posts;
	}

	public void setPosts(Set<Key> posts) {
		this.posts = posts;
	}
}
