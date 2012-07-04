package com.wupeng.blog.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wupeng.blog.dao.IUserDao;
import com.wupeng.blog.dao.jdoimp.UserDao;
import com.wupeng.blog.vo.UserDTO;

/**
 * @author WuPeng
 * @date 2012.7.3
 * @description 新增用户servlet
 */
public class AddUser extends HttpServlet 
{
	private static final long serialVersionUID = 3138030416339196071L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		IUserDao userDao = new UserDao();
		UserDTO user = new UserDTO();
		user.setLoginName(request.getParameter("loginName"));
		user.setNickName(request.getParameter("nickName"));
		user.setPassword(request.getParameter("password"));
		user.setStatus("0");
		user.setRegisteredTime(new Date());
		PrintWriter out = response.getWriter();
		
		if(userDao.saveUser(user))
			out.write("<script type='text/javascript' charset='UTF-8'>alert('success!');</script>");
		else
			out.write("<script type='text/javascript' charset='UTF-8'>alert('fail!');</script>");
		
		List<UserDTO> userList = userDao.getAllUser();
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/listUser.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
