package com.compasso.ProjetoMercado.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.compasso.ProjetoMercado.entity.Funcionario;
import com.compasso.ProjetoMercado.repository.FuncionarioRepository;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {
	
	private TokenService tokenService;
	private FuncionarioRepository funcionarioRepository;
	
	public AutenticacaoViaTokenFilter(TokenService tokenService, FuncionarioRepository funcionarioRepository) {
		this.tokenService = tokenService;
		this.funcionarioRepository = funcionarioRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recuperarToken(request);
		boolean valido = tokenService.isTokenValido(token);
		if (valido) {
			autenticarCliente(token);
		}
		
		filterChain.doFilter(request, response);
	}

	private void autenticarCliente(String token) {
		Long idFuncionario = tokenService.getIdFuncionario(token);
		Funcionario funcionario = funcionarioRepository.findById(idFuncionario).get();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(funcionario, null, funcionario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		
		return token.substring(7, token.length());
	}

}
