package cn.caocaokeji.testjava;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    void dfs(int x) {
        System.out.println("dfs x:" + x);
        printTrack();
        if (x == c.length - 1) {
            res.add(String.valueOf(c)); // 添加排列方案
            System.out.println("return:" + String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) {
                System.out.println("剪枝：" + c[i]);
                continue; // 重复，因此剪枝
            }
            set.add(c[i]);
            System.out.println("swap i:" + i + " x:" + x);
            swap(i, x); // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1); // 开启固定第 x + 1 位字符
            swap(i, x); // 恢复交换
        }
    }

    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

    /**
     * 打印当前线程的调用堆栈
     */
    void printTrack() {
        StackTraceElement[] st = Thread.currentThread().getStackTrace();
        if (st == null) {
            System.out.println("无堆栈...");
            return;
        }
        StringBuffer sbf = new StringBuffer();
        for (StackTraceElement e : st) {
            if (sbf.length() > 0) {
                sbf.append(" <- ");
                sbf.append(System.getProperty("line.separator"));
            }
            sbf.append(java.text.MessageFormat.format("{0}.{1}() {2}"
                    , e.getClassName()
                    , e.getMethodName()
                    , e.getLineNumber()));
        }
        System.out.println(sbf.toString());
    }
}

/**
dfs x:0
java.lang.Thread.getStackTrace() 1,559 <- 
cn.caocaokeji.testjava.Solution.printTrack() 49 <- 
cn.caocaokeji.testjava.Solution.dfs() 19 <- 
cn.caocaokeji.testjava.Solution.permutation() 13 <- 
cn.caocaokeji.testjava.MyClass.main() 6
swap i:0 x:0
dfs x:1
java.lang.Thread.getStackTrace() 1,559 <- 
cn.caocaokeji.testjava.Solution.printTrack() 49 <- 
cn.caocaokeji.testjava.Solution.dfs() 19 <- 
cn.caocaokeji.testjava.Solution.dfs() 34 <- 
cn.caocaokeji.testjava.Solution.permutation() 13 <- 
cn.caocaokeji.testjava.MyClass.main() 6
swap i:1 x:1
dfs x:2
java.lang.Thread.getStackTrace() 1,559 <- 
cn.caocaokeji.testjava.Solution.printTrack() 49 <- 
cn.caocaokeji.testjava.Solution.dfs() 19 <- 
cn.caocaokeji.testjava.Solution.dfs() 34 <- 
cn.caocaokeji.testjava.Solution.dfs() 34 <- 
cn.caocaokeji.testjava.Solution.permutation() 13 <- 
cn.caocaokeji.testjava.MyClass.main() 6
return:abc
swap i:2 x:1
dfs x:2
java.lang.Thread.getStackTrace() 1,559 <- 
cn.caocaokeji.testjava.Solution.printTrack() 49 <- 
cn.caocaokeji.testjava.Solution.dfs() 19 <- 
cn.caocaokeji.testjava.Solution.dfs() 34 <- 
cn.caocaokeji.testjava.Solution.dfs() 34 <- 
cn.caocaokeji.testjava.Solution.permutation() 13 <- 
cn.caocaokeji.testjava.MyClass.main() 6
return:acb
swap i:1 x:0
dfs x:1
java.lang.Thread.getStackTrace() 1,559 <- 
cn.caocaokeji.testjava.Solution.printTrack() 49 <- 
cn.caocaokeji.testjava.Solution.dfs() 19 <- 
cn.caocaokeji.testjava.Solution.dfs() 34 <- 
cn.caocaokeji.testjava.Solution.permutation() 13 <- 
cn.caocaokeji.testjava.MyClass.main() 6
swap i:1 x:1
dfs x:2
java.lang.Thread.getStackTrace() 1,559 <- 
cn.caocaokeji.testjava.Solution.printTrack() 49 <- 
cn.caocaokeji.testjava.Solution.dfs() 19 <- 
cn.caocaokeji.testjava.Solution.dfs() 34 <- 
cn.caocaokeji.testjava.Solution.dfs() 34 <- 
cn.caocaokeji.testjava.Solution.permutation() 13 <- 
cn.caocaokeji.testjava.MyClass.main() 6
return:bac
swap i:2 x:1
dfs x:2
java.lang.Thread.getStackTrace() 1,559 <- 
cn.caocaokeji.testjava.Solution.printTrack() 49 <- 
cn.caocaokeji.testjava.Solution.dfs() 19 <- 
cn.caocaokeji.testjava.Solution.dfs() 34 <- 
cn.caocaokeji.testjava.Solution.dfs() 34 <- 
cn.caocaokeji.testjava.Solution.permutation() 13 <- 
cn.caocaokeji.testjava.MyClass.main() 6
return:bca
swap i:2 x:0
dfs x:1
java.lang.Thread.getStackTrace() 1,559 <- 
cn.caocaokeji.testjava.Solution.printTrack() 49 <- 
cn.caocaokeji.testjava.Solution.dfs() 19 <- 
cn.caocaokeji.testjava.Solution.dfs() 34 <- 
cn.caocaokeji.testjava.Solution.permutation() 13 <- 
cn.caocaokeji.testjava.MyClass.main() 6
swap i:1 x:1
dfs x:2
java.lang.Thread.getStackTrace() 1,559 <- 
cn.caocaokeji.testjava.Solution.printTrack() 49 <- 
cn.caocaokeji.testjava.Solution.dfs() 19 <- 
cn.caocaokeji.testjava.Solution.dfs() 34 <- 
cn.caocaokeji.testjava.Solution.dfs() 34 <- 
cn.caocaokeji.testjava.Solution.permutation() 13 <- 
cn.caocaokeji.testjava.MyClass.main() 6
return:cba
swap i:2 x:1
dfs x:2
java.lang.Thread.getStackTrace() 1,559 <- 
cn.caocaokeji.testjava.Solution.printTrack() 49 <- 
cn.caocaokeji.testjava.Solution.dfs() 19 <- 
cn.caocaokeji.testjava.Solution.dfs() 34 <- 
cn.caocaokeji.testjava.Solution.dfs() 34 <- 
cn.caocaokeji.testjava.Solution.permutation() 13 <- 
cn.caocaokeji.testjava.MyClass.main() 6
return:cab
/**
