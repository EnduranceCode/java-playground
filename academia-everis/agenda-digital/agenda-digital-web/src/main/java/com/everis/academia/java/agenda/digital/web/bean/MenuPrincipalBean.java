package com.everis.academia.java.agenda.digital.web.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.stereotype.Component;

@ManagedBean(name = "menuPrincipalBean")
@Component
@RequestScoped
public class MenuPrincipalBean {
	
	public String navegarEntrada() {
		
		return "/app/index?faces-redirect=true";
	}
	
	public String navegarPrestadoresServico() {
		
		return "/app/index?faces-redirect=true";
	}
	
	public String navegarTiposServico() {
		
		return "/app/tipo/create-read?faces-redirect=true";
	}
	
	public String navegarCidades() {
		
		return "/app/cidade/create-read?faces-redirect=true";
	}
}
