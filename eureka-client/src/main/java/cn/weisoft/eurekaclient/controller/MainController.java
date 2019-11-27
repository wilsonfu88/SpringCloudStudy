package cn.weisoft.eurekaclient.controller;

import cn.weisoft.eurekaclient.model.UserPo;
import cn.weisoft.eurekaclient.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {

    @Autowired
    private RestTemplate restTemplate=null;

    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public String hello(){


        return "hello";
    }




    @GetMapping("/index")
    public UserPo index(){
        UserPo user = null;
        String url = "";
        for(int i=0;i<10;i++){
            url = "http://USERSERVICE/user/"+(i+1);
            System.out.println("url:" + url);
            user = restTemplate.getForObject(url,UserPo.class);
        }
        return user;
    }

    @GetMapping("/feign")
    public UserPo feign(){
        UserPo user = null;
        for(long i=0;i<10;i++){
            user = userService.getUserPo(i);
        }

        return user;
    }

    @GetMapping("/circuitBreaker1")
    @HystrixCommand(fallbackMethod = "error")
    public String circuitBreaker1(){
        return restTemplate.getForEntity("http://USERSERVICE/timeout",String.class).toString();
    }

    @GetMapping("/circuitBreaker2")
    @HystrixCommand(fallbackMethod = "error")
    public String circuitBreaker2(){
        return userService.timeout();
    }


    @GetMapping("/error")
    public String error(){
        return "熔断降级处理";
    }
}
