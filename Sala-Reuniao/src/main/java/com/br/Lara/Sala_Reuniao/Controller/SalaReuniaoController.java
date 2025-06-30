package com.br.Lara.Sala_Reuniao.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.br.Lara.Sala_Reuniao.DTO.SalaReuniaoDTO;
import com.br.Lara.Sala_Reuniao.Entity.SalaReuniao;
import com.br.Lara.Sala_Reuniao.Service.SalaReuniaoService;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/sala-reuniao")
public class SalaReuniaoController {

    @Autowired
    private SalaReuniaoService salaReuniaoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarSalaReuniao(@RequestBody @Valid SalaReuniao salaReuniao) {
        try {
            salaReuniaoService.cadastrarSalaReuniao(salaReuniao);
            return ResponseEntity.status(201).body("Sala de reunião cadastrada com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro interno: " + e.getMessage());
        }
    }

    // {id} -> o id vai URL do Site
    // @PathVariable -> vai pegar o id do URL
    // Optional -> pode ter ou nao ter o dado
    @GetMapping("/consultar/{id}")
    public ResponseEntity<SalaReuniao> consultarSalaReuniao(@PathVariable int id) {
        Optional<SalaReuniao> resultado = salaReuniaoService.consultarSalaReuniaoPorId(id);
        if (resultado.isPresent()) {
            return ResponseEntity.ok(resultado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // String -> Algum texto
    // List -> Lista de dados
    @GetMapping("/listar")
    public ResponseEntity<List<SalaReuniao>> listarSalaReuniao() {
        try {
            List<SalaReuniao> salas = salaReuniaoService.listarSalaReuniao();
            return ResponseEntity.ok(salas);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @PutMapping("/atualizar")
    public ResponseEntity<String> atualizarSalaReuniao(@RequestBody SalaReuniaoDTO salaReuniao) {
        try {
            salaReuniaoService.atualizarSalaReuniao(salaReuniao);
            return ResponseEntity.status(200).body("Sala de reunião atualizada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Erro ao atualizar sala de reunião: " + e.getMessage());
        }
    }

    // {id} -> o id vai URL do Site
    // @PathVariable -> vai pegar o id do URL
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarSalaReuniao(@PathVariable int id) {
        try {
            salaReuniaoService.deletarSalaReuniao(id);
            return ResponseEntity.ok("Sala de reunião deletada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Erro ao deletar sala de reunião: " + e.getMessage());
        }
    }

    @GetMapping("/consultar")
    public ResponseEntity<List<SalaReuniao>> consultarPorNome(@RequestParam String nome) {
        List<SalaReuniao> resultado = salaReuniaoService.consultarSalaReuniaoPorNome(nome);
        return ResponseEntity.ok(resultado);
    }
}
