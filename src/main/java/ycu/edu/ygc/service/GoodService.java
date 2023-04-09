package ycu.edu.ygc.service;

import ycu.edu.ygc.exception.ServiceException;
import ycu.edu.ygc.pojo.vo.GoodVO;

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

}
