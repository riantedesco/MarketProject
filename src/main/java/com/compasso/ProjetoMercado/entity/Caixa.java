package com.compasso.ProjetoMercado.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Caixa /*implements UserDetails*/ {

	//private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Boolean ativo;
	
	private String descricao;
	
	private String senha;
	
	@OneToOne
	private Funcionario funcionario;
	
//	@ManyToMany(fetch = FetchType.EAGER)
//	private List<Perfil> perfis = new ArrayList<>();
//	
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return this.perfis;
//	}
//
//	@Override
//	public String getUsername() {
//		return this.descricao;
//	}
//	
//	@Override
//	public String getPassword() {
//		return this.senha;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
}
