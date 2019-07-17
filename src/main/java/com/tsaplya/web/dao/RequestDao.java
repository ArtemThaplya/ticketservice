package com.tsaplya.web.dao;

import com.tsaplya.web.model.Request;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestDao extends CrudRepository<Request, Long> {
}

