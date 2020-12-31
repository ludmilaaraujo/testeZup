package br.com.testeZup.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testeZup.controller.form.CadastroPessoaForm;
import br.com.testeZup.modelo.CadastroPessoa;
import br.com.testeZup.repository.CadastroPessoaRepository;

@RestController
@RequestMapping("/cadastro")
public class CadastroPessoaController {
	
	@Autowired
	CadastroPessoaRepository cadastroRepository;
	
	@PostMapping
	public ResponseEntity abreConta(@RequestBody @Valid CadastroPessoaForm form) {
		
		CadastroPessoa cadastroConversao = form.converter();
		try {
			Optional<CadastroPessoa> temCpf = cadastroRepository.findByCpf(form.getCpf());
			Optional<CadastroPessoa> temEmail = cadastroRepository.findByEmail(form.getEmail());
			
			if(temCpf.isPresent()) {
				return ResponseEntity.ok("Cpf já existe");
			}
			
			if(temEmail.isPresent()) {
				return ResponseEntity.ok("Email já existe");
			}			
			
			cadastroRepository.save(cadastroConversao);

			return ResponseEntity.ok(cadastroConversao);
			
		} catch (Exception e) {
			
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body("Error Message " + e.getMessage());
		}
		
	}
}
 