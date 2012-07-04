package com.wupeng.blog.dao.jdoimp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.jdo.JDOException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.orm.jdo.JdoCallback;
import org.springframework.orm.jdo.support.JdoDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wupeng.blog.dao.IUserDao;
import com.wupeng.blog.vo.UserDTO;

@Repository
@Transactional(readOnly = false)
public class UserTestDao extends JdoDaoSupport implements IUserDao {

	@Override
	@Transactional
	public boolean saveUser(UserDTO user) {
		getJdoTemplate().makePersistent(user);
		return true;
	}

	@Override
	@Transactional(readOnly=true)
	 @SuppressWarnings("unchecked")
	public List<UserDTO> getAllUser() 
	{
		return (List<UserDTO>)getJdoTemplate().executeFind(new JdoCallback() {
			
			@Override
			public Object doInJdo(PersistenceManager pm) throws JDOException {
				Query query = pm.newQuery(UserDTO.class);
				query.setRange(0,5);
				Object result =  query.execute();	
				return result ;
			}
		});
	}
	
}
