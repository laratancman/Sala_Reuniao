package com.br.Lara.Sala_Reuniao.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.Lara.Sala_Reuniao.DTO.SalaReuniaoDTO;
import com.br.Lara.Sala_Reuniao.Entity.SalaReuniao;
import com.br.Lara.Sala_Reuniao.Service.SalaReuniaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sala-reuniao")
public class SalaReuniaoController {

    @Autowired
    private SalaReuniaoService salaReuniaoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarSalaReuniao(@RequestBody @Valid SalaReuniao salaReuniao) {
        try {
            salaReuniaoService.cadastrarSalaReuniao(salaReuniao);
            return ResponseEntity.status(201).body("Sala de reunião cadastrada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Erro ao cadastrar sala de reunião: " + e.getMessage());
        }
    }

    @PostMapping("/consultar")
    public ResponseEntity<String> consultarSalaReuniao(@RequestBody SalaReuniaoDTO salaReuniao) {
        try {
            return ResponseEntity.status(200).body(salaReuniaoService.consultarSalaReuniao(salaReuniao).toString());
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Erro ao consultar sala de reunião: " + e.getMessage());
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<String> listarSalaReuniao() {
        try {
            return ResponseEntity.status(200).body(salaReuniaoService.listarSalaReuniao().toString());
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Erro ao listar sala de reunião: " + e.getMessage());
        }
    }

    @PutMapping("/atualizar")
    public ResponseEntity<String> atualizarSalaReuniao(SalaReuniaoDTO salaReuniao) {
        try {
            salaReuniaoService.atualizarSalaReuniao(salaReuniao);
            return ResponseEntity.status(200).body("Sala de reunião atualizada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Erro ao atualizar sala de reunião: " + e.getMessage());
        }
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<String> deletarSalaReuniao(@RequestBody SalaReuniaoDTO salaReuniao) {
        try {
            salaReuniaoService.deletarSalaReuniao(salaReuniao);
            return ResponseEntity.status(200).body("Sala de reunião deletada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Erro ao deletar sala de reunião: " + e.getMessage());
        }
    }
}
