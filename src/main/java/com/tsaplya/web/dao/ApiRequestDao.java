package com.tsaplya.web.dao;

import com.tsaplya.web.model.Request;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ApiRequestDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void create(Request apiRequest) {
        entityManager.persist(apiRequest);
    }

    public void update(Request apiRequest) {
        entityManager.merge(apiRequest);
    }

    public Request getApiRequestById(long id) {
        return entityManager.find(Request.class, id);
    }

    public void delete(long id) {
        Request apiRequest = getApiRequestById(id);
        if (apiRequest != null) {
            entityManager.remove(apiRequest);
        }
    }
}
