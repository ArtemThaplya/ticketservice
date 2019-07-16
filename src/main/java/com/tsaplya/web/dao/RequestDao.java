package com.tsaplya.web.dao;

import com.tsaplya.web.model.Request;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RequestDao extends CrudRepository<Request, Long> {
}

//@Repository
//public class RequestDao {
//    private SessionFactory sessionFactory;
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public void create(Request apiRequest) {
//        entityManager.persist(apiRequest);
//    }
//
//    public void update(Request apiRequest) {
//        entityManager.merge(apiRequest);
//    }
//
//    public Request getApiRequestById(long id) {
//        return entityManager.find(Request.class, id);
//    }
//
//    public void delete(long id) {
//        Request apiRequest = getApiRequestById(id);
//        if (apiRequest != null) {
//            entityManager.remove(apiRequest);
//        }
//    }
//
//    public List<Request> findAllRequest() {
//        Query query = entityManager.createNamedQuery("findAllRequest");
//        return query.getResultList();
//    }
//}
