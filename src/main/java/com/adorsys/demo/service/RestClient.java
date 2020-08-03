package com.adorsys.demo.service;

import com.adorsys.demo.entity.ToDo;
import com.sun.tools.javac.comp.Todo;

import java.util.List;

public interface RestClient {

    public List<ToDo> getToDos();
}
