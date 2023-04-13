package ycu.edu.ygc.service.impl;

import org.springframework.stereotype.Service;
import ycu.edu.ygc.constant.GoodOverDueConstant;
import ycu.edu.ygc.exception.ServiceException;
import ycu.edu.ygc.mapper.GoodsMapper;
import ycu.edu.ygc.pojo.vo.GoodVO;
import ycu.edu.ygc.service.GoodService;
import ycu.edu.ygc.service.StoragesService;
import ycu.edu.ygc.util.UUIDUtils;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    @Override
    public void subGoods(GoodVO goodVO) throws ServiceException {
        GoodVO result = goodsMapper.selectByPrimaryKey(goodVO.getGId());
        if (Integer.parseInt(result.getGQuantity()) < Integer.parseInt(goodVO.getGQuantity())) {
            throw new ServiceException("出库失败，库存不足！");
        }
        int i = goodsMapper.changeQuantity(goodVO);
        if (i != 1) {
            throw new ServiceException("出库失败，服务器正在维护...");
        }
        if (Integer.valueOf(result.getGQuantity()) == Integer.valueOf(goodVO.getGQuantity())) {
            Integer sId = result.getSId();
            storagesService.outGoods(sId);
        }
    }

    @Override
    public List<GoodVO> list() {
        return goodsMapper.list();
    }

    @Override
    public GoodVO getDetail(GoodVO goodVO) {
        return goodsMapper.selectByPrimaryKey(goodVO.getGId());
    }

    @Override
    public List<GoodVO> checkDate() {
        GoodVO goodVO = new GoodVO();
        Date date = new Date();
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.DAY_OF_YEAR,+GoodOverDueConstant.OVERDUE_DATE);//日期加指定天数
        Date time = rightNow.getTime();
        goodVO.setGLife(time);
        List<GoodVO> goodVOS = goodsMapper.checkDate(goodVO);
        return goodVOS;
    }

}
