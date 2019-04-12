package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;

public class GetUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	public void doGet(HttpServletRequest request,
            HttpServletResponse response)
    throws ServletException, IOException
	{
		response.setContentType("text/xml;charset=UTF-8");//设置响应类型为XML
		response.setHeader("Cache-control", "no-cache");//调用
		//从service层调用方法获得User对象，使用Integer.parseInt将String转换成int
		user=service.MusicService.getUser(Integer.parseInt(request.getParameter("user_id")));

		ServletOutputStream outputStream = response.getOutputStream();//返回的数据流

		StringBuffer buff=new StringBuffer();//缓冲区
		buff.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		//写入music相关数据
		buff.append(
				"<user>"
						+ "<id>"+user.getId()+"</id>"
						+ "<name>"+user.getName()+"</name>"
						+ "<nickname>"+user.getNickName()+"</niackname>"
						+ "<password>"+user.getPassword()+"</password>"
						+"<gender>"+user.getGender()+"</gender>"
						+"<email>"+user.getEmail()+"</email>"
						+"<address>"+user.getAddress()+"</address>"
						+"<signature>"+user.getSignature()+"</signatrue>"
						+"<imageurl>"+user.getImageUrl()+"</imageurl>"
						+"<introduction>"+user.getIntroduction()+"</introduction>"
						+"</music>");
		//发送
		outputStream.write(buff.toString().getBytes("utf-8"));
		outputStream.flush();
		outputStream.close();

	}

	// 处理 POST 方法请求的方法
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void destroy()
	{

	}
}
