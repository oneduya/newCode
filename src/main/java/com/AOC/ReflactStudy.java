package com.AOC;

import com.leetcode.Tree.BFS;
import com.leetcode.Tree.BuildTree;
import com.leetcode.Tree.TreeNode;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * @ClassName: ReflactStudy
 * @Description: 测试反射
 * @Author: WAHWJ
 * @Date: 2020/4/23 22:20
 * @Version: V0.1
 */
public class ReflactStudy {


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Class buildTree = BuildTree.class;
        Annotation[] annotations =  buildTree.getAnnotations();
        Method method = buildTree.getMethod("buildTree", int[].class, int[].class);
        Constructor constructor = buildTree.getConstructor();
        Object instance = constructor.newInstance();
        TreeNode root = new TreeNode(0);
        for(int i=0;i<100;i++){
            root = (TreeNode) method.invoke(instance,new int[]{1,2},new int[]{2,1});
        }
        System.out.println(root);
    }

}
