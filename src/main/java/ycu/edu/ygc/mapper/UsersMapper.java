package ycu.edu.ygc.mapper;

import org.apache.ibatis.annotations.Mapper;
import ycu.edu.ygc.pojo.entity.Users;
import ycu.edu.ygc.pojo.vo.UserVO;

/**
* @author wyj
* @description 针对表【ygc_users】的数据库操作Mapper
* @createDate 2023-04-04 22:48:45
* @Entity ycu.edu.ygc.entity.Users
*/
@Mapper
public interface UsersMapper {

    Users selectByUsername(UserVO userVO);

    int deleteByPrimaryKey(Long id);

    int insert(UserVO record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

}
