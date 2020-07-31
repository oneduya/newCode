package com.bishi;

import java.util.Scanner;

/**
 * @ClassName: Huawei2
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/4/15 20:33
 * @Version: V0.1
 */
public class Huawei2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] in = sc.nextLine().split(" ");
        String reg = in[0];
        String str = in[1];
        String[] rem = str.split("\\],");
        int count = 0;
        for (String tmp : rem) {
            if (!reg.equals(tmp.split("\\[")[0])) {
                continue;
            }
            tmp = tmp.replace(reg, "").replace("[", "").replace("]", "");
            String[] jicunqi = tmp.split(",");
            if (!jicunqi[0].startsWith("addr=") || !jicunqi[1].startsWith("mask=") || !jicunqi[2].startsWith("val=")) {
                continue;
            }
            jicunqi[0] = jicunqi[0].replace("addr=", "");
            jicunqi[1] = jicunqi[1].replace("mask=", "");
            jicunqi[2] = jicunqi[2].replace("val=", "");
            for (int i = 0; i < jicunqi.length; i++) {
                String jcqtmp = jicunqi[i];
                boolean a = "0x17".startsWith("0x");
                boolean b = jcqtmp.startsWith("0x");
                if (!jcqtmp.startsWith("0x") && !jcqtmp.startsWith("0X")) {
                    break;
                }
                if (i != 2) {
                    System.out.print(jcqtmp + " ");
                } else {
                    System.out.println(jcqtmp);
                    count++;
                }
            }
        }
        if (count < 1) {
            System.out.println("FAIL");
        }
    }
}
