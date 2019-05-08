package com.isra.pratice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.isra.pratice.domain.Pessoa;
import com.isra.pratice.dto.PessoaDTO;
import com.isra.pratice.repository.PessoaRepository;
import com.isra.pratice.services.exceptions.DataIntegrityException;
import com.isra.pratice.services.exceptions.ObjectNotFoundException;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repo;
	
	public Pessoa find(Integer id) {
		Optional<Pessoa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pessoa.class.getName()));
	}
	
	public List<Pessoa> findAll(){
		return repo.findAll();
	}
	
	public Pessoa insert(Pessoa obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir um Cliente porque há entidades relacionadas");
		}
	}
	
	public Pessoa update(Pessoa obj) {
		Pessoa newObj = find(obj.getId());
		updateData(newObj,obj);
		return repo.save(newObj);
	}
	
	private void updateData(Pessoa newObj, Pessoa obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		newObj.setCpf(obj.getCpf());
	}

	public Pessoa fromDTO(PessoaDTO objDto) {
		return new Pessoa(objDto.getId(), objDto.getNome(), objDto.getEmail(), objDto.getCpf());
	}

}
