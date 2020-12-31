package br.com.testeZup.controller.form;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.testeZup.modelo.CadastroPessoa;

public class CadastroPessoaForm {	
	
	@NotNull @NotEmpty
	private String nome;	
	@NotNull @NotEmpty @Email
	private String email;
	@NotNull @NotEmpty @Length(min = 11)
	private String cpf;
	@NotNull
	private Date dataDeNascimento;
	
	public CadastroPessoa converter() {
		return new CadastroPessoa(this.nome, this.email, this.cpf, this.dataDeNascimento);
	}		
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

}
