package com.br.Lara.Sala_Reuniao.DTO;

public record SalaReuniaoDTO(
        int id,
        String nome,
        Integer capacidade,
        String localizacao,
        Boolean possuiProjetor,
        Boolean possuiArCondicionado,
        Integer numCadeiras,
        String tipoMesa,
        String recursosAdicionais) {
}
