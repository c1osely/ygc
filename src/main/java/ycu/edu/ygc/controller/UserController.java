package ycu.edu.ygc.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ycu.edu.ygc.constant.ServiceCode;
import ycu.edu.ygc.exception.ServiceException;
import ycu.edu.ygc.pojo.vo.UserVO;
import ycu.edu.ygc.service.UserService;
import ycu.edu.ygc.web.JsonResult;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author WYJ
 * @software: IntelliJ IDEA
 * @date 2023/4/5 9:35
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public JsonResult login(UserVO userVO, HttpSession session) {
        String jwt = "";
        try {
            jwt = userService.login(userVO);
        } catch (ServiceException e) {
            return JsonResult.fail(ServiceCode.BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            return JsonResult.fail(ServiceCode.BAD_REQUEST, "jwt创建失败");
        }
        session.setAttribute("username",userVO.getUsername());
        return JsonResult.ok(jwt);
    }

    @PostMapping("/logon")
    public JsonResult logon(UserVO userVO) {
        try {
            userService.logon(userVO);
        } catch (ServiceException e) {
            return JsonResult.fail(ServiceCode.BAD_REQUEST,e.getMessage());
        }
        return JsonResult.ok("注册成功！");
    }

}
