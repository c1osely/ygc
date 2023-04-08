package ycu.edu.ygc.mapper;

import ycu.edu.ygc.pojo.entity.Suppliers;

/**
* @author wyj
* @description 针对表【ygc_suppliers】的数据库操作Mapper
* @createDate 2023-04-04 22:48:37
* @Entity ycu.edu.ygc.entity.Suppliers
*/
public interface SuppliersMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Suppliers record);

    int insertSelective(Suppliers record);

    Suppliers selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Suppliers record);

    int updateByPrimaryKey(Suppliers record);

}
