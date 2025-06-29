package com.br.Lara.Sala_Reuniao.DTO;

public record SalaReuniaoDTO(
    int id,
    String nome,
    int capacidade,
    String localizacao,
    Boolean possuiProjetor,
    Boolean possuiArCondicionado,
    int numCadeiras,
    String tipoMesa,
    String recursosAdicionais
) {
    
}
