//package com.compasso.ProjetoMercado.entity;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//import org.springframework.security.core.GrantedAuthority;
//
//import lombok.Data;
//
//@Entity
//@Data
//public class Perfil implements GrantedAuthority {
//
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
//	private String descricao;
//
//	@Override
//	public String getAuthority() {
//		return descricao;
//	}
//
//}
