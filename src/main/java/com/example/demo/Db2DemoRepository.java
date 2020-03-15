package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Profile("db2")
public class Db2DemoRepository implements DemoRepository {

    @Autowired
    private JdbcTemplate template;

    @Override
    public void sleep() {
        template.execute("call SYSIBMADM.DBMS_ALERT.SLEEP(30)");
    }
}
