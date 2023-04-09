package ycu.edu.ygc.service;

import ycu.edu.ygc.exception.ServiceException;
import ycu.edu.ygc.pojo.vo.CategoryVO;

import java.util.List;

/**
 * @author WYJ
 * @software: IntelliJ IDEA
 * @date 2023/4/8 22:59
 */
public interface CategoryService {

    /**
     * 添加分类
     *
     * @param categoryVO
     */
    void addOrUpdateCategory(CategoryVO categoryVO) throws ServiceException;

    /**
     * 逻辑删除分类
     * @param categoryVO
     */
    void deleteCategory(CategoryVO categoryVO) throws ServiceException;

    /**
     * 查看指定分类信息
     * @param categoryVO
     * @return
     */
    CategoryVO getOne(CategoryVO categoryVO);

    /**
     * 查看所有分类
     * @return
     */
    List<CategoryVO> listCategory();
}
