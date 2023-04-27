package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

  @Autowired
  private AvaliacaoFisicaServiceImpl service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form) {
    return service.create(form);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<AvaliacaoFisica> getAll(){
    return service.getAll();
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(Long id){
      service.delete(id);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void update(@RequestBody AvaliacaoFisicaUpdateForm form, Long id){
    service.update(id, form);
  }



}
