package config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MybatisConfig {
    //构建SqlSessionFactoryBean并设置数据源与别名扫描
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        //给包设置别名
        sqlSessionFactoryBean.setTypeAliasesPackage("bean");
        //设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    //构建MapperScannerConfigurer并设置mapper层的包扫描
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScanner=new MapperScannerConfigurer();
        //给包设置别名
        mapperScanner.setBasePackage("mapper");
        return mapperScanner;
    }
}
