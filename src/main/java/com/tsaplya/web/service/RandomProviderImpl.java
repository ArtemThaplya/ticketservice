package com.tsaplya.web.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomProviderImpl implements RandomProvider {
    private static final Random RANDOM = new Random();

    @Override
    public int nextInt(int bound) {
        return RANDOM.nextInt(bound);
    }
}
