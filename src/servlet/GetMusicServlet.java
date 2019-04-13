package servlet;

//导入必需的 java 库
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Music;

public class GetMusicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Music music;//待发送的Music对象

	public void init() throws ServletException
	  {
		
	  }

	public void doGet(HttpServletRequest request,
	                    HttpServletResponse response)
	            throws ServletException, IOException
	  {
		response.setContentType("text/xml;charset=UTF-8");//设置响应类型为XML
		response.setHeader("Cache-control", "no-cache");//调用
		//从service层调用方法获得Music对象，使用Integer.parseInt将String转换成int
		music=service.MusicService.getMusic(Integer.parseInt(request.getParameter("music_id")));
		
		ServletOutputStream outputStream = response.getOutputStream();//返回的数据流

		StringBuffer buff=new StringBuffer();//缓冲区
		buff.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		//写入music相关数据
		buff.append(
				"<music>"
				+ "<id>"+music.getId()+"</id>"
				+ "<lyrics>"+music.getLyrics()+"</lyrics>"
				+"<groupid>"+music.getGroup_id()+"</groupid>"
				+ "<projectid>"+music.getProject_id()+"</projectid>"
				+"<style>"+music.getStyle()+"</style>"
				+"<like>"+music.getLikes()+"</like>"
				+"<imageurl>"+music.getImage_url()+"</imageurl>"
				+"<musicurl>"+music.getMusic_url()+"</musicurl>"
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
