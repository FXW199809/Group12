package com.group12.es.service;

import com.group12.es.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends ElasticsearchRepository<User,String> {
    @Query("{\"query_string\" : {\"fields\" : [\"es_*\"],\"query\" : \"?\"}}")
    Page<User> queryString(String key, Pageable pageable);
}
