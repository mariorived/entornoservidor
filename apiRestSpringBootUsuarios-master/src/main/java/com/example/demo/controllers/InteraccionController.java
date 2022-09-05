package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.InteraccionModel;
import com.example.demo.services.InteraccionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/interaccion")
public class InteraccionController {
    @Autowired
    InteraccionService interaccionService;

    @GetMapping()
    public ArrayList<InteraccionModel> obtenerInteraccions(){
        return interaccionService.obtenerInteraccions();
    }

    @PostMapping()
    public InteraccionModel guardarInteraccion(@RequestBody InteraccionModel interaccion){
        return this.interaccionService.guardarInteraccion(interaccion);
    }

    @GetMapping( path = "/{id}")
    public Optional<InteraccionModel> obtenerInteraccionPorId(@PathVariable("id") Long id) {
        return this.interaccionService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<InteraccionModel> obtenerInteraccionPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.interaccionService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.interaccionService.eliminarInteraccion(id);
        if (ok){
            return "Se eliminó el interaccion con id " + id;
        }else{
            return "No pudo eliminar el interaccion con id" + id;
        }
    }

}