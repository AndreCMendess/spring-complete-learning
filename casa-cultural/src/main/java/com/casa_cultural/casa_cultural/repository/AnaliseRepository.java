package com.casa_cultural.casa_cultural.repository;

import com.casa_cultural.casa_cultural.model.Analise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnaliseRepository extends JpaRepository<Analise,Integer> {
}
