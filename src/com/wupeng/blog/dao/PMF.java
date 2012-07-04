package com.wupeng.blog.dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

/**
 * @author WuPeng
 * @date   2012.7.3
 * @description	通过jdo获得数据存储区
 */
public class PMF 
{
	private static final PersistenceManagerFactory pmfInstance = 
			JDOHelper.getPersistenceManagerFactory("transactions-optional");
	
	private PMF(){}
	
	public static PersistenceManagerFactory get()
	{
		return pmfInstance;
	}
}
