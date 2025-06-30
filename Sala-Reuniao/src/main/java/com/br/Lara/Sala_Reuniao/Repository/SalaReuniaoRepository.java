package com.br.Lara.Sala_Reuniao.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.Lara.Sala_Reuniao.Entity.SalaReuniao;

@Repository
public interface SalaReuniaoRepository extends JpaRepository<SalaReuniao, Integer> {

    SalaReuniao findByNome(String nome);

    SalaReuniao findByLocalizacao(String localizacao);

    List<SalaReuniao> findByNomeContainingIgnoreCase(String nome);
    
}
