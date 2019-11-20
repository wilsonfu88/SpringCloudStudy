package cn.weisoft.wilsonzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class WilsonZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(WilsonZuulApplication.class, args);
    }

}
