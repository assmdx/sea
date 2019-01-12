package cn.com.hanbinit.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ConfigurableApplicationContext;

public class StartupListener extends ApplicationReadyEvent {
    public StartupListener(SpringApplication application, String[] args, ConfigurableApplicationContext context) {
        super(application, args, context);
        System.out.println("pre-server started...");
    }
}
