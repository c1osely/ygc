package ycu.edu.ygc.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ycu.edu.ygc.constant.ServiceCode;
import ycu.edu.ygc.exception.ServiceException;
import ycu.edu.ygc.service.StoragesService;
import ycu.edu.ygc.web.JsonResult;

import javax.annotation.Resource;

/**
 * @author WYJ
 * @software: IntelliJ IDEA
 * @date 2023/4/5 14:22
 */
@RestController
@CrossOrigin
@RequestMapping("/storage")
public class StoragesController {

    @Resource
    private StoragesService storagesService;

    @PostMapping("/size")
    public JsonResult<Void> size(int size){
        try {
            storagesService.setStoragesSize(size);
        } catch (ServiceException e) {
            return JsonResult.fail(ServiceCode.SERVE_ERROR, e.getMessage());
        }
        return JsonResult.ok();
    }

}
