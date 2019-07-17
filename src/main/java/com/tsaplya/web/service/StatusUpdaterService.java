package com.tsaplya.web.service;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
@Configuration
@EnableScheduling
public class StatusUpdaterService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StatusUpdaterService.class);
    private final CloseableHttpClient httpClient;

    @Autowired
    public StatusUpdaterService(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Bean
    public Runnable updateStatus() {
        return new Runnable() {
            @Override
            @Scheduled(fixedRate = 60000)
            public void run() {
                try (CloseableHttpResponse response = httpClient.execute(HttpHost.create("localhost:8080"), new HttpGet("/payments"))) {
                    InputStream inputStream = response.getEntity().getContent();
                    String state = IOUtils.toString(inputStream);
                    LOGGER.info("Response: " + state);
                    LOGGER.info("Successful update!");
                } catch (IOException e) {
                    LOGGER.error("Error update!", e);
                }
            }
        };
    }
}
