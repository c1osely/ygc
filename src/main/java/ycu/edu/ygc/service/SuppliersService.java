package ycu.edu.ygc.service;

import ycu.edu.ygc.exception.ServiceException;
import ycu.edu.ygc.pojo.vo.SuppliersVO;

import java.util.List;

/**
 * @author WYJ
 * @software: IntelliJ IDEA
 * @date 2023/4/9 12:24
 */
public interface SuppliersService {

    /**
     * 新增或修改
     * @param suppliersVO
     */
    void addOrUpdateSuppliers(SuppliersVO suppliersVO) throws ServiceException;

    /**
     * 查看指定供货商信息
     * @param suppliersVO
     * @return
     */
    SuppliersVO getOne(SuppliersVO suppliersVO);

    /**
     * 查看所有
     * @return
     */
    List<SuppliersVO> list();

}
