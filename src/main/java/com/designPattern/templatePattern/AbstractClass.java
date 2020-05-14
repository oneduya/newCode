package com.designPattern.templatePattern;

/**
 * @ClassName: AbstractClass
 * @Description: 模板模式中的模板类，是一个抽象类
 * @Author: WAHWJ
 * @Date: 2020/4/6 16:31
 * @Version: V0.1
 */
public abstract class AbstractClass {
    /**
     * @Author WAHWJ
     * @Description 初始化
     * @Date 19:20 2020/4/6
     * @Param []
     * @return void
     **/
    abstract void initialize();

    public void start() {
        System.out.println("started");
    };

    abstract void procese();

    public void end() {
        System.out.println("ended");
    };

    public final void play() {
        initialize();
        start();
        procese();
        end();
    }

}
