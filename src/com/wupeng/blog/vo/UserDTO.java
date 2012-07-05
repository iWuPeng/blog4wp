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
 * @description 用户表实体
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION,detachable = "true")
public class UserDTO 
{
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY )
	private Key key;
	
	@Persistent
	private String loginName;				//登录名
	
	@Persistent
	private String password;				//登录密码
	
	@Persistent
	private String nickName;				//昵称
	
	@Persistent
	private String email;					//邮箱
	
	@Persistent
	private String url;						//个人主页地址
	
	@Persistent
	private Date registeredTime;			//注册时间
	
	@Persistent
	private int type;						//用户类型  1超级管理员 2普通管理员 3普通用户
	
	@Persistent
	private int status;						//状态  0删除  1正常  2禁言

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getRegisteredTime() {
		return registeredTime;
	}

	public void setRegisteredTime(Date registeredTime) {
		this.registeredTime = registeredTime;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
