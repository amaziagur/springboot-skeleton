package com.crazylabz.rest;

import com.crazylabz.entities.MessageResponse;
import com.crazylabz.service.BootService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/hello-boot")
public class HelloBootContoller {

    @Autowired
    private BootService bootService;

//    @Autowired
//    public HelloBootContoller(BootService bootService){
//        this.bootService = bootService;
//    }

    @RequestMapping(path = "/{name}", method = RequestMethod.GET)
    @ResponseBody
    public MessageResponse helloBoot(@PathVariable("name") String name){
        return bootService.helloBoot(name);
    }
}
