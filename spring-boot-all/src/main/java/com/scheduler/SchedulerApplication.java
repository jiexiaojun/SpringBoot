package com.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 
 * @类名称：SchedulerApplication
 * @类描述：学习spirng-boot-scheduler(定时器)
 * 注解的方式 主要理解corn表达式、fixedRate、fixedDelay的区别
 * fixedDelay = 6000 表示任务执行完后的间隔时间 比如任务1运行10秒 然后等待6秒任务2,任务2运行100秒然后等待6秒任务3 依次类推
 * fixedRate = 10000  表示任务执行的间隔时间 比如10秒 从任务执行的那一刻起就已经有一个任务时刻表 举例如下
 * 任务1 开始 2018-08-30 15:02:00
 * 任务2 开始 2018-08-30 15:02:10
 * 任务3 开始 2018-08-30 15:02:20
 * 任务4 开始 2018-08-30 15:02:30
 * 任务5 开始 2018-08-30 15:02:40
 * 任务6 开始 2018-08-30 15:02:50
 * 
 * 如果任务1执行完成的时间（2018-08-30 15:02:02）在任务2开始之前，任务2是不会提前启动的。此时等待8秒
 * 如果任务2执行完成的时间（2018-08-30 15:02:17）在任务3开始之前，任务3是不会提前启动的。此时等待3秒
 * 如果任务3执行完成的时间（2018-08-30 15:02:35）在任务4规定开始之后，任务4会立即执行
 * 如果任务4执行完成的时间（2018-08-30 15:02:41）在任务5规定开始之后，任务5会立即执行
 * 如果任务5执行完成的时间（2018-08-30 15:02:46）在任务6开始之前，任务6是不会提前启动的。此时等待4秒
 * 
 * 最后小结一下：fixedRate 每次任务结束后会从任务编排表中找下一次该执行的任务，判断是否到时机执行。fixedRate 的任务某次执行时间再长也不会造成两次任务实例同时执行，
 * 除非用了 @Async 注解。 fixedDelay 总是前一次任务完成后，延时固定长度然后执行一次任务
 * @创建人：jie.xiaojun
 * @创建时间：2018年8月30日 下午2:38:59
 */
@SpringBootApplication
@EnableScheduling
public class SchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulerApplication.class, args);
	}
}
