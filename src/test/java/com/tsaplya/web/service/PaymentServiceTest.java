package com.tsaplya.web.service;


import com.tsaplya.web.model.State;
import org.junit.Test;

import static com.tsaplya.web.model.State.IN_PROGRESS;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PaymentServiceTest {
    private final RandomProvider randomMock = mock(RandomProvider.class);
    private final PaymentService paymentService = new PaymentService(randomMock);

    @Test
    public void whenRandomIsZeroThenReturnFirstState() {
        when(randomMock.nextInt(anyInt())).thenReturn(IN_PROGRESS.ordinal());

        State state = paymentService.getSate();
        assertThat(state, is(IN_PROGRESS));
    }
}