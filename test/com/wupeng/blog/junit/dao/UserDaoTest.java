package com.wupeng.blog.junit.dao;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.AbstractTransactionalSpringContextTests;

import com.wupeng.blog.dao.IUserDao;
import com.wupeng.blog.dao.jdoimp.UserDao;
import com.wupeng.blog.util.Constant;
import com.wupeng.blog.util.SpringUtil;
import com.wupeng.blog.vo.UserDTO;

public class UserDaoTest extends AbstractTransactionalSpringContextTests 
{
	private IUserDao userDao;
	
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}


	
	public void testSaveUser()
	{	
		UserDTO user = new UserDTO();
		user.setLoginName("Test Wu");
		user.setEmail("xiaowu@null.com");
		user.setNickName("xiao wu");
		user.setPassword("ddd");
		user.setRegisteredTime(new Date());
		user.setStatus(1);
		user.setType(0);
		user.setUrl("www.wupeng.com");
		userDao.saveUser(user);
	}
	

	@Override
	protected String[] getConfigLocations() {
		// TODO Auto-generated method stub
		return new String[]{"classpath:"+Constant.APPLICATION_PATH};
	}
	
}
