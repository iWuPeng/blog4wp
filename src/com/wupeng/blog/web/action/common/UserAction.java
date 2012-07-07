package com.wupeng.blog.web.action.common;

import java.util.Date;
import java.util.List;

import com.wupeng.blog.dao.IUserDao;
import com.wupeng.blog.vo.UserDTO;
import com.wupeng.blog.web.action.BaseAction;

/**
 * @author WuPeng
 * @date 2012.7.7
 * @description 关于用户实体的动作跳转类
 */
public class UserAction extends BaseAction 
{
	private IUserDao userDao;

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * @description  获得所有用户列表，跳转到显示页面
	 * @return 
	 */
	public String listUser()
	{
		List<UserDTO> userList = userDao.getAllUser();
		request.setAttribute("userList", userList);
		
		return "listUser";
	}
	
	public String addUser()
	{
		UserDTO user = new UserDTO();
		user.setLoginName("admin");
		user.setEmail("null.wp@gmail.com");
		user.setNickName("iWuPeng");
		user.setPassword("wppeng");
		user.setRegisteredTime(new Date());
		user.setStatus(1);
		user.setType(0);
		user.setUrl("www.iwupeng.com");
		userDao.saveUser(user);
		
		return listUser();
	}
}
