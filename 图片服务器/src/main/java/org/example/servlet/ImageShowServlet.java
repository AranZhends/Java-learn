package org.example.servlet;

import org.example.dao.ImageDAO;
import org.example.model.Image;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/imageShow")
public class ImageShowServlet extends HttpServlet {


    private static final Set<String> whitelist = new HashSet<>();

    static {
        //白名单允许获取图片内容，还可以设计为白名单+黑名单的方式
        //白名单防盗链
        whitelist.add("http://localhost:8080/java_image_server/index.html");
        whitelist.add("http://localhost:8080/java_image_server/");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //拿到头信息
        String referer = req.getHeader("Referer");
        if(!whitelist.contains(referer)) {
            //白名单不包含当前请求的referer，不允许访问
            resp.setStatus(403);
            //TODO:可以设置响应体数据
            return;
        }
        //解析请求数据:imageId
        String id = req.getParameter("imageId");
        //业务处理 1.通过id查看图片的path字段 2.通过path找本地图片文件
        Image image = ImageDAO.queryOne(Integer.parseInt(id));
        //图片是以二进制数据放在body，同事要指定content-type
        resp.setContentType(image.getContentType());
        //本地图片的绝对路径
        String path = ImageServlet.IMAGE_DIR + image.getPath();
        //io输入流读文件
        FileInputStream fis = new FileInputStream(path);
        //返回响应:服务器本地图片的二进制数据
        OutputStream os = resp.getOutputStream();//输出流都是输出到body
        byte[] bytes = new byte[1024*8];
        int len;
        while ((len=fis.read(bytes))!=-1) {
            os.write(bytes,0,len);
        }
        //刷新缓冲区
        os.flush();
        fis.close();
        os.close();
    }
}
