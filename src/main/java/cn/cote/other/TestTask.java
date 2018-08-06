package cn.cote.other;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

//允许spring扫描
@Component
public class TestTask {

    @JsonFormat(pattern="yyy-MM-dd hh:mm:ss a",locale="zh",timezone="GMT+8")
    private Date time;

    private Integer Minute = 0;
//    每隔60秒执行任务
    @Scheduled(fixedRate = 60000)
    public void sayTime(){
        this.time= new Date();
        this.Minute++;
        System.out.println(time + "  这是你过去的第"+Minute+"分钟");
    }
//    支持设计在固定时间运行，例如，每分钟的第30-第35秒运行
//    在注解中加入cron="30-35 * * * * ?"
//    生成表达式地址：http://cron.qqe2.com

//    加Async注解则可变为异步任务
    @Async
    public void asynchronous(){}
}
