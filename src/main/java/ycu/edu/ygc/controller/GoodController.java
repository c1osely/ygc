package ycu.edu.ygc.controller;

import org.springframework.web.bind.annotation.*;
import ycu.edu.ygc.constant.ServiceCode;
import ycu.edu.ygc.exception.ServiceException;
import ycu.edu.ygc.pojo.vo.GoodVO;
import ycu.edu.ygc.service.GoodService;
import ycu.edu.ygc.web.JsonResult;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WYJ
 * @software: IntelliJ IDEA
 * @date 2023/4/11 22:10
 */
@RestController
@CrossOrigin
@RequestMapping("/goods")
public class GoodController {

    @Resource
    private GoodService goodService;

    @PostMapping("/add")
    public JsonResult<Void> add(GoodVO goodVO){
        try {
            goodService.add(goodVO);
        } catch (ServiceException e) {
            return JsonResult.fail(ServiceCode.BAD_REQUEST,e.getMessage());
        }
        return JsonResult.ok();
    }

    @PostMapping("/sub")
    public JsonResult<Void> subGoods(GoodVO goodVO){
        try {
            goodService.subGoods(goodVO);
        } catch (ServiceException e) {
            return JsonResult.fail(ServiceCode.BAD_REQUEST,e.getMessage());
        }
        return JsonResult.ok();
    }

    @GetMapping("/list")
    public JsonResult<List<GoodVO>> list(){
        List<GoodVO> list = goodService.list();
        return JsonResult.ok(list);
    }

    @GetMapping("/detail")
    public JsonResult<GoodVO> detail(GoodVO goodVO){
        GoodVO detail = goodService.getDetail(goodVO);
        return JsonResult.ok(detail);
    }

}
