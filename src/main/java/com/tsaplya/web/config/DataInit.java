package com.tsaplya.web.config;

import com.tsaplya.web.dao.RequestDao;
import com.tsaplya.web.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements ApplicationRunner {
    private RequestDao requestDao;

    @Autowired
    public DataInit(RequestDao requestDao) {
        this.requestDao = requestDao;
    }

    @Override
    public void run(ApplicationArguments args) {
        long count = requestDao.count();

        if (count == 0) {
            Request request = new Request();
            request.setRouteId(1);
            request.setDatetime(String.valueOf(System.currentTimeMillis() / 1000L));

            Request request2 = new Request();
            request2.setRouteId(2);
            request2.setDatetime(String.valueOf(System.currentTimeMillis() / 1000L));

            Request request3 = new Request();
            request3.setRouteId(3);
            request3.setDatetime(String.valueOf(System.currentTimeMillis() / 1000L));

            requestDao.save(request);
            requestDao.save(request2);
            requestDao.save(request3);
        }
    }
}