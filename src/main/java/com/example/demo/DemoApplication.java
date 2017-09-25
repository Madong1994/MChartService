package com.example.demo;

import com.jfinal.log.Log;
import im.server.IMServerStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	private static Log log = Log.getLog(DemoApplication.class);
	public static void main(String[] args) {
		boolean isStart = IMServerStarter.start();
		if(isStart){
			log.info("t-io启动成功");
		}else {
			log.error("t-io启动失败");
		}
		SpringApplication.run(DemoApplication.class, args);
	}
}
