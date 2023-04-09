package ycu.edu.ygc.controller;

import org.springframework.web.bind.annotation.*;
import ycu.edu.ygc.constant.ServiceCode;
import ycu.edu.ygc.exception.ServiceException;
import ycu.edu.ygc.pojo.vo.CategoryVO;
import ycu.edu.ygc.service.CategoryService;
import ycu.edu.ygc.web.JsonResult;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WYJ
 * @software: IntelliJ IDEA
 * @date 2023/4/9 11:56
 */
@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @PostMapping("/addOrUpdate")
    public JsonResult<Void> addOrUpdate(CategoryVO categoryVO){
        try {
            categoryService.addOrUpdateCategory(categoryVO);
        } catch (ServiceException e) {
            return JsonResult.fail(ServiceCode.BAD_REQUEST,e.getMessage());
        }
        return JsonResult.ok();
    }

    @PostMapping("/delete")
    public JsonResult<Void> delete(CategoryVO categoryVO){
        try {
            categoryService.deleteCategory(categoryVO);
        } catch (ServiceException e) {
            return JsonResult.fail(ServiceCode.BAD_REQUEST,e.getMessage());
        }
        return JsonResult.ok();
    }

    @GetMapping("/list")
    public JsonResult<List<CategoryVO>> list(){
        return JsonResult.ok(categoryService.listCategory());
    }

    @PostMapping("/detail")
    public JsonResult<CategoryVO> getOne(CategoryVO categoryVO){
        return JsonResult.ok(categoryService.getOne(categoryVO));
    }

}
