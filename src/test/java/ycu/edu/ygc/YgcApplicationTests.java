package ycu.edu.ygc;

import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ycu.edu.ygc.exception.ServiceException;
import ycu.edu.ygc.pojo.vo.UserVO;
import ycu.edu.ygc.service.UserService;
import ycu.edu.ygc.util.JwtUtil;
import ycu.edu.ygc.util.UUIDUtils;

import javax.annotation.Resource;
import java.util.UUID;

@SpringBootTest
class YgcApplicationTests {

    @Resource
    private UserService userService;

    @Test
    void login() {
        UserVO userVO = new UserVO();
        userVO.setUsername("hello");
        userVO.setPassword("hello");
        try {
            String login = userService.login(userVO);
            System.out.println(login);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void logon() {
        UserVO userVO = new UserVO();
        userVO.setUsername("hello");
        userVO.setPassword("hello");
        userVO.setUid(UUIDUtils.getUUID());
        userVO.setPhone("1231231321");
        try {
            userService.logon(userVO);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testParse(){
        Claims claims = JwtUtil.parseJWT("eyJhbGciOiJIUzI1NiIsInppcCI6IkRFRiJ9.eNoUylsKgCAQRuG9zLNCzi-jtButkQK7UARBtPcMztPhe-iaR-oJQJIYipU0svUQtTGXbNXHQQoCZz-QoX3aVm3cMf7Ark29d-qdRMcBncDQdeqxpuWHk9a60fsBAAD__w.BuNdlqtWdmrPKYaOpfmzqFOtY4ptWzRJPJSOZ9LXk34");
        System.out.println(claims.getExpiration());
        System.out.println(claims.get("username"));
    }

}
