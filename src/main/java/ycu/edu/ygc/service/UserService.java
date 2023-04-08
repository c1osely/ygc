package ycu.edu.ygc.service;

import ycu.edu.ygc.exception.ServiceException;
import ycu.edu.ygc.pojo.vo.UserVO;

/**
 * @author WYJ
 * @software: IntelliJ IDEA
 * @date 2023/4/4 22:37
 */
public interface UserService {

    /**
     * 用户登录
     * @param userVO vo
     * @return jwt
     */
    String login(UserVO userVO) throws Exception;

    /**
     * 用户注册
     * @param userVO vo
     */
    void logon(UserVO userVO) throws ServiceException;

}
