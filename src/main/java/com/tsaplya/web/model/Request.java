package com.tsaplya.web.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;

@Entity
@Configuration
@Table(name = "Request")
public class Request {
    @Column(name = "routeId")
    private long routeId;

    @Column(name = "datetime")
    private String datetime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "requestId")
    private long requestId;

    @Column(name = "status")
    private State status;

    public Request() {
    }

    @Bean
    Request createa() {
        return new Request();
    }

    public Request(long routeId, String datetime) {
        this.routeId = routeId;
        this.datetime = datetime;
    }

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public State getStatus() {
        return status;
    }

    public void setStatus(State status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Request{" +
                "routeId=" + routeId +
                ", datetime=" + datetime +
                ", requestId=" + requestId +
                ", status=" + status +
                '}';
    }
}
