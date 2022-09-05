package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.InteraccionModel;
import com.example.demo.repositories.InteraccionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InteraccionService {
    @Autowired
    InteraccionRepository interaccionRepository;
    
    public ArrayList<InteraccionModel> obtenerInteraccions(){
        return (ArrayList<InteraccionModel>) interaccionRepository.findAll();
    }

    public InteraccionModel guardarInteraccion(InteraccionModel interaccion){
        return interaccionRepository.save(interaccion);
    }

    public Optional<InteraccionModel> obtenerPorId(Long id){
        return interaccionRepository.findById(id);
    }


    public ArrayList<InteraccionModel>  obtenerPorPrioridad(Integer prioridad) {
        return interaccionRepository.findByPrioridad(prioridad);
    }

    public boolean eliminarInteraccion(Long id) {
        try{
            interaccionRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


    
}