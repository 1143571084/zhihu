package cn.edu.zucc.qua;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
/**
* 类说明 
* @author 屠哲俊
* @date 2020年7月6日  新建
*/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)

public class ZuccknowApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuccknowApplication.class, args);
	}

}
