package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

  @Autowired
  private AlunoServiceImpl service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Aluno create(@Valid @RequestBody AlunoForm form) {
    return service.create(form);
  }

  @GetMapping("/avaliacoes/{id}")
  @ResponseStatus(HttpStatus.OK)
  public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
    return service.getAllAvaliacaoFisicaId(id);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                                  String dataDeNacimento){
    return service.getAll(dataDeNacimento);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@Valid @RequestBody Long id) {
    service.delete(id);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void update(@RequestBody AlunoUpdateForm form, Long id){
    service.update(id, form);
  }


}
