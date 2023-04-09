package ycu.edu.ygc.mapper;

import org.apache.ibatis.annotations.Mapper;
import ycu.edu.ygc.pojo.entity.Goods;
import ycu.edu.ygc.pojo.vo.GoodVO;

/**
 *
* @author wyj
* @description 针对表【ygc_goods】的数据库操作Mapper
* @createDate 2023-04-09 23:33:30
* @Entity ycu.edu.ygc.pojo.entity.Goods
*/
@Mapper
public interface GoodsMapper {

    int deleteByPrimaryKey(String id);

    int insert(Goods record);

    int insertSelective(GoodVO record);

    Goods selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

}
