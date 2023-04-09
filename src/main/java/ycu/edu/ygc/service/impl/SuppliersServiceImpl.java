package ycu.edu.ygc.service.impl;

import org.springframework.stereotype.Service;
import ycu.edu.ygc.exception.ServiceException;
import ycu.edu.ygc.mapper.SuppliersMapper;
import ycu.edu.ygc.pojo.vo.SuppliersVO;
import ycu.edu.ygc.service.SuppliersService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WYJ
 * @software: IntelliJ IDEA
 * @date 2023/4/9 12:40
 */
@Service
public class SuppliersServiceImpl implements SuppliersService {

    @Resource
    private SuppliersMapper suppliersMapper;

    @Override
    public void addOrUpdateSuppliers(SuppliersVO suppliersVO) throws ServiceException {
        int i = 0;
        if (suppliersVO.getSupplierId() != null) {
            i = suppliersMapper.updateByPrimaryKeySelective(suppliersVO);
        }else {
            if (suppliersMapper.count(suppliersVO) == 0) {
                i = suppliersMapper.insertSelective(suppliersVO);
            } else {
                throw new ServiceException("新增供货商失败，供货商已存在！");
            }
        }
        if (i != 1)
            throw new ServiceException("新增供货商失败，服务器正在维护...");
    }

    @Override
    public SuppliersVO getOne(SuppliersVO suppliersVO) {
        return suppliersMapper.selectById(suppliersVO);
    }

    @Override
    public List<SuppliersVO> list() {
        return suppliersMapper.list();
    }
}
