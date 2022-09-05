package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.models.InteraccionModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteraccionRepository extends CrudRepository<InteraccionModel, Long> {
    public abstract ArrayList<InteraccionModel> findByPrioridad(Integer prioridad);

}