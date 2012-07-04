package com.wupeng.blog.dao.jdoimp;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.wupeng.blog.dao.IUserDao;
import com.wupeng.blog.dao.PMF;
import com.wupeng.blog.vo.UserDTO;

/**
 * @author WuPeng
 * @date 2012.7.3
 * @description 用户实体（测试）数据区访问的jdo实现
 */
public class UserDao implements IUserDao 
{
	private PersistenceManager pm;
	
	@Override
	public boolean saveUser(UserDTO user) 
	{
		pm = PMF.get().getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try 
		{
			tx.begin();
			pm.makePersistent(user);
			tx.commit();
		}
		catch (Exception e) 
		{
			if(tx.isActive())
			{
				tx.rollback();
				return false;
			}
		}
		finally
		{
			pm.close();
		}
		
		return false;
	}

	@Override
	public List<UserDTO> getAllUser() 
	{
		pm = PMF.get().getPersistenceManager();
		String jdoSql = "SELECT FROM com.wupeng.blog.vo.UserDTO";
		Query query = pm.newQuery(jdoSql);
		Object result = query.execute();
		
		return (result == null)?null:(List<UserDTO>)result;
	}

}
