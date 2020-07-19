package com.thread;

import jdk.nashorn.internal.ir.CallNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: ProducerConsumer2
 * @Description: Reentrantlock实现生产者消费者
 * @Author: WAHWJ
 * @Date: 2020/7/15 16:48
 * @Version: V0.1
 */
public class ProducerConsumer2 {
	private static final ReentrantLock lock = new ReentrantLock();
	private static final Condition emptyCondition = lock.newCondition();
	private static final Condition fullCondition = lock.newCondition();

	public static class Producer implements Runnable {
		String name;
		int i = 0;
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
				lock.lock();
				while (queue.size() == maxSize) {
					try {
						System.out.println("Queue is full, Producer[" + name + "] thread waiting for " + "consumer to take something from queue.");
						fullCondition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("[" + name + "] Producing value : +" + i);
				queue.offer(i++);
				//唤醒其他所有生产者、消费者
				fullCondition.signalAll();
				emptyCondition.signalAll();
				try {
					Thread.sleep(new Random().nextInt(1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lock.unlock();
				try {
					Thread.sleep(new Random().nextInt(1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static class Consumer implements Runnable {
		String name;
		int i = 0;
		private Queue<Integer> queue;
		int maxSize;

		public Consumer(String name, Queue<Integer> queue, int maxSize) {
			this.name = name;
			this.queue = queue;
			this.maxSize = maxSize;
		}

		@Override
		public void run() {
			while (true) {
				lock.lock();
				while (queue.isEmpty()) {
					try {
						System.out.println("Queue is empty, Consumer[" + name + "] thread is waiting for Producer");
						emptyCondition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("[" + name + "] Consuming value :" + queue.poll());
				//唤醒其他所有生产者、消费者
				fullCondition.signalAll();
				emptyCondition.signalAll();
				try {
					Thread.sleep(new Random().nextInt(1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lock.unlock();
				try {
					Thread.sleep(new Random().nextInt(1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		Runnable producer1 = new ProducerConsumer1.Producer("p-1",queue,10);
		Runnable producer2 = new ProducerConsumer1.Producer("p-2",queue,10);
		Runnable producer3 = new ProducerConsumer1.Producer("p-3",queue,10);
		Runnable consumer1 = new ProducerConsumer1.Consumer("con1",queue);
		Runnable consumer2 = new ProducerConsumer1.Consumer("con2",queue);
		new Thread(producer1).start();
		new Thread(producer2).start();
		new Thread(producer3).start();
		new Thread(consumer1).start();
		new Thread(consumer2).start();
	}
}
