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
 * @description 用户表附属表实体，用于扩展user表
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION,detachable = "true")
public class UsermetaDTO 
{
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY )
	private Key key;
	
	private UserDTO user;					//元信息对应的用户
	
	private String metaKey;					//元信息关键字
	
	private String metaValue;				//元信息的详细值

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
