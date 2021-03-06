package com.example.demo;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log
public class DemoService {

    @Autowired
    private DemoRepository repository;

    @Transactional(readOnly = true, timeout = 15)
    public void sleep() {
        repository.sleep();
    }
}
