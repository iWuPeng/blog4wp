package com.wupeng.blog.dao;

import java.util.List;

import com.wupeng.blog.vo.UserTestDTO;

/**
 * @author WuPeng
 * @date   2012.7.3
 * @description 用户实体（测试）数据区访问接口
 */
public interface IUserTestDao
{
	/**
	 * @description 新增用户记录
	 * @param user 用户实体
	 * @return	是否保存成功
	 */
	boolean saveUser(UserTestDTO user);
	
	/**
	 * @description	获得所有用户
	 * @return  用户列表
	 */
	List<UserTestDTO> getAllUser();
}
