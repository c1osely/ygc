package ycu.edu.ygc.mapper;

import org.apache.ibatis.annotations.Mapper;
import ycu.edu.ygc.pojo.entity.Categories;
import ycu.edu.ygc.pojo.vo.CategoryVO;

import java.util.List;

/**
* @author wyj
* @description 针对表【ygc_categories】的数据库操作Mapper
* @createDate 2023-04-09 10:52:08
* @Entity ycu.edu.ygc.pojo.entity.Categories
*/
@Mapper
public interface CategoriesMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Categories record);

    int insertSelective(CategoryVO categoryVO);

    CategoryVO selectOne(CategoryVO categoryVO);

    int updateByPrimaryKeySelective(CategoryVO record);

    int updateStatusById(Categories record);

    List<CategoryVO> list();

    int countAlready(CategoryVO categoryVO);
}
