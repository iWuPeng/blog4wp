package com.wupeng.blog.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class GetInstanceByBeanName implements ServletContextListener {
	private static String webRoot = "";// 获取web应用的根目录


	@Override
	public void contextInitialized(ServletContextEvent event) {
		beanContext = WebApplicationContextUtils.getWebApplicationContext(event
				.getServletContext());
		webRoot = event.getServletContext().getRealPath("/").replace("\\", "/");
	}

	private static ApplicationContext beanContext = null;

	public static Object getBean(String beanId) {
		return beanContext.getBean(beanId);
	}

	public void destroy() {
	}

	/**
	 * @return the webRoot
	 */
	public static String getWebRoot() {
		return webRoot;
	}

	// junit 用，其他地方请斟酌使用。
	public static void setBeanContext(ApplicationContext beanContext) {
		GetInstanceByBeanName.beanContext = beanContext;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

}