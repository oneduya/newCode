package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: TestSchedule
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/7/9 17:10
 * @Version: V0.1
 */
public class TestSchedule {
	public static void main(String[] args) {
		ScheduledExecutorService schedule = Executors.newScheduledThreadPool(5);
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("wait for 1 seconds");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		//schedule.schedule(runnable,3, TimeUnit.SECONDS);
//		schedule.scheduleWithFixedDelay(runnable,1,3,TimeUnit.SECONDS);
		schedule.scheduleAtFixedRate(runnable,1,3,TimeUnit.SECONDS);
		//schedule.shutdown();

	}

}
