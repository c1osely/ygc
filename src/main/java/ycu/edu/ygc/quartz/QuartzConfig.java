package ycu.edu.ygc.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author WYJ
 * @software: IntelliJ IDEA
 * @date 2023/4/13 23:05
 */
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail checkDate(){
        System.out.println("==============================================>" + "将JobDetail对象存储在Spring容器中");
        return JobBuilder
                // newJob方法就是在绑定要运行的Job接口实现类,该方法参数要传入实现类的反射
                .newJob(QuartzJob.class)
                // 为当前的JobDetail对象起名,用于Quartz的调度环境中
                .withIdentity("checkDate")
                // 默认情况下,JobDetail对象如果没有触发器绑定会立即被移除
                // 设置了storeDurably()之后,当前JobDetail对象没有触发器绑定也不会移除了
                .storeDurably()
                .build();
    }

    // 下面是触发器的声明,也会保存到Spring容器中管理
    // 它是设置Job运行时机的对象
    @Bean
    public Trigger showTimeTrigger(){
        System.out.println("==============================================>" + "将Trigger保存到Spring容器");
        // 使用Cron表达式设置触发时间
        //测试专用 效果明显 每两秒执行一次
//        CronScheduleBuilder cron = CronScheduleBuilder.cronSchedule("0/2 * * * * ?");
        //表示每隔一天的00：00：00执行一次
        CronScheduleBuilder cron = CronScheduleBuilder.cronSchedule("0 0 0 1/1 * ?");
        return TriggerBuilder.newTrigger()
                // 绑定要运行的JobDetail对象
                .forJob(checkDate())
                // 给触发器起名
                .withIdentity("checkDateTrigger")
                // 绑定cron表达式
                .withSchedule(cron)
                .build();
    }
}
