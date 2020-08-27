package online.luffyk.studentsystem.controller;

import online.luffyk.studentsystem.utils.CodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Map;

@Controller
public class CaptureController {
    private Logger logger = LoggerFactory.getLogger(CaptureController.class);
    @RequestMapping("getCapture")
    public String getCapture(HttpServletRequest req, HttpServletResponse resp){
        Map<String, Object> codeAndPic = CodeUtil.generateCodeAndPic();
        String code = codeAndPic.get("code").toString();
        RenderedImage codePic = (RenderedImage) codeAndPic.get("codePic");
        logger.debug("code:"+code);
        logger.debug("codePic:"+codePic);
        HttpSession session = req.getSession();
        //将验证码的codec存放到session中
        session.setAttribute("code",code);
        //禁止使用缓存
        resp.setHeader("Pragma","no-cache");
        resp.setHeader("Cache-Control","no-cache");
        resp.setDateHeader("Expires",-1);
        resp.setContentType("image/jpeg");
        //通过流，将图片输出到浏览器上
        try {
            ServletOutputStream outputStream = resp.getOutputStream();
            ImageIO.write(codePic,"jpeg",outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
