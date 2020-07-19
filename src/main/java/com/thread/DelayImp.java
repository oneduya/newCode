package com.thread;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: DelayImp
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/7/9 16:19
 * @Version: V0.1
 */
public class DelayImp implements Delayed {
	private final long delayTime;
	private final long expire;
	private String taskName;

	public DelayImp(long delayTime, String taskName) {
		this.delayTime = delayTime;
		this.taskName = taskName;
		this.expire = System.currentTimeMillis() + delayTime;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(this.expire-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
	}

	@Override
	public int compareTo(Delayed o) {
		return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("DelayImp{");
		sb.append("delay=").append(delayTime);
		sb.append(",expire=").append(expire);
		sb.append(",taskName=").append(taskName).append('\'');
		sb.append('}');
		return sb.toString();
	}

	public static void main(String[] args) {
		DelayQueue<DelayImp> queue = new DelayQueue<>();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			DelayImp delayImp = new DelayImp(500,"task:"+ i);
			queue.offer(delayImp);
		}

		DelayImp delayImp = null;
		try {
			for (;;) {
				while ((delayImp = queue.take()) != null) {
					System.out.println(delayImp.toString());
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
