package com.tastekorea.webapp.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

	/**
	 * DataSource 설정
	 * 
	 * @return
	 */
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/taste?serverTimezone=Asia/Seoul");
		ds.setUsername("taste");
		ds.setPassword("taste");
		
		ds.setInitialSize(2);		//커넥션 풀 초기화시 생성할 초기 커넥션 개수 (기본값 10)
		ds.setMaxActive(10);		//풀에서 가져올 수 있는 최대 커넥션 개수 (기본값 100)
		ds.setMaxIdle(10);			//풀에 유지할 수 있는 최대 커넥션 개수
		
		return ds;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager txManager = new DataSourceTransactionManager();
		txManager.setDataSource(dataSource());
		return txManager;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
}