package ycu.edu.ygc.service.impl;

import org.springframework.stereotype.Service;
import ycu.edu.ygc.exception.ServiceException;
import ycu.edu.ygc.mapper.UsersMapper;
import ycu.edu.ygc.pojo.entity.Users;
import ycu.edu.ygc.pojo.vo.UserVO;
import ycu.edu.ygc.service.UserService;
import ycu.edu.ygc.util.JwtUtil;
import ycu.edu.ygc.util.Md5Utils;
import ycu.edu.ygc.util.UUIDUtils;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author WYJ
 * @software: IntelliJ IDEA
 * @date 2023/4/4 23:33
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public String login(UserVO userVO) throws Exception {
        Users users = usersMapper.selectByUsername(userVO);
        if (users == null) {
            throw new ServiceException("用户名或密码错误！");
        }
        String password = userVO.getPassword();
        if (password != null) {
            if (users.getPassword().equals(Md5Utils.getMd5Password(password))) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("username",users.getUsername());
                map.put("uid",users.getUid());
                map.put("phone",users.getPhone());
                return JwtUtil.createJWT(users.getUid(), "ygc", JwtUtil.ttlMillis, map);
            }
        }
        throw new ServiceException("用户名或密码错误！");
    }

    @Override
    public void logon(UserVO userVO) throws ServiceException {
        Users users = usersMapper.selectByUsername(userVO);
        if (users != null) {
            throw new ServiceException("用户名已存在");
        }
        userVO.setUid(UUIDUtils.getUUID());
        String password = userVO.getPassword();
        userVO.setPassword(Md5Utils.getMd5Password(password));
        int insert = usersMapper.insert(userVO);
        if (insert != 1) {
            throw new ServiceException("注册失败，服务器正在维护...");
        }
    }

}
