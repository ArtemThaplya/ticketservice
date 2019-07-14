package com.tsaplya.web.service;

import com.tsaplya.web.model.Request;
import com.tsaplya.web.model.State;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Service
public class PaymentService {
    private static final List<State> STATES = new ArrayList<>(EnumSet.allOf(State.class));

    private final RandomProvider random;

    public PaymentService(RandomProvider random) {
        this.random = random;
    }

    public State getRandomSate() {
        return STATES.get(random.nextInt(STATES.size()));
    }

    public void changeState(List<Request> requests) {
        requests.stream()
                .filter(request -> !State.DONE.equals(request.getStatus()))
                .forEach(request -> request.setStatus(getRandomSate()));
    }
}
