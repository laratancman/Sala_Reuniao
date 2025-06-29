package com.br.Lara.Sala_Reuniao.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "sala_reuniao")
public class SalaReuniao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank // para strings
    @Size(min = 10, max = 20, message = "O nome da sala de reunião deve ter entre 10 e 20 caracteres")
    @Column(unique = true)
    private String nome;
    @NotNull // para demais
    private int capacidade;
    @NotBlank
    @Size(min = 10, max = 100, message = "O local da sala de reunião deve ter entre 10 e 100 caracteres")
    @Column(unique = true)
    private String localizacao;
    @NotNull
    private Boolean possuiProjetor;
    @NotNull
    private Boolean possuiArCondicionado;
    @NotNull
    private int numCadeiras;
    @NotBlank
    @Size(min = 10, max = 20, message = "O tipo da mesa da sala de reunião deve ter entre 10 e 20 caracteres")
    private String tipoMesa;
    @NotBlank
    @Size(min = 10, max = 60, message = "O tipo da cadeira da sala de reunião deve ter entre 10 e 60 caracteres")
    private String recursosAdicionais;
}
