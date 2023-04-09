package ycu.edu.ygc.controller;

import org.springframework.web.bind.annotation.*;
import ycu.edu.ygc.constant.ServiceCode;
import ycu.edu.ygc.exception.ServiceException;
import ycu.edu.ygc.pojo.vo.SuppliersVO;
import ycu.edu.ygc.service.SuppliersService;
import ycu.edu.ygc.web.JsonResult;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WYJ
 * @software: IntelliJ IDEA
 * @date 2023/4/9 13:16
 */
@RestController
@CrossOrigin
@RequestMapping("/suppliers")
public class SuppliersController {

    @Resource
    private SuppliersService suppliersService;

    @PostMapping("/addOrUpdate")
    public JsonResult<Void> addOrUpdate(SuppliersVO suppliersVO){
        try {
            suppliersService.addOrUpdateSuppliers(suppliersVO);
        } catch (ServiceException e) {
            return JsonResult.fail(ServiceCode.BAD_REQUEST,e.getMessage());
        }
        return JsonResult.ok();
    }

    @GetMapping("/list")
    public JsonResult<List<SuppliersVO>> list(){
        return JsonResult.ok(suppliersService.list());
    }

    @PostMapping("/detail")
    public JsonResult<SuppliersVO> getOne(SuppliersVO suppliersVO){
        return JsonResult.ok(suppliersService.getOne(suppliersVO));
    }

}
