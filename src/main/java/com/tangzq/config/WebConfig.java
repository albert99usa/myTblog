package com.tangzq.config;

import com.tangzq.interceptor.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//import javax.persistence.EntityManagerFactory;

@Configuration
@Slf4j
public class WebConfig extends WebMvcConfigurerAdapter {
  //  @Autowired
  //  ApplicationContext context;
    /*
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
     //   registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/cat/**","/topic/**","/user/**","/like/**","/collect/**");
        super.addInterceptors(registry);
        log.info("拦截器注册完毕");
    }
    */
    /*
public InternalResourceViewResolver setViewResolver(){
    InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();
    resourceViewResolver.setViewClass(JstlView.class);
    resourceViewResolver.setPrefix("/WEB-INF/pages/");
    resourceViewResolver.setSuffix(".jsp");
    return  resourceViewResolver;
}
*/

    /*
 @Bean
    public LocalSessionFactoryBean  getSessionFactory(){
        LocalSessionFactoryBean sessionFactoryBean =new  LocalSessionFactoryBean();
        Resource resource= context.getResource("classpath:hibernate.cfg.xml.old");
        sessionFactoryBean.setConfigLocation(resource);
        return sessionFactoryBean;
    }
    */
   /*
    @Bean
    public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory emf) {
        HibernateJpaSessionFactoryBean fact = new HibernateJpaSessionFactoryBean();
        fact.setEntityManagerFactory(emf);
        return fact;
    }
    */
/*
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Bean
    public SessionFactory getSessionFactory() {
        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        return entityManagerFactory.unwrap(SessionFactory.class);
    }
    */
}
