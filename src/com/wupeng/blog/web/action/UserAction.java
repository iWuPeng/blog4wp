package com.wupeng.blog.web.action;

import java.util.Date;
import java.util.List;

import com.wupeng.blog.dao.IUserDao;
import com.wupeng.blog.dao.jdoimp.UserDao;
import com.wupeng.blog.vo.UserTestDTO;

/**
 * @author WuPeng
 * @date 2012.7.3
 * @description 关于用户实体（测试）的动作跳转类
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
		List<UserTestDTO> userList = userDao.getAllUser();
		request.setAttribute("userList", userList);
		
		return "listUser";
	}
	
	public String addUser()
	{
		UserTestDTO user = new UserTestDTO();
		user.setLoginName("wuPeng");
		user.setNickName("xiaofe");
		user.setPassword("sssd");
		user.setRegisteredTime(new Date());
		user.setStatus("0");
		userDao.saveUser(user);
		
		return listUser();
	}
}
