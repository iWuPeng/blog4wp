package com.wupeng.blog.web.action.test;

import java.util.Date;
import java.util.List;

import com.wupeng.blog.dao.IUserTestDao;
import com.wupeng.blog.vo.UserTestDTO;
import com.wupeng.blog.web.action.BaseAction;

/**
 * @author WuPeng
 * @date 2012.7.3
 * @description 关于用户实体（测试）的动作跳转类
 */
public class UserTestAction extends BaseAction
{
	private IUserTestDao userTestDao;
	
	public IUserTestDao getUserTestDao() {
		return userTestDao;
	}

	public void setUserTestDao(IUserTestDao userTestDao) {
		this.userTestDao = userTestDao;
	}

	/**
	 * @description  获得所有用户列表，跳转到显示页面
	 * @return 
	 */
	public String listUser()
	{
		List<UserTestDTO> userList = userTestDao.getAllUser();
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
		userTestDao.saveUser(user);
		
		return listUser();
	}
}
