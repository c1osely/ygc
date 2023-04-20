package ycu.edu.ygc.mapper;

import org.apache.ibatis.annotations.Mapper;
import ycu.edu.ygc.pojo.entity.Storages;

import java.util.List;

/**
* @author wyj
* @description 针对表【ygc_storages】的数据库操作Mapper
* @createDate 2023-04-04 22:48:26
* @Entity ycu.edu.ygc.entity.Storages
*/
@Mapper
public interface StoragesMapper {

    int deleteByPrimaryKey(Long id);

    int insert();

    int countUsed();

    int countAll();

    Integer selectEmpty();

    void deleteEmpty();

    int insertSelective(Storages record);

    Storages selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Storages record);

    int updateByPrimaryKey(Storages record);

    List<Storages> list();

}
