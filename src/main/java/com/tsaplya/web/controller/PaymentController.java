package com.tsaplya.web.controller;

import com.tsaplya.web.model.State;
import com.tsaplya.web.service.PaymentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @RequestMapping("/payments")
    public State payment() {
//        List<Request> requests = requestRepository.findAll();
//                paymentService.changeState(requests);
        return paymentService.getRandomSate();
    }

    public void checkStatusRequest(){

    }
}