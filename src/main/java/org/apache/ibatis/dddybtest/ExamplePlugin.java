package org.apache.ibatis.dddybtest;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @ClassName: ExamplePlugin
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/6/17 22:14
 * @Version: V0.1
 */
@Intercepts({@Signature(type= Executor.class, method = "query", args = {MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class})})
public class ExamplePlugin implements Interceptor {
  int property;
  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    Object target = invocation.getTarget(); //被代理对象
    Method method = invocation.getMethod(); //代理方法
    Object[] args = invocation.getArgs(); //方法参数
    System.out.println(target);
    System.out.println(method);
    System.out.println(args);
    System.out.println(property);
    Object result = invocation.proceed();
    // do something .......方法拦截后执行代码块
    return result;
  }

  @Override
  public Object plugin(Object target) {
    return Plugin.wrap(target, this);
  }

  @Override
  public void setProperties(Properties properties) {
    this.property = Integer.valueOf((String) properties.get("property"));
  }
}
