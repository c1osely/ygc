package ycu.edu.ygc.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ycu.edu.ygc.pojo.entity.Messages;
import ycu.edu.ygc.service.MessageService;
import ycu.edu.ygc.web.JsonResult;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WYJ
 * @software: IntelliJ IDEA
 * @date 2023/4/14 0:04
 */
@RestController
@RequestMapping("/message")
@CrossOrigin
public class MessageController {

    @Resource
    private MessageService messageService;

    @GetMapping("/list")
    public JsonResult<List<Messages>> list(){
        return JsonResult.ok(messageService.list());
    }

}
