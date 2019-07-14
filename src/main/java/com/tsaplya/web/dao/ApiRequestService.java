package com.tsaplya.web.dao;

import com.tsaplya.web.model.Request;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ApiRequestService {
    private final ApiRequestDao apiRequestDao;

    public ApiRequestService(ApiRequestDao apiRequestDao) {
        this.apiRequestDao = apiRequestDao;
    }

    public void create(Request apiRequest) {
        apiRequestDao.create(apiRequest);
    }
}

