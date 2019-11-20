package cn.weisoft.userservice.controller;


import cn.weisoft.userservice.model.UserPo;
import com.netflix.appinfo.InstanceInfo;
//import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.logging.Logger;

@RestController
public class UserController {

    private Logger log = Logger.getLogger(this.getClass().getName());

    @Autowired
    private DiscoveryClient discoveryClient = null;


    @GetMapping("/user/{id}")
    public UserPo getUserPo(@PathVariable("id")Long id){
        ServiceInstance service  = discoveryClient.getInstances("USERSERVICE").get(0);

        log.info("Host:" + service.getHost() + " instanceId:" + service.getInstanceId());

        UserPo user = new UserPo();

        user.setId(id);
        user.setLevel((int)(id%3+1));
        user.setUserName("user_name_" + id);
        user.setNote("note_" + id);
        return user;
    }

    @GetMapping("/timeout")
    public String timeout(){
        long ms = (long)(3000L*Math.random());
        try{
            Thread.sleep(ms);
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
        return "熔断测试";
    }


}
