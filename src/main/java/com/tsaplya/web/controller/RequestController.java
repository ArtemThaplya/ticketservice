package com.tsaplya.web.controller;

import com.tsaplya.web.dao.RequestDao;
import com.tsaplya.web.model.Request;
import com.tsaplya.web.model.State;
import com.tsaplya.web.service.PaymentService;
import com.tsaplya.web.service.StatusUpdaterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
@EnableAutoConfiguration
public class RequestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StatusUpdaterService.class);
    private final PaymentService paymentService;
    private final RequestDao requestDao;

    public RequestController(PaymentService paymentService, RequestDao requestDao) {
        this.paymentService = paymentService;
        this.requestDao = requestDao;
    }

    // Прием заявоки на оплату
    @PostMapping(value = "/requests")
    public Request create(@Valid @RequestBody Request json) {
        LOGGER.info("Successful create!" + json);
        requestDao.save(json);
        requestDao.findAll().forEach(it -> LOGGER.info(it.toString()));
        return requestDao.findById(json.getRequestId()).get();
    }

    // Проверка статуса заявки, по id
    @RequestMapping(value = "/request/{requestId}", method = GET)
    @ResponseBody
    public State get(@Valid @PathVariable("requestId") long requestId) {
        return requestDao.findById(requestId).get().getStatus();
    }

    // Изменение статуса заявки
    @RequestMapping(value = "/payments")
    public State payment() {
        Iterable<Request> all = requestDao.findAll();
        for (Request request : all) {
            if (!(request.getStatus() == State.DONE)) {
                request.setStatus(paymentService.getRandomSate());
                requestDao.save(request);
            }
        }
        return paymentService.getRandomSate();
    }
}