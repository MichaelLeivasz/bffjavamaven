package com.bff.bff_agendador_tarefas.infrastructure.client;

import com.bff.bff_agendador_tarefas.business.dto.in.TarefasDTORequest;
import com.bff.bff_agendador_tarefas.business.dto.out.TarefasDTOResponse;
import com.bff.bff_agendador_tarefas.business.enums.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "agendador-tarefas", url = "${agendador-tarefas.url}")
public interface TarefasClient {

    @PostMapping
    TarefasDTOResponse gravarTarefa(@RequestBody TarefasDTORequest dto,
                                    @RequestHeader(name = "Authorization", required = false) String token);

    @GetMapping("/eventos")
    List<TarefasDTOResponse> buscaListaDeTaregasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader(name = "Authorization", required = false) String token);


    @GetMapping
    List<TarefasDTOResponse> buscaTarefasPorEmail(@RequestHeader("Authorization") String token);

    @DeleteMapping
    void deletaTarefaPorId(@RequestParam("id") String id,
                           @RequestHeader(name = "Authorization", required = false) String token);

    @PatchMapping
    TarefasDTOResponse alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
                                               @RequestParam("id") String id,
                                               @RequestHeader(name = "Authorization", required = false) String token);

    @PutMapping
    TarefasDTOResponse updateTarefas(@RequestBody TarefasDTORequest dto,
                                     @RequestParam("id") String id,
                                     @RequestHeader(name = "Authorization", required = false) String token);
}
