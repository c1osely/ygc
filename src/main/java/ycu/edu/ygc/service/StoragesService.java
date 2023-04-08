package ycu.edu.ygc.service;

import ycu.edu.ygc.exception.ServiceException;

/**
 * @author WYJ
 * @software: IntelliJ IDEA
 * @date 2023/4/5 14:11
 */
public interface StoragesService {

    /**
     * 规定仓储规格
     * @param size
     */
    void setStoragesSize(int size) throws ServiceException;

}
