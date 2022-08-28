package com.univesp.dce.apigerenciadordce.domain.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univesp.dce.apigerenciadordce.domain.exception.EixoNaoEncontradoException;
import com.univesp.dce.apigerenciadordce.domain.exception.NegocioException;
import com.univesp.dce.apigerenciadordce.domain.model.Eixo;
import com.univesp.dce.apigerenciadordce.domain.repository.EixoRepository;

@Service
public class CadastroEixoService {
    @Autowired
    EixoRepository eixoRepository;

    @Transactional
    public Eixo salvar(Eixo eixo) {
        // EixoRepository.detach(Eixo);

        Optional<Eixo> eixoExistente = eixoRepository.findByNome(eixo.getNome());

        if (eixoExistente.isPresent() && !eixoExistente.get().equals(eixo)) {
            throw new NegocioException(
                    String.format("Eixo já cadastrado: %s", eixo.getNome()));
        }
        return eixoRepository.save(eixo);
    }

    @Transactional
    public void excluir(Long EixoId) {
        // EixoRepository.detach(Eixo);
        Optional<Eixo> eixoExistente = eixoRepository.findById(EixoId);
        if (eixoExistente.isPresent() && !eixoExistente.get().equals(eixoExistente)) {
            eixoRepository.deleteById(EixoId);
        }
    }

    public Eixo buscarOuFalhar(Long eixoId) {
        return eixoRepository.findById(eixoId)
            .orElseThrow(() -> new EixoNaoEncontradoException(eixoId));
      }
}
