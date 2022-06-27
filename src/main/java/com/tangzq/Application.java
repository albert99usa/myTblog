package com.tangzq;

//import com.tangzq.model.User;
//import com.tangzq.repository.UserRepository;
//import com.tangzq.utils.CommonProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.boot.system.ApplicationPid;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.DigestUtils;


import java.lang.management.ManagementFactory;

/**
 * 應用啟動入口類
 * @author tangzhiqiang
 */
@SpringBootApplication(scanBasePackages = "com.tangzq")
@EnableJpaRepositories(basePackages = "com.tangzq")
public class Application implements CommandLineRunner {


// @Autowired
// private UserRepository userRepository;

// @Override
// protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//    return builder.sources(Application.class);
// }

	public static void main(String[] args) {

		String pname=ManagementFactory.getRuntimeMXBean().getName();
		System.out.println("-------------"+pname+"-------");
		System.out.println("-------------"+new ApplicationPid().toString()+"-------");

		SpringApplication.run(Application.class, args);
	}

	/**
	 * 通過實現CommandLineRunner介面，在應用啟動時調用
	 * @param strings
	 * @throws Exception
	 */
	@Override
	public void run(String... strings) throws Exception {
		System.out.println("開始初始化資料....");
		// initUser();
		System.out.println("初始化資料完成....");
	}

	/**
	 * 初始化系統管理員
	 **/

   /*
   private void initUser(){
      User u=userRepository.findByUsername(CommonProps.ADMIN_NAME);
      if(null==u){
         u=new User();
         u.setUsername(CommonProps.ADMIN_NAME);
         u.setPassword(DigestUtils.md5DigestAsHex(CommonProps.ADMIN_PWD.getBytes()));
         u.setEmail(CommonProps.ADMIN_EMAIL);
         userRepository.save(u);
         System.out.println("初始化管理員帳號成功！");
      }else{
         System.out.println("管理員帳號已經存在");
      }
   }

*/
   /*
   @Bean
   public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
      PropertySourcesPlaceholderConfigurer propsConfig
            = new PropertySourcesPlaceholderConfigurer();
      propsConfig.setLocation(new ClassPathResource("git.properties"));
      propsConfig.setIgnoreResourceNotFound(true);
      propsConfig.setIgnoreUnresolvablePlaceholders(true);
      return propsConfig;
   }
   */
}

