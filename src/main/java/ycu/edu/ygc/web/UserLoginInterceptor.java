package ycu.edu.ygc.web;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;
import ycu.edu.ygc.constant.ServiceCode;
import ycu.edu.ygc.util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author WYJ
 * @software: IntelliJ IDEA
 * @date 2023/4/5 11:04
 */
public class UserLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        //设置编码格式
        response.setCharacterEncoding("UTF-8");
        String jwt = request.getHeader("Authorization");
        if (jwt == null ||jwt.trim().length() == 0) {
            JsonResult<Void> jsonResult = JsonResult.fail(ServiceCode.NO_LOGIN_INFO,"无法获取有效登录信息！");
            String jsonString = JSON.toJSONString(jsonResult);
            PrintWriter writer = response.getWriter();
            writer.println(jsonString);
            writer.close();
            return false;
        }
        String jwtNew = jwt.replace("Bearer ", "");
        Claims claims = JwtUtil.parseJWT(jwtNew);
        if (claims.get("username").equals(request.getSession().getAttribute("username"))) {
            return true;
        }
        JsonResult<Void> jsonResult = JsonResult.fail(ServiceCode.LOGIN_INFO_ERROR,"登录信息有误！");
        String jsonString = JSON.toJSONString(jsonResult);
        PrintWriter writer = response.getWriter();
        writer.println(jsonString);
        writer.close();
        return false;
    }
}
