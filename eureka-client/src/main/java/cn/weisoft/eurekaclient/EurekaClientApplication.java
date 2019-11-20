package cn.weisoft.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages = "cn.weisoft.eurekaclient.service")
@EnableCircuitBreaker
public class EurekaClientApplication {

    @LoadBalanced
    @Bean(name="RestTemplate")
    public RestTemplate  initRestTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

}
