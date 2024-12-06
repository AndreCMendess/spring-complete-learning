package com.api.funcionario.api_funcionario.repository;

import com.api.funcionario.api_funcionario.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    Funcionario findByNome(String nome);
    List<Funcionario> findByNomeOrEmail(String nome, String email);
    List<Funcionario> findByNomeStartingWith(String nome);
    List<Funcionario> findByNomeEndingWith(String nome);
    List<Funcionario> findByNomeContaining(String nome);
    List<Funcionario> findByOrderByNomeAsc();
    List<Funcionario> findByOrderByNomeDesc();

    @Query(value="SELECT * FROM Funcionario f WHERE f.salario = (SELECT MAX(salario)  FROM Funcionario) LIMIT 1", nativeQuery = true)
    Funcionario findMaiorSalario();



}
