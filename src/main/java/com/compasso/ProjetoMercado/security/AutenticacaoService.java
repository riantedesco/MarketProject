package com.compasso.ProjetoMercado.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.compasso.ProjetoMercado.entity.Funcionario;
import com.compasso.ProjetoMercado.repository.FuncionarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Funcionario> funcionario = this.funcionarioRepository.findByCpf(username);
		if (funcionario.isPresent()) {
			return funcionario.get();
		}
		
		throw new UsernameNotFoundException("Dados inválidos");	
	}
}
