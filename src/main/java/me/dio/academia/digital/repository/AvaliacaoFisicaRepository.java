package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, Long> {



    @Modifying
    @Query(value = "DELETE FROM tb_avaliacoes a WHERE a.id = :id", nativeQuery = true)
    void delete(@Param("id") Long id);


    @Modifying
    @Query(value = "UPDATE tb_avaliacoes a SET a.peso = :#{#form.peso}, a.altura = :#{#form.altura}," +
            " a.dataDeNascimento = :#{#form.dataDeNascimento} WHERE a.id = :id", nativeQuery = true)
    void update(@Param("id") Long id, @Param("formUpdate") AvaliacaoFisicaUpdateForm formUpdate);

}
