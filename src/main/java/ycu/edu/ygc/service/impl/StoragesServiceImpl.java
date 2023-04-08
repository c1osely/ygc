package ycu.edu.ygc.service.impl;

import org.springframework.stereotype.Service;
import ycu.edu.ygc.exception.ServiceException;
import ycu.edu.ygc.mapper.StoragesMapper;
import ycu.edu.ygc.service.StoragesService;

import javax.annotation.Resource;

/**
 * @author WYJ
 * @software: IntelliJ IDEA
 * @date 2023/4/5 14:13
 */
@Service
public class StoragesServiceImpl implements StoragesService {

    @Resource
    private StoragesMapper storagesMapper;

    @Override
    public void setStoragesSize(int size) throws ServiceException {
        int all = storagesMapper.countAll();
        int used = storagesMapper.countUsed();
        if (size > all) {
            int sum = 0;
            for (int i = 0; i < size - all; i++) {
                storagesMapper.insert();
                sum += 1;
            }
            if (sum != (size - all)) {
                throw new ServiceException("修改仓储容量失败，服务器正在维护...");
            }
        }
        if (size < all) {
            if (size < used) {
                throw new ServiceException("无法修改仓储容量，当前所设容量不足以放置货物！");
            }
            storagesMapper.deleteEmpty();
            int sum = 0;
            for (int i = 0; i < size - used; i++) {
                storagesMapper.insert();
                sum += 1;
            }
            if (sum != (size - used)) {
                throw new ServiceException("修改仓储容量失败，服务器正在维护...");
            }
        }
    }

}
