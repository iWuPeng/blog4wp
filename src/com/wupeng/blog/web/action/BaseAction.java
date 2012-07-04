package com.wupeng.blog.web.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.web.struts.ActionSupport;

/**
 * @author WuPeng
 * @date 2012.7.3
 * @description 基础action类，所有action基于该类实现，通用功能都可以配置在该类下
 *
 */
public class BaseAction extends ActionSupport
implements SessionAware,ServletContextAware,ServletResponseAware,ServletRequestAware
{

protected HttpServletRequest request;
protected HttpServletResponse response;
protected Map<String,Object> session;
protected ServletContext application;
//private PageResult pageResult = new PageResult();
protected Map<String,Object> req = new HashMap<String, Object>();

public Map<String, Object> getReq() {
	return req;
}
public void setReq(Map<String, Object> req) {
	this.req = req;
}
public ServletContext getApplication() {
	return application;
}
public void setApplication(ServletContext application) {
	this.application = application;
}
/*
public PageResult getPageResult() {
	return pageResult;
}
public void setPageResult(PageResult pageResult) {
	this.pageResult = pageResult;
}
*/
public HttpServletResponse getResponse() {
	return response;
}
public void setResponse(HttpServletResponse response) {
	this.response.setCharacterEncoding("utf-8");
	this.response = response;
}
public Map<String, Object> getSession() {
	return session;
}
public void setSession(Map<String, Object> session) 
{
	this.session = session;
}
public void setServletContext(ServletContext application) 
{
	this.application = application;
}
public void setServletResponse(HttpServletResponse response) 
{
	response.setCharacterEncoding("utf-8");
	this.response = response;
}
public void setServletRequest(HttpServletRequest request) 
{
	this.request = request;
}
public HttpServletRequest getRequest() {
	return request;
}
public void setRequest(HttpServletRequest request) {
	this.request = request;
}

}
