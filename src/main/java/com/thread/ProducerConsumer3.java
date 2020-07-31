package com.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: ProducerConsumer3
 * @Description: 阻塞队列实现生产者消费者
 * @Author: WAHWJ
 * @Date: 2020/7/15 17:08
 * @Version: V0.1
 */
public class ProducerConsumer3 {
	public static class Producer implements Runnable {
		String name;
		ArrayBlockingQueue<Integer> queue;

		public Producer(String name, ArrayBlockingQueue<Integer> queue) {
			this.queue = queue;
			this.name = name;
		}

		@Override
		public void run() {
			try {
				for (int i = 0; i < 10; i++) {
					queue.put(i);
					System.out.println("[" + name + "] Producing value : +" + i);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static class Consumer implements Runnable {
		String name;
		ArrayBlockingQueue<Integer> queue;
		public Consumer(String name, ArrayBlockingQueue<Integer> queue) {
			this.queue = queue;
			this.name = name;
		}

		@Override
		public void run() {
			while (true) {
				try {
					System.out.println("[" + name + "] Consuming value :" + queue.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
		Runnable producer1 = new Producer("p-1",queue);
		Runnable producer2 = new Producer("p-2",queue);
		Runnable producer3 = new Producer("p-3",queue);
		Runnable consumer1 = new Consumer("con1",queue);
		Runnable consumer2 = new Consumer("con2",queue);
		new Thread(producer1).start();
		new Thread(producer2).start();
		new Thread(producer3).start();
		new Thread(consumer1).start();
		new Thread(consumer2).start();
	}
}
