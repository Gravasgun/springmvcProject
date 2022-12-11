package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//Springmvc的配置类
@Configuration
@ComponentScan({"controller","config"})
//开启json数据转换为对象的功能
@EnableWebMvc
public class SpringMvcConfig {
}
