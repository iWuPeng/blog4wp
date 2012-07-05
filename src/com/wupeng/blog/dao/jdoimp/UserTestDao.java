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

/**
 * @author WuPeng
 * @date 2012.7.3
 * @description 通过Spring注入的Userdao
 */
@Repository
@Transactional(readOnly = false)
public class UserTestDao extends JdoDaoSupport implements IUserDao 
{
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
		Query query = getPersistenceManager().newQuery(UserDTO.class);
		query.setOrdering("loginName DESC");
		query.setRange(0,5);
		Object result = query.execute();
		query.close(result);
		
		return (result == null)?null:(List<UserDTO>)result;	
		/*
		 * 直接使用jdoTemplate来查询，结构为空。但是通过获得PersistenceManager来做查询则没有问题，
		 * 我想，这应该是和jdoTemplate有关，确切的说应该是和Spring对jdo的整合有关，gae可能不支持
		 * 但是也发现一个有意思的问题，使用jdoTemplate同时使用打断点，则正常
		 */
		
//		return (List<UserDTO>)getJdoTemplate().executeFind(new JdoCallback() {
//			
//			@Override
//			public Object doInJdo(PersistenceManager pm) throws JDOException {
//				//Query query = pm.newQuery(UserDTO.class);
//				
//				String jdoSql = "SELECT FROM com.wupeng.blog.vo.UserDTO";
//				Query query = pm.newQuery(jdoSql);
//				Object result = query.execute();
//				
////				query.setOrdering("loginName DESC");
////				query.setRange(0,5);
////				Collection result =  (Collection)query.execute();	
////				query.close(result);
//				return result ;
//			}
//		});
	}
	
}
