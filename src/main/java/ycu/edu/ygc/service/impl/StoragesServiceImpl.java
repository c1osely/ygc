package ycu.edu.ygc.service.impl;

import org.springframework.stereotype.Service;
import ycu.edu.ygc.exception.ServiceException;
import ycu.edu.ygc.mapper.StoragesMapper;
import ycu.edu.ygc.pojo.entity.Storages;
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

    @Override
    public Integer layGoods() throws ServiceException {
        Integer sId = storagesMapper.selectEmpty();
        if (sId == null) {
            throw new ServiceException("仓储空间不足！");
        }
        Storages storages = new Storages();
        storages.setSId(sId);
        storages.setUsed(1);
        int i = storagesMapper.updateByPrimaryKeySelective(storages);
        if (i != 1)
            throw new ServiceException("入库失败，服务器维护中...");
        return sId;
    }

    @Override
    public void outGoods(Integer sId) throws ServiceException {
        Storages storages = new Storages();
        storages.setSId(sId);
        storages.setUsed(0);
        int i = storagesMapper.updateByPrimaryKeySelective(storages);
        if (i != 1)
            throw new ServiceException("出库失败，服务器维护中...");
    }

}
