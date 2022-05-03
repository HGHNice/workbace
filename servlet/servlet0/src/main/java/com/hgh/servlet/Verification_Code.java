package com.hgh.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author Administrator
 */
public class Verification_Code extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("refresh","3");
        BufferedImage Image = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
        Graphics2D g=(Graphics2D) Image.getGraphics();
        g.setColor(Color.MAGENTA);
        g.fillRect(0,0,80,20);
        g.setColor(Color.CYAN);
        g.setFont(new Font(null,Font.BOLD,20));
        g.drawString(make(),0,20);
        resp.setContentType("image/jpeg");
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        ImageIO.write(Image,"jpg",resp.getOutputStream());
    }
    private String make(){
        Random random = new Random();
        String anInt = random.nextInt(999999)+"";
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < 7-anInt.length(); i++) {
            stringBuffer.append("0");
        }
        anInt=stringBuffer.toString()+anInt;
        return anInt;
    }
}
