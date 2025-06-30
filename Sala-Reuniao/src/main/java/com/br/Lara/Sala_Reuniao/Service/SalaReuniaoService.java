package com.br.Lara.Sala_Reuniao.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.Lara.Sala_Reuniao.DTO.SalaReuniaoDTO;
import com.br.Lara.Sala_Reuniao.Entity.SalaReuniao;
import com.br.Lara.Sala_Reuniao.Repository.SalaReuniaoRepository;

@Service
public class SalaReuniaoService {

    @Autowired
    private SalaReuniaoRepository salaReuniaoRepository;

    // -> A gente ja tinha visto.
    public void cadastrarSalaReuniao(SalaReuniao salaReuniao) {

        SalaReuniao nomeExiste = salaReuniaoRepository.findByNome(salaReuniao.getNome());

        if (nomeExiste != null) {
            throw new IllegalArgumentException("Já existe uma sala de reunião com o nome " + salaReuniao.getNome());
        }

        SalaReuniao localizacaoExiste = salaReuniaoRepository.findByLocalizacao(salaReuniao.getLocalizacao());

        if (localizacaoExiste != null) {
            throw new IllegalArgumentException(
                    "Já existe uma sala de reunião cadastrada na localização " + salaReuniao.getLocalizacao());
        }

        salaReuniaoRepository.save(salaReuniao);
    }

    // -> A gente ja tinha visto.
    public void atualizarSalaReuniao(SalaReuniaoDTO salaReuniao) {
        SalaReuniao salaReuniaoExiste = salaReuniaoRepository.findById(salaReuniao.id()).orElse(null);

        if (salaReuniaoExiste == null) {
            throw new IllegalArgumentException("Não existe uma sala de reunião com o id " + salaReuniao.id());
        }

        if (salaReuniao.nome() != null) {
            salaReuniaoExiste.setNome(salaReuniao.nome());
        }

        if (salaReuniao.capacidade() != null) {
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

        if (salaReuniao.numCadeiras() != null) {
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

    // -> A gente ja tinha visto.
    public List<SalaReuniao> listarSalaReuniao() {

        return salaReuniaoRepository.findAll();
    }

    // -> Pode ter ou nao ter
    // -> A gente ja tinha visto.
    public Optional<SalaReuniao> consultarSalaReuniaoPorId(int id) {

        return salaReuniaoRepository.findById(id);
    }

    // -> A gente ja tinha visto.
    public void deletarSalaReuniao(int id) {
        if (!salaReuniaoRepository.existsById(id)) {
            throw new IllegalArgumentException("Sala de reunião com id " + id + " não existe.");
        }

        salaReuniaoRepository.deleteById(id);
    }

    // -> A gente ja tinha visto.
    public List<SalaReuniao> consultarSalaReuniaoPorNome(String nome) {

        return salaReuniaoRepository.findByNomeContainingIgnoreCase(nome);
    }
}
