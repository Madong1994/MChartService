package com.example.demo;

import com.example.demo.im.server.IMServerStarter;
import com.jfinal.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ServletComponentScan
public class DemoApplication {
	private static Logger log = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
		boolean isStart = IMServerStarter.start();
		if(isStart){
			log.info("t-io启动成功");
		}else {
			log.error("t-io启动失败");
		}
	}
}
