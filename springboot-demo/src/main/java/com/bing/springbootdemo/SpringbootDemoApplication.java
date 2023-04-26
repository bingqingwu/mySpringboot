package com.bing.springbootdemo;

import com.bing.springbootdemo.ImportSelector.MyConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.ResourceBundle;

@SpringBootApplication
@Slf4j
@EnableAsync
@EnableFeignClients(basePackages = "com.bing")
@EnableDiscoveryClient
@ServletComponentScan(basePackages = "com.bing.springbootdemo.controller")
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(SpringbootDemoApplication.class);
	//	springApplication.addListeners(new MyApplicationListener());

//		springApplication.addListeners(new ApplicationListener<ApplicationEvent>() {
//			@Override
//			public void onApplicationEvent(ApplicationEvent event) {
//				log.info("event: " + event);
//			}
//		});

		springApplication.run(args);


	}

	public static void test1(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
			@Override
			public void onApplicationEvent(ApplicationEvent event) {
				log.info("event: " + event);
			}
		});
		context.register(MyConfiguration.class);
		context.refresh();
		context.close();

		while (true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
