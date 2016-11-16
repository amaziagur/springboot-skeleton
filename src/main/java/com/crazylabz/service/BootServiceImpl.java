package com.crazylabz.service;

import com.crazylabz.entities.MessageResponse;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BootServiceImpl implements BootService {

    @Setter
    @Value("${boot.greet.message}")
    private String greetMessage;

    @Override
    public MessageResponse helloBoot(String name) {
        return MessageResponse.builder().message(String.format(greetMessage, Optional.ofNullable(name).orElse("new friend"))).build();
    }
}
