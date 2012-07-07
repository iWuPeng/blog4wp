package com.wupeng.blog.util;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author WuPeng
 * @date 2012.7.7
 * @description spring常用类，获取注入类对象
 */
public class SpringUtil {
    
    private static ApplicationContext context;
    
    /**
     * @description 初始化加载spring文件
     * @return
     */
    public synchronized static ApplicationContext getContext(){
        if ( context == null ){
            context = new ClassPathXmlApplicationContext(Constant.APPLICATION_PATH);
        }
        return context;
    }
    
    /**
     * @description 通过spring中配置的注入对象名获得注入类对象
     * @param beanName 注入类对象名
     * @return 注入类对象
     */
    public static Object getBean(String beanName)
    {
    	return getContext().getBean(beanName);
    }
}
