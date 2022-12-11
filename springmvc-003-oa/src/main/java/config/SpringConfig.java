package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//标识该类为Spring配置类
@Configuration
//组件扫描
@ComponentScan({"service"})
//读取外部的properties文件
@PropertySource("classpath:jdbc.properties")
//整合Mybatis需要引入Mybatis相关配置类
@Import({JdbcConfig.class, MybatisConfig.class})
//开启事务
@EnableTransactionManagement
public class SpringConfig {
}
