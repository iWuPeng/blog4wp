package com.wupeng.blog.vo;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

/**
 * @author WuPeng
 * @date    2012.7.5
 * @description 文章评论附属表实体
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION,detachable = "true")
public class CommentmetaDTO 
{
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY )
	private Key key;
	
	@Persistent
	private CommentDTO comment;				//所属评论对象
	
	@Persistent
	private String metaKey;					//元信息键值
	
	@Persistent
	private String metaValue;				//元信息的详细值

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public CommentDTO getComment() {
		return comment;
	}

	public void setComment(CommentDTO comment) {
		this.comment = comment;
	}

	public String getMetaKey() {
		return metaKey;
	}

	public void setMetaKey(String metaKey) {
		this.metaKey = metaKey;
	}

	public String getMetaValue() {
		return metaValue;
	}

	public void setMetaValue(String metaValue) {
		this.metaValue = metaValue;
	}
}
