//package com.compasso.ProjetoMercado.security;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import com.compasso.ProjetoMercado.entity.Caixa;
//import com.compasso.ProjetoMercado.repository.CaixaRepository;
//
//public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {
//	
//	private TokenService tokenService;
//	private CaixaRepository caixaRepository;
//	
//	public AutenticacaoViaTokenFilter(TokenService tokenService, CaixaRepository caixaRepository) {
//		this.tokenService = tokenService;
//		this.caixaRepository = caixaRepository;
//	}
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		String token = recuperarToken(request);
//		boolean valido = tokenService.isTokenValido(token);
//		if (valido) {
//			autenticarCliente(token);
//		}
//		
//		
//		filterChain.doFilter(request, response);
//	}
//
//	private void autenticarCliente(String token) {
//		Long idCaixa = tokenService.getIdCaixa(token);
//		Caixa caixa = caixaRepository.getOne(idCaixa);
//		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(caixa, null, caixa.getAuthorities());
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//	}
//
//	private String recuperarToken(HttpServletRequest request) {
//		String token = request.getHeader("Authorization");
//		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
//			return null;
//		}
//		return token.substring(7, token.length());
//	}
//
//}
