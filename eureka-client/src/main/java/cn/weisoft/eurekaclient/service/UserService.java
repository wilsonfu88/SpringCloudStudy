package cn.weisoft.eurekaclient.service;

import cn.weisoft.eurekaclient.model.UserPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("USERSERVICE")
public interface UserService {

    @GetMapping("/user/{id}")
    public UserPo getUserPo(@PathVariable("id")Long id);

    @GetMapping("/timeout")
    public String timeout();

}
