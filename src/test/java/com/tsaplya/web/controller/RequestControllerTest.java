package com.tsaplya.web.controller;

import com.tsaplya.web.model.State;
import com.tsaplya.web.service.PaymentService;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static com.tsaplya.web.model.State.DONE;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(RequestController.class)
public class RequestControllerTest {

    @Autowired
    private RequestController service;

    @MockBean
    PaymentService paymentServiceMock;

    @Test
    public void test() {
        when(paymentServiceMock.getRandomSate()).thenReturn(DONE);

        State paymentState = service.payment();

        assertThat(paymentState, Is.is(DONE));
    }
}