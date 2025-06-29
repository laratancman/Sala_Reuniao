package com.br.Lara.Sala_Reuniao.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.Lara.Sala_Reuniao.DTO.SalaReuniaoDTO;
import com.br.Lara.Sala_Reuniao.Entity.SalaReuniao;
import com.br.Lara.Sala_Reuniao.Repository.SalaReuniaoRepository;

@Service
public class SalaReuniaoService {

    @Autowired
    private SalaReuniaoRepository salaReuniaoRepository;

    public void cadastrarSalaReuniao(SalaReuniao salaReuniao) {

        System.out.println(salaReuniao.toString());

        SalaReuniao nomeExiste = salaReuniaoRepository.findByNome(salaReuniao.getNome());
        if (nomeExiste != null) {
            throw new IllegalArgumentException("Já existe uma sala de reunião com o nome " + salaReuniao.getNome());
        }
        SalaReuniao localizacaoExiste = salaReuniaoRepository.findByLocalizacao(salaReuniao.getLocalizacao());
        if (localizacaoExiste != null) {
            throw new IllegalArgumentException(
                    "Já existe uma sala de reunião com o nome " + salaReuniao.getLocalizacao());
        }

        salaReuniaoRepository.save(salaReuniao);
    }

    public String consultarSalaReuniao(SalaReuniaoDTO salaReuniao) {

        SalaReuniao salaReuniaoBuscada = salaReuniaoRepository.findByNome(salaReuniao.nome());
        return salaReuniaoBuscada.toString();
    }

    public void atualizarSalaReuniao(SalaReuniaoDTO salaReuniao) {
        SalaReuniao salaReuniaoExiste = salaReuniaoRepository.findById(salaReuniao.id()).orElse(null);

        if (salaReuniaoExiste == null) {
            throw new IllegalArgumentException("Não existe uma sala de reunião com o id " + salaReuniao.id());
        }

        if (salaReuniao.nome() != null) {
            salaReuniaoExiste.setNome(salaReuniao.nome());  
        }

        if (salaReuniao.capacidade() != 0) {
            salaReuniaoExiste.setCapacidade(salaReuniao.capacidade());
        }

        if (salaReuniao.localizacao() != null) {
            salaReuniaoExiste.setLocalizacao(salaReuniao.localizacao());
        }

        if (salaReuniao.possuiProjetor() != null) {
            salaReuniaoExiste.setPossuiProjetor(salaReuniao.possuiProjetor());
        }

        if (salaReuniao.possuiArCondicionado() != null) {
            salaReuniaoExiste.setPossuiArCondicionado(salaReuniao.possuiArCondicionado());
        }

        if (salaReuniao.numCadeiras() != 0) {
            salaReuniaoExiste.setNumCadeiras(salaReuniao.numCadeiras());
        }

        if (salaReuniao.tipoMesa() != null) {
            salaReuniaoExiste.setTipoMesa(salaReuniao.tipoMesa());
        }

        if (salaReuniao.recursosAdicionais() != null) {
            salaReuniaoExiste.setRecursosAdicionais(salaReuniao.recursosAdicionais());
        }
        salaReuniaoRepository.save(salaReuniaoExiste);
    }

    public void deletarSalaReuniao(SalaReuniaoDTO salaReuniao) {
        SalaReuniao salaReuniaoExiste = salaReuniaoRepository.findByNome(salaReuniao.nome());
        if (salaReuniaoExiste == null) {
            throw new IllegalArgumentException("Não existe uma sala de reunião com o nome " + salaReuniao.nome());
        }
        salaReuniaoRepository.delete(salaReuniaoExiste);
    }

    public Object listarSalaReuniao() {
        
        return salaReuniaoRepository.findAll();
    }

}
