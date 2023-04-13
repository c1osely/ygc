package ycu.edu.ygc.mapper;

import org.apache.ibatis.annotations.Mapper;
import sun.misc.resources.Messages_es;
import ycu.edu.ygc.pojo.entity.Messages;

import java.util.List;

/**
* @author wyj
* @description 针对表【messages】的数据库操作Mapper
* @createDate 2023-04-13 23:51:00
* @Entity ycu.edu.ygc.pojo.entity.Messages
*/
@Mapper
public interface MessagesMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Messages record);

    int insertSelective(Messages record);

    Messages selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Messages record);

    int updateByPrimaryKey(Messages record);

    List<Messages> list();
}
