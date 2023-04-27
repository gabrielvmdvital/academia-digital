package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.service.impl.MatriculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

  @Autowired
  private MatriculaServiceImpl service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Matricula create(@Valid @RequestBody MatriculaForm form) {
    return service.create(form);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro) {
    return service.getAll(bairro);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Matricula> getByDateMatriculay(@RequestParam(value = "dataDaMatricula", required = false) LocalDateTime dateMatricula) {
    return service.getByDateMatricula(dateMatricula);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(Long id){
    service.delete(id);
  }

}

