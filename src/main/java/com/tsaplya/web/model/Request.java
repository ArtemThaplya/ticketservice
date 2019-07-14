package com.tsaplya.web.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Entity
@Repository
@Table(name = "Requests")
public class Request {
    @Column(name = "routeId")
    private int routeId;
    @Column(name = "datetime")
    private int datetime;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int requestId;
    @Column(name = "status")
    private State status;

    public Request() {
    }

    public Request(int routeId, int datetime) {
        this.routeId = routeId;
        this.datetime = datetime;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getDatetime() {
        return datetime;
    }

    public void setDatetime(int datetime) {
        this.datetime = datetime;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
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
