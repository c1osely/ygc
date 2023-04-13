package ycu.edu.ygc.service.impl;

import org.springframework.stereotype.Service;
import ycu.edu.ygc.mapper.MessagesMapper;
import ycu.edu.ygc.pojo.entity.Messages;
import ycu.edu.ygc.service.MessageService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WYJ
 * @software: IntelliJ IDEA
 * @date 2023/4/14 0:01
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Resource
    private MessagesMapper messagesMapper;

    @Override
    public List<Messages> list() {
        return messagesMapper.list();
    }
}
