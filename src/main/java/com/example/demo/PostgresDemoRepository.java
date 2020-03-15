package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Profile("postgres")
public class PostgresDemoRepository implements DemoRepository {

    @Autowired
    private JdbcTemplate template;

    @Override
    public void sleep() {
        template.execute("select pg_sleep(30);");
    }
}
