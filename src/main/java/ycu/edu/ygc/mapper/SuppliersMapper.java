package ycu.edu.ygc.mapper;

import org.apache.ibatis.annotations.Mapper;
import ycu.edu.ygc.pojo.entity.Suppliers;
import ycu.edu.ygc.pojo.vo.SuppliersVO;

import java.util.List;

/**
* @author wyj
* @description 针对表【ygc_suppliers】的数据库操作Mapper
* @createDate 2023-04-04 22:48:37
* @Entity ycu.edu.ygc.entity.Suppliers
*/
@Mapper
public interface SuppliersMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Suppliers record);

    int insertSelective(SuppliersVO record);

    SuppliersVO selectById(SuppliersVO suppliersVO);

    List<SuppliersVO> list();

    int updateByPrimaryKeySelective(SuppliersVO record);

    int count(SuppliersVO suppliersVO);

    int updateByPrimaryKey(Suppliers record);

}
