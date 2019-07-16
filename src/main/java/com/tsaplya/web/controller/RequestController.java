package com.tsaplya.web.controller;

import com.tsaplya.web.dao.RequestDao;
import com.tsaplya.web.model.Request;
import com.tsaplya.web.model.State;
import com.tsaplya.web.service.PaymentService;
import com.tsaplya.web.service.StatusUpdaterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@EnableAutoConfiguration
public class RequestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StatusUpdaterService.class);

    private final PaymentService paymentService;

    private final RequestDao requestDao;

    public RequestController(PaymentService paymentService, RequestDao requestDao, Request request) {
        this.paymentService = paymentService;
        this.requestDao = requestDao;
    }

    @PostMapping(value = "/requests")
    public void create(@RequestBody Request json){
        LOGGER.info("Successful create!" + json);
        requestDao.save(json);
        requestDao.findAll().forEach(it ->LOGGER.info(it.toString()));
    }

    // Проверка статуса заявки, по id
    @ResponseBody
    @RequestMapping("/request/{requestId}/status")
    public ResponseEntity<Request> get(@PathVariable long requestId){
        Optional<Request> requests = requestDao.findById(requestId);
        Request request = requests.get();
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    // Изменение статуса заявки
    @RequestMapping(value = "/payments")
    public State payment() {
        return paymentService.getRandomSate();
    }
}