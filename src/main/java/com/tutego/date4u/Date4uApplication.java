package com.tutego.date4u;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.tutego.date4u.core.FileSystem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.unit.DataSize;

@SpringBootApplication
public class Date4uApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(Date4uApplication.class, args);
        // Alle Commponentennames geben zu lassen
//        for(String name : ctx.getBeanDefinitionNames()){
//            System.out.println(name);
//        }
        // Gezielt kommponenten rausnehmen aus den Container
        FileSystem fileSystem = ctx.getBean(FileSystem.class);
        System.out.printf("%d GB%n", DataSize.ofBytes( fileSystem.getFreeDiskSpace()).toGigabytes());
    }




}
