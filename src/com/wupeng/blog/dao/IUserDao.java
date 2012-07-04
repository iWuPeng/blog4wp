package com.wupeng.blog.dao;

import java.util.List;

import com.wupeng.blog.vo.UserDTO;

/**
 * @author WuPeng
 * @date   2012.7.3
 * @description 用户实体（测试）数据区访问接口
 */
public interface IUserDao
{
	/**
	 * @description 新增用户记录
	 * @param user 用户实体
	 * @return	是否保存成功
	 */
	boolean saveUser(UserDTO user);
	
	/**
	 * @description	获得所有用户
	 * @return  用户列表
	 */
	List<UserDTO> getAllUser();
}
