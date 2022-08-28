package com.univesp.dce.apigerenciadordce.domain.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univesp.dce.apigerenciadordce.domain.exception.CursoNaoEncontradoException;
import com.univesp.dce.apigerenciadordce.domain.exception.NegocioException;
import com.univesp.dce.apigerenciadordce.domain.model.Curso;
import com.univesp.dce.apigerenciadordce.domain.repository.CursoRepository;

@Service
public class CadastroCursoService {

    @Autowired
    CursoRepository cursoRepository;

    @Transactional
    public Curso salvar(Curso Curso) {
      // CursoRepository.detach(Curso);

      Optional<Curso> cursoExistente = cursoRepository.findByNome(Curso.getNome());

      if (cursoExistente.isPresent() && !cursoExistente.get().equals(Curso)) {
        throw new NegocioException(
            String.format("Curso já cadastrado: %s", Curso.getNome()));
      }

      return cursoRepository.save(Curso);
    }

    @Transactional
    public void excluir(Long CursoId) {
      // CursoRepository.detach(Curso);
      Optional<Curso> CursoExistente = cursoRepository.findById(CursoId);
      if (CursoExistente.isPresent() && !CursoExistente.get().equals(CursoExistente)) {
        cursoRepository.deleteById(CursoId);
      }
    }
    
    public Curso buscarOuFalhar(Long cursoId) {
      return cursoRepository.findById(cursoId)
          .orElseThrow(() -> new CursoNaoEncontradoException(cursoId));
    }
}
