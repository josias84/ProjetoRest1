package br.com.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Estudante;
import br.com.senac.repository.EstudanteRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EstudanteService {
	@Autowired
	private EstudanteRepository estudanteRepository;
	
	public ResponseEntity<Estudante> buscarEstudantePorId(Long id){
		Estudante estudante = estudanteRepository.findById(id).get();
		if(estudante != null) {
			return ResponseEntity.status(HttpStatus.OK).body(estudante);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	public ResponseEntity<List<Estudante>> buscarTodosEstudante(){
		List<Estudante> listaEstudantes = estudanteRepository.findAll();
		
		if(listaEstudantes != null) {
			return ResponseEntity.status(HttpStatus.OK).body(listaEstudantes);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	public ResponseEntity<Estudante> cadastrarEstudante(Estudante estudante){
		Estudante est = estudanteRepository.save(estudante);
		return ResponseEntity.status(HttpStatus.CREATED).body(est);
	}
	
	public ResponseEntity<Estudante> atualizarEstudante(Long id, Estudante estudante){
		if(estudanteRepository.existsById(id)) {
			Estudante est = estudanteRepository.save(estudante);
			return ResponseEntity.status(HttpStatus.OK).body(est);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	
	


}
