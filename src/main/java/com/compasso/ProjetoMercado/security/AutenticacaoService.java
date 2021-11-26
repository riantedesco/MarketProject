//package com.compasso.ProjetoMercado.security;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.compasso.ProjetoMercado.entity.Caixa;
//import com.compasso.ProjetoMercado.repository.CaixaRepository;
//
//@Service
//public class AutenticacaoService implements UserDetailsService {
//	
//	@Autowired
//	private CaixaRepository caixaRepository;
//	
//	@Override
//	public UserDetails loadUserByUsername(String caixa) throws UsernameNotFoundException {
//		Optional<Caixa> cx = caixaRepository.findByDescricao(caixa);
//		if (cx.isPresent()) {
//			return cx.get();
//		}
//		
//		throw new UsernameNotFoundException("Dados inválidos!");	
//	}
//}
