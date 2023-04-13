package ycu.edu.ygc.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import ycu.edu.ygc.constant.GoodOverDueConstant;
import ycu.edu.ygc.mapper.MessagesMapper;
import ycu.edu.ygc.pojo.entity.Messages;
import ycu.edu.ygc.pojo.vo.GoodVO;
import ycu.edu.ygc.service.GoodService;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author WYJ
 * @software: IntelliJ IDEA
 * @date 2023/4/13 23:03
 */
public class QuartzJob implements Job {

    @Resource
    private GoodService goodService;
    @Resource
    private MessagesMapper messagesMapper;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        //执行的任务
        System.out.println("==============================================>" + LocalDateTime.now());
        List<GoodVO> goodVOS = goodService.checkDate();
        if (goodVOS != null) {
         goodVOS.forEach(good -> {
             Messages messages = new Messages();
             messages.setDetail(good.getGName() + "将在" + GoodOverDueConstant.OVERDUE_DATE + "日内过期！具体过期时间为" + good.getGLife() + "!");
             messagesMapper.insert(messages);
             System.out.println(good.getGName() + "将在" + GoodOverDueConstant.OVERDUE_DATE + "日内过期！具体过期时间为" + good.getGLife() + "!");
         });
        }
    }
}
