package ycu.edu.ygc.service;

import ycu.edu.ygc.exception.ServiceException;
import ycu.edu.ygc.pojo.vo.GoodVO;

import java.util.List;

/**
 * @author WYJ
 * @software: IntelliJ IDEA
 * @date 2023/4/9 22:40
 */
public interface GoodService {

    /**
     * 商品入库
     * @param goodVO
     */
    void add(GoodVO goodVO) throws ServiceException;

    /**
     * 商品出库
     * @param goodVO
     * @throws ServiceException
     */
    void subGoods(GoodVO goodVO) throws ServiceException;

    /**
     * 展示所有good
     * @return
     */
    List<GoodVO> list();

    /**
     * 获取指定商品详情
     * @param goodVO
     * @return
     */
    GoodVO getDetail(GoodVO goodVO);
}
