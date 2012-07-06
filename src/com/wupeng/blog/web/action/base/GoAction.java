package com.wupeng.blog.web.action.base;

import com.wupeng.blog.web.action.BaseAction;

/**
 * @author WuPeng
 * @date 2012.7.6
 * @description 常用的跳转
 */
public class GoAction extends BaseAction 
{	
	/**
	 * @description 跳转至登录页面
	 * @return 登录页面对应值
	 */
	public String toLogin()
	{
		return "login";
	}
}
