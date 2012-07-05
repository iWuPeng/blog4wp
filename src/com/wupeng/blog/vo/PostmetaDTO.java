package com.wupeng.blog.vo;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

/**
 * @author WuPeng
 * @date 2012.7.5
 * @description 文章表附属表实体 ，存储一些其他非固定属性，比如图片
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION,detachable = "true")
public class PostmetaDTO 
{
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY )
	private Key key;

	@Persistent
	private PostDTO post;					//所属文章
	
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

	public PostDTO getPost() {
		return post;
	}

	public void setPost(PostDTO post) {
		this.post = post;
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
