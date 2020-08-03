package com.adorsys.demo.service;

import com.adorsys.demo.entity.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestClientImpl implements RestClient {
    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<ToDo> getToDos() {
        ToDo[] todos = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos", ToDo[].class);
        return Arrays.asList(todos).stream().map(e -> {
            e.setTitle("HEYO ");
            return e;
        }).collect(Collectors.toList());
    }
}
