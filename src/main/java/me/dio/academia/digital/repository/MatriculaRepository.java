package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

  /**
   *
   * @param bairro bairro referência para o filtro
   * @return lista de alunos matriculados que residem no bairro passado como parâmetro
   */
  @Query(value = "SELECT * FROM tb_matriculas m " +
      "LEFT JOIN tb_alunos a ON m.aluno_id = a.id " +
      "WHERE a.bairro = :bairro", nativeQuery = true)
  //@Query("FROM Matricula m WHERE m.aluno.bairro = :bairro ")
  List<Matricula> findAlunosMatriculadosBairro(String bairro);

  //List<Matricula> findByAlunoBairro(String bairro);

  @Query(value = "SELECT * FROM tb_matriculas as M" +
          "LEFT JOIN tb_alunos as A ON A.id = M.aluno_id " +
          "WHERE M.dataDaMatricula = :dateMatricula",
          nativeQuery = true)
  List<Matricula> findBydateMatricula(LocalDateTime dateMatricula);

  @Modifying
  @Transactional
  @Query(value = "DELETE FROM tb_matriculas m WHERE m.id = :id", nativeQuery = true)
  void delete(@Param("id") Long id);


}
