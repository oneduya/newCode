package com.thread;

import java.util.Scanner;

/**
 * @ClassName: Banker
 * @Description: 银行家算法
 * @Author: WAHWJ
 * @Date: 2020/7/27 18:26
 * @Version: V0.1
 */
public class Banker {
	int available[] = new int[]{3, 3, 2};//可得到的资源
	int max[][] = new int[][]{{7, 5, 3}, {3, 2, 2}, {9, 0, 2}, {2, 2, 2}, {4, 3, 3}};//每个进程最大资源数
	int allocation[][] = new int[][]{{0, 1, 0}, {2, 0, 0}, {3, 0, 2}, {2, 1, 1}, {0, 0, 2}};//每个进程目前拥有的资源数
	int need[][] = new int[][]{{7, 4, 3}, {1, 2, 2}, {6, 0, 0}, {0, 1, 1}, {4, 3, 1}};//每个进程需要的资源数


	void showData() {
		//展示数据输出每个进程的相关数
		System.out.println("进程号   Max     All     Need   ");
		System.out.println("     A  B  C  A  B  C  A  B  C");
		for (int i = 0; i < 5; i++) {
			System.out.print(i + "    ");
			for (int m = 0; m < 3; m++) System.out.print(max[i][m] + "  ");
			for (int m = 0; m < 3; m++) System.out.print(allocation[i][m] + "  ");
			for (int m = 0; m < 3; m++) System.out.print(need[i][m] + "  ");
			System.out.println();
		}
	}

	public boolean change(int inRequestNum, int inRequest[]) {
		int requestNum = inRequestNum;
		int[] request = inRequest;
		boolean flag = true;
		for (int i = 0; i < request.length; i++) {
			flag &= request[i] <= need[requestNum][i];
		}
		if (!flag) {
			//要求每一类请求资源小于当前线程need的资源数
			System.out.println("请求的资源数超过了所需要的最大值，分配错误");
			return false;
		}
		flag = true;
		for (int i = 0; i < request.length; i++) {
			flag &= request[i] <= available[i];
		}
		if (!flag) {
			//当前线程的每一类请求资源小于等于资源池对应资源的数量
			System.out.println("尚无足够资源分配，必须等待");
			return false;
		}
		//试分配数据给请求的线程
		for (int i = 0; i < request.length; i++) {
			available[i] = available[i] - request[i];
			//资源池的每类资源减去每类请求资源数量
			allocation[requestNum][i] = allocation[requestNum][i] + request[i];
			//当前线程allocation中每类资源加上每类资源请求数量
			need[requestNum][i] = need[requestNum][i] - request[i];
			//当前线程need中每类资源数量减去每类资源的请求数量
		}
		flag = checkSafe(available);
		if (flag == true) {
			System.out.println("能够安全分配");
			return true;
		}
		//不能通过安全性检查 恢复到未分配前的数据
		else {
			System.out.println("不能够安全分配");
			for (int i = 0; i < request.length; i++) {
				available[i] = available[i] + request[i];
				allocation[requestNum][i] = allocation[requestNum][i] - request[i];
				need[requestNum][i] = need[requestNum][i] + request[i];
			}
			return false;
		}
	}

	public boolean checkSafe(int[] lastAvailable) {
		int[] work = new int[lastAvailable.length];
		for (int i = 0; i < lastAvailable.length; i++) {
			work[i] = lastAvailable[i];
		}
		int i = 0;
		boolean[] finish = new boolean[5];
		while (i < 5) {//寻找一个能够满足的认为完成后才去执行下一进程
			boolean flag = !finish[i];
			for (int j = 0; j < lastAvailable.length; j++) {
				flag &= need[i][j] <= work[j];
			}
			if (flag) {
				//找到满足的修改work值，然后i=0，重新从开始的为分配的中寻找
				System.out.println("分配成功的是" + i);
				for (int j = 0; j < lastAvailable.length; j++) {
					work[j] = work[j] + allocation[i][j];
				}
				finish[i] = true;
				i = 0;
			} else {
				//如果没有找到直接i++
				i++;
			}
		}
		//通过finish数组判断是否都可以分配
		for (i = 0; i < 5; i++) {
			if (!finish[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Banker bank = new Banker();
		bank.showData();
		//请求线程资源存放的数组
		int request[] = new int[3];
		int requestNum;
		String source[] = new String[]{"A", "B", "C"};
		Scanner s = new Scanner(System.in);
		String choice = new String();
		//循环进行分配
		while (true) {
			System.out.println("请输入要请求的进程号（0--4）：");
			requestNum = s.nextInt();
			System.out.println("请输入请求的资源数目");
			for (int i = 0; i < 3; i++) {
				System.out.println(source[i] + "资源的数目：");
				request[i] = s.nextInt();
			}
			bank.change(requestNum, request);
			System.out.println("是否再请求分配(y/n)");
			choice = s.next();
			if (choice.equals("n")) {
				break;
			}
		}
	}
}

