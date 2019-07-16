package com.tsaplya.web.service;

import com.tsaplya.web.dao.RequestDao;
import com.tsaplya.web.model.Request;
import com.tsaplya.web.model.State;
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
import java.util.List;

@Service
@Configuration
@EnableScheduling
public class StatusUpdaterService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StatusUpdaterService.class);

    private final CloseableHttpClient httpClient;
    private final RequestDao requestDao;

    @Autowired
    public StatusUpdaterService(CloseableHttpClient httpClient, RequestDao requestDao) {
        this.httpClient = httpClient;
        this.requestDao = requestDao;
    }

    @Bean
    public Runnable updateStatus() {
        return new Runnable() {
            @Override
            @Scheduled(fixedRate = 60000)
            public void run() {
                List<Request> requests = (List<Request>) requestDao.findAll();

                for (final Request request : requests) {
                    if (request.getStatus() == State.DONE) {
                        continue; //todo extract to DAO layer
                    }
                    try (CloseableHttpResponse response = httpClient.execute(HttpHost.create("localhost:8080"), new HttpGet("/payments"))) {
                        InputStream inputStream = response.getEntity().getContent();
                        String state = IOUtils.toString(inputStream);
                        LOGGER.info("Response: " + state);
//                        request.setStatus(State.valueOf(state));
//                        requestDao.save(request);
                        LOGGER.info("Successful update!");
                    } catch (IOException e) {
                        LOGGER.error("Error update!", e);
                    }
                }
            }
        };
    }
}
