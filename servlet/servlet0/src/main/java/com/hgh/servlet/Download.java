package com.hgh.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author hgh
 */
public class Download extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        1,获取文件url地址
        2，进行字符串分割 最后一个//后面就是图片地址
        3，setheader 设置文件编码 防止中文编码下载时显示乱码
        4，
        * */
        String path ="D:\\idea workbace\\servlet\\servlet0\\target\\classes\\1.png";
        String name= path.substring(path.lastIndexOf("\\")+1);
        resp.setHeader("Content-Disposition","attachment;filename"+ URLEncoder.encode(name,"UTF-8"));
        FileInputStream in =new FileInputStream(path);
        int len=0;
        byte[] bytes = new byte[1024];
        ServletOutputStream out = resp.getOutputStream();
        while ((len=in.read(bytes))>0){
            out.write(bytes,0,len);
        }
        in.close();
        out.close();



    }
}
