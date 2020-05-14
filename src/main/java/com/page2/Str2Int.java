package com.page2;

import java.util.concurrent.ConcurrentHashMap;

public class Str2Int {
    public int StrToInt(String str)
    {
        if (str.equals("") || str.length() == 0)
            return 0;
        char[] a = str.toCharArray();
        int fuhao = 0;
        if (a[0] == '-')
            fuhao = 1;
        int sum = 0;
        for (int i = fuhao; i < a.length; i++)
        {
            if (a[i] == '+')
                continue;
            if (a[i] < 48 || a[i] > 57)
                return 0;
            sum = sum * 10 + a[i] - 48;
        }
        return fuhao == 0 ? sum : sum * -1;
    }

    public static void main(String[] args) {
        Str2Int s2i = new Str2Int();
        String str ="+2147483647";
        int result = s2i.StrToInt(str);
        System.out.println(result);
        ConcurrentHashMap a = new ConcurrentHashMap();

    }
}
