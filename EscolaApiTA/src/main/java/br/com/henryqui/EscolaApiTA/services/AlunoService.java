package br.com.henryqui.EscolaApiTA.services;

import br.com.henryqui.EscolaApiTA.model.Aluno;
import br.com.henryqui.EscolaApiTA.repositories.AlunoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno Atualizar(Integer id, Aluno aluno){
        Aluno alunoSalvo = buscarAlunoExistente(id);

        BeanUtils.copyProperties(aluno, alunoSalvo, "id");

        return alunoRepository.save(alunoSalvo);
    }

    private Aluno buscarAlunoExistente(Integer id) {
        Optional<Aluno> alunoSalvo = alunoRepository.findById(id);

        if(!alunoSalvo.isPresent()){
            throw new IllegalArgumentException();
        }

        return alunoSalvo.get();
    }

}
