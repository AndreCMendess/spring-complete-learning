package com.api.funcionario.api_funcionario.repository;

import com.api.funcionario.api_funcionario.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}
