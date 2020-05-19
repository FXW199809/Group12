package com.group12.salary.config;

import com.group12.salary.service.realm.SalaryRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        System.out.println("ShiroConfig.shiroFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置SecuritManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 拦截器
        /**
         * Shiro 内置过滤器，过滤链定义，从上向下顺序执行
         *  常用的过滤器：
         *      anon:无需认证（登录）可以访问
         *      authc:必须认证才可以访问
         *      user:只要登录过，并且记住了密码，如果设置了rememberMe的功能可以直接访问
         *      perms:该资源必须得到资源权限才可以访问
         *      role:该资源必须得到角色的权限才可以访问
         */
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        filterChainDefinitionMap.put("/","anon");
        filterChainDefinitionMap.put("/login","anon");
        // 配置退出过滤器,其中的具体代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        // <!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边
        filterChainDefinitionMap.put("/**", "authc");

        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/");
        // 登录成功后要跳转的链接
        //shiroFilterFactoryBean.setSuccessUrl("");
        // 未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(SalaryRealm());
        return securityManager;
    }

    @Bean
    public SalaryRealm SalaryRealm(){
        SalaryRealm userRealm = new SalaryRealm();
        return userRealm;
    }

    //开启shiro aop注解支持.
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager((org.apache.shiro.mgt.SecurityManager) securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}