package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

  /**
   *
   * @param dataDeNascimento: data de nascimento dos alunos
   * @return lista com todos os alunos com a data de nascimento passada como parâmetro da função
   */
  List<Aluno> findByDataDeNascimento(LocalDate dataDeNascimento);

  @Query(value = "SELECT * FROM tb_alunos as A ON A.id = M.aluno_id " +
          "WHERE M.dataDaMatricula = :dateMatricula",
          nativeQuery = true)
  List<Aluno> findByCpf (String cpf);


  @Modifying
  @Query(value = "UPDATE tb_aluno a SET a.nome = :#{#form.nome}, a.bairro = :#{#form.bairro}," +
          " a.dataDeNascimento = :#{#form.dataDeNascimento} WHERE a.id = :id", nativeQuery = true)
  void update(@Param("id") Long id, @Param("formUpdate") AlunoUpdateForm formUpdate);

  @Modifying
  @Query(value = "DELETE FROM tb_aluno a WHERE a.id = :id", nativeQuery = true)
  void delete(@Param("id") Long id);

}
