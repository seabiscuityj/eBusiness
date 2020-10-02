package com.sean.ebusiness;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
//配置扫描MyBatis接口的包路径
@MapperScan(basePackages={"com.sean.ebusiness.repository"})
public class EBusinessApplication {
	public static void main(String[] args) {
		SpringApplication.run(EBusinessApplication.class, args);
	}
}
