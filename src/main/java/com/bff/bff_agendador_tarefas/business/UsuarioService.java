package com.bff.bff_agendador_tarefas.business;

import com.bff.bff_agendador_tarefas.business.dto.in.EnderecoDTORequest;
import com.bff.bff_agendador_tarefas.business.dto.in.LoginDTORequest;
import com.bff.bff_agendador_tarefas.business.dto.in.TelefoneDTORequest;
import com.bff.bff_agendador_tarefas.business.dto.in.UsuarioDTORequest;
import com.bff.bff_agendador_tarefas.business.dto.out.EnderecoDTOResponse;
import com.bff.bff_agendador_tarefas.business.dto.out.TelefoneDTOResponse;
import com.bff.bff_agendador_tarefas.business.dto.out.UsuarioDTOResponse;
import com.bff.bff_agendador_tarefas.business.dto.out.ViaCepDTOResponse;
import com.bff.bff_agendador_tarefas.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO) {
        return client.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginDTORequest usuarioDTO){
        return client.login(usuarioDTO);
    }

    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token) {
        return client.buscarUsuarioPorEmail(email, token);
    }

    public void deletarUsuarioPorEmail(String email, String token){
        client.deletarUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizarDadosUsuario(String token, UsuarioDTORequest dto){
        return client.atualizaDadosUsuario(dto, token);
    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest enderecoDTO, String token){
        return client.atualizaEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest telefoneDTO, String token){
        return client.atualizaTelefone(telefoneDTO, idTelefone, token);
    }

    public EnderecoDTOResponse cadastraEndereco(String token, EnderecoDTORequest dto){
        return client.cadastraEndereco(dto, token);
    }

    public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTORequest dto){
        return client.cadastraTelefone(dto, token);
    }

    public ViaCepDTOResponse buscarEnderecoPorCep(String cep){
        return client.buscarDadosCep(cep);
    }
}