package ycu.edu.ygc.service.impl;

import org.springframework.stereotype.Service;
import ycu.edu.ygc.exception.ServiceException;
import ycu.edu.ygc.mapper.CategoriesMapper;
import ycu.edu.ygc.pojo.vo.CategoryVO;
import ycu.edu.ygc.service.CategoryService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WYJ
 * @software: IntelliJ IDEA
 * @date 2023/4/8 23:01
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoriesMapper categoriesMapper;

    @Override
    public void addOrUpdateCategory(CategoryVO categoryVO) throws ServiceException {
        int i = 0;
        if (categoryVO.getCategoryId() != null) {
            i = categoriesMapper.updateByPrimaryKeySelective(categoryVO);
        }else {
            if (categoriesMapper.countAlready(categoryVO) == 0) {
                i = categoriesMapper.insertSelective(categoryVO);
            } else {
                throw new ServiceException("新增分类失败，分类已存在！");
            }
        }
        if (i != 1)
            throw new ServiceException("新增分类失败，服务器正在维护...");
    }

    @Override
    public void deleteCategory(CategoryVO categoryVO) throws ServiceException {
        int i = categoriesMapper.updateStatusById(categoryVO);
        if (i != 1)
            throw new ServiceException("删除分类失败，服务器正在维护...");
    }

    @Override
    public CategoryVO getOne(CategoryVO categoryVO) {
        return categoriesMapper.selectOne(categoryVO);
    }

    @Override
    public List<CategoryVO> listCategory() {
        return categoriesMapper.list();
    }

}
