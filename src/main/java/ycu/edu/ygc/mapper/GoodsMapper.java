package ycu.edu.ygc.mapper;

import ycu.edu.ygc.pojo.entity.Goods;

/**
* @author wyj
* @description 针对表【ygc_goods】的数据库操作Mapper
* @createDate 2023-04-04 22:47:48
* @Entity ycu.edu.ygc.entity.Goods
*/
public interface GoodsMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

}
