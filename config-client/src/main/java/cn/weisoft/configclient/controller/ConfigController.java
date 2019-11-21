package cn.weisoft.configclient.controller;

import cn.weisoft.configclient.model.GitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

  /*  @Autowired
    private GitConfig gitConfig=null;*/
  @Value("${from}")
    private String from=null;

    @GetMapping("/from")
    public String from(){
        return from;
    }
}
