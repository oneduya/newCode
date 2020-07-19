package com.thread;

import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @ClassName: ProducerConsumer1
 * @Description: wait/notify生产者消费者实现
 * @Author: WAHWJ
 * @Date: 2020/7/15 16:18
 * @Version: V0.1
 */

public class ProducerConsumer1 {
	public static class Producer implements Runnable {
		String name;
		int i=0;
		private Queue<Integer> queue;
		int maxSize;

		public Producer(String name, Queue<Integer> queue, int maxSize) {
			this.name = name;
			this.queue = queue;
			this.maxSize = maxSize;
		}

		@Override
		public void run() {
			while (true) {
				synchronized (queue) {
					while (queue.size()==maxSize) {
						try {
							System.out.println("Queue is full, Producer[" + name + "] thread waiting for " + "consumer to take something from queue.");
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("[" + name + "] Producing value : +" + i);
					queue.offer(i++);
					queue.notifyAll();
					try {
						Thread.sleep(new Random().nextInt(1000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static class Consumer implements Runnable {
		String name;
		private Queue<Integer> queue;

		public Consumer(String name, Queue<Integer> queue) {
			this.name = name;
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				synchronized (queue) {
					while (queue.isEmpty()) {
						try {
							System.out.println("Queue is empty, Consumer[" + name + "] thread is waiting for Producer");
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("[" + name + "] Consuming value :" + queue.poll());
					queue.notifyAll();
					try {
						Thread.sleep(new Random().nextInt(1000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		Runnable producer1 = new Producer("p-1",queue,10);
		Runnable producer2 = new Producer("p-2",queue,10);
		Runnable producer3 = new Producer("p-3",queue,10);
		Runnable consumer1 = new Consumer("con1",queue);
		Runnable consumer2 = new Consumer("con2",queue);
		new Thread(producer1).start();
		new Thread(producer2).start();
		new Thread(producer3).start();
		new Thread(consumer1).start();
		new Thread(consumer2).start();
	}
}
