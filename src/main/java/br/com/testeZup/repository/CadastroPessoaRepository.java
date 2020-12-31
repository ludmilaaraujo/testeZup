package br.com.testeZup.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.testeZup.modelo.CadastroPessoa;

public interface CadastroPessoaRepository extends JpaRepository<CadastroPessoa, Long>{
	
	Optional<CadastroPessoa> findByCpf(String cpf);
	
	Optional<CadastroPessoa> findByEmail(String email);


}
