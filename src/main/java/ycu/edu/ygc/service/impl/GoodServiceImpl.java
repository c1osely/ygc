package ycu.edu.ygc.service.impl;

import org.springframework.stereotype.Service;
import ycu.edu.ygc.exception.ServiceException;
import ycu.edu.ygc.mapper.GoodsMapper;
import ycu.edu.ygc.pojo.vo.GoodVO;
import ycu.edu.ygc.service.GoodService;
import ycu.edu.ygc.service.StoragesService;
import ycu.edu.ygc.util.UUIDUtils;

import javax.annotation.Resource;

/**
 * @author WYJ
 * @software: IntelliJ IDEA
 * @date 2023/4/9 22:50
 */
@Service
public class GoodServiceImpl implements GoodService {

    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private StoragesService storagesService;

    @Override
    public void add(GoodVO goodVO) throws ServiceException {
        goodVO.setGId(UUIDUtils.getUUID());
        goodVO.setGItemNum(UUIDUtils.getUUID());
        //得到仓储的id
        Integer sId = storagesService.layGoods();
        goodVO.setSId(sId);
        int i = goodsMapper.insertSelective(goodVO);
        if (i != 1)
            throw new ServiceException("商品入库失败！");
    }
}
