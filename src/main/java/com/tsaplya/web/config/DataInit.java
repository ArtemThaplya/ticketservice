package com.tsaplya.web.config;

import com.tsaplya.web.dao.RequestDao;
import com.tsaplya.web.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DataInit implements ApplicationRunner {
    private RequestDao requestDao;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    @Autowired
    public DataInit(RequestDao requestDao) {
        this.requestDao = requestDao;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = requestDao.count();

        if (count == 0) {
            Request request = new Request();
            request.setRouteId(1);
            request.setDatetime(sdf.format(new Date()));
            //
            Request request2 = new Request();
            request2.setRouteId(2);
            request2.setDatetime(sdf.format(new Date()));

            Request request3 = new Request();
            request3.setRouteId(3);
            request3.setDatetime(sdf.format(new Date()));

            requestDao.save(request);
            requestDao.save(request2);
            requestDao.save(request3);
        }
    }
}