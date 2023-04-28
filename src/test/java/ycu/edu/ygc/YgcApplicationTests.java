package ycu.edu.ygc;

import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ycu.edu.ygc.exception.ServiceException;
import ycu.edu.ygc.mapper.GoodsMapper;
import ycu.edu.ygc.pojo.vo.CategoryVO;
import ycu.edu.ygc.pojo.vo.GoodVO;
import ycu.edu.ygc.pojo.vo.SuppliersVO;
import ycu.edu.ygc.pojo.vo.UserVO;
import ycu.edu.ygc.service.CategoryService;
import ycu.edu.ygc.service.StoragesService;
import ycu.edu.ygc.service.UserService;
import ycu.edu.ygc.util.JwtUtil;
import ycu.edu.ygc.util.UUIDUtils;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class YgcApplicationTests {

    @Resource
    private UserService userService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private StoragesService storagesService;
    @Resource
    private GoodsMapper goodsMapper;

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

    @Test
    void testCategoryService() throws ServiceException {
//        CategoryVO categoryVO = new CategoryVO();
//        categoryVO.setCategoryId(3);
//        categoryVO.setCategoryEnabled(1);
//        categoryVO.setCategoryName("23131313");
//        categoryService.addOrUpdateCategory(categoryVO);
//        categoryService.deleteCategory(categoryVO);
        List<CategoryVO> categoryVOS = categoryService.listCategory();
        System.out.println(categoryVOS.toString());
    }

    @Test
    void testSuppliers() throws ServiceException, ParseException {
        GoodVO goodVO = new GoodVO();
        Date date = new Date();
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
//        rightNow.add(Calendar.YEAR,-1);//日期减1年
//        rightNow.add(Calendar.MONTH,3);//日期加3个月
        rightNow.add(Calendar.DAY_OF_YEAR,+1000);//日期加10天
        Date time = rightNow.getTime();
        goodVO.setGLife(time);
        List<GoodVO> goodVOS = goodsMapper.checkDate(goodVO);
        System.out.println(goodVOS.toString());
    }
}
