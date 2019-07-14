package com.tsaplya.web.controller;

import com.tsaplya.web.dao.ApiRequestDao;
import com.tsaplya.web.dao.ApiRequestService;
import com.tsaplya.web.model.State;
import com.tsaplya.web.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class RequestController {
    private final PaymentService paymentService;
    private final ApiRequestService apiRequestService;
    private final ApiRequestDao apiRequestDao;


    public RequestController(PaymentService paymentService, ApiRequestService apiRequestService, ApiRequestDao apiRequestDao) {
        this.paymentService = paymentService;
        this.apiRequestService = apiRequestService;
        this.apiRequestDao = apiRequestDao;
    }

    private static final Logger logger = LoggerFactory.getLogger(RequestController.class);
    @RequestMapping(value = "/request/{requestId}")
    public void getStatusByID(@PathVariable(name="requestId")int requestId) {
        apiRequestDao.getApiRequestById(requestId);
    }


    @RequestMapping("/payments")
    public State payment() {
//        List<Request> requests = requestRepository.findAll();
//                paymentService.changeState(requests);
        return paymentService.getRandomSate();
    }
}