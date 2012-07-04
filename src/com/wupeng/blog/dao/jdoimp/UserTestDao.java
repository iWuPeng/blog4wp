package com.wupeng.blog.dao.jdoimp;

import java.util.Collection;
import java.util.List;

import org.springframework.orm.jdo.support.JdoDaoSupport;

import com.wupeng.blog.dao.IUserDao;
import com.wupeng.blog.vo.UserDTO;

public class UserTestDao extends JdoDaoSupport implements IUserDao {

	@Override
	public boolean saveUser(UserDTO user) {
		getJdoTemplate().makePersistent(user);
		return true;
	}

	@Override
	public List<UserDTO> getAllUser() {
		Collection result = getJdoTemplate().find(UserDTO.class);
		return (result == null)?null:(List<UserDTO>)result;
	}

}
