package com.wupeng.blog.dao.jdoimp;

import java.util.List;

import javax.jdo.Query;

import org.springframework.orm.jdo.support.JdoDaoSupport;

import com.wupeng.blog.dao.IUserDao;
import com.wupeng.blog.vo.UserDTO;
import com.wupeng.blog.vo.UserTestDTO;

/**
 * @author WuPeng
 * @date 2012.7.7
 * @description 用户实体数据区访问类
 */
public class UserDao extends JdoDaoSupport implements IUserDao {

	@Override
	public void saveUser(UserDTO user) {
		// TODO Auto-generated method stub
		getJdoTemplate().makePersistent(user);
	}

	@Override
	public List<UserDTO> getAllUser() {
		// TODO Auto-generated method stub
		Query query = getPersistenceManager().newQuery(UserDTO.class);
		query.setOrdering("loginName DESC");
		query.setRange(0,5);
		Object result = query.execute();
		query.close(result);
		
		return (result == null)?null:(List<UserDTO>)result;	
	}

}
