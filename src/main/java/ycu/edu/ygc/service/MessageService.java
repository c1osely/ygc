package ycu.edu.ygc.service;

import ycu.edu.ygc.pojo.entity.Messages;

import java.util.List;

/**
 * @author WYJ
 * @software: IntelliJ IDEA
 * @date 2023/4/14 0:00
 */
public interface MessageService {

    /**
     * 获取所有message
     * @return
     */
    List<Messages> list();

}
