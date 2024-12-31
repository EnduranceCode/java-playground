package com.everis.academia.java.agenda.digital.web.bean;

import java.util.Collection;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.everis.academia.agenda.digital.business.BusinessException;
import com.everis.academia.agenda.digital.business.inter.ICidadeBusiness;
import com.everis.academia.agenda.digital.business.inter.IPrestadorServicoBusiness;
import com.everis.academia.agenda.digital.business.inter.ITelefoneBusiness;
import com.everis.academia.java.agenda.digital.entity.Cidade;
import com.everis.academia.java.agenda.digital.entity.PrestadorServico;
import com.everis.academia.java.agenda.digital.entity.Telefone;
import com.everis.academia.java.agenda.digital.enumerator.TipoLogradouro;

@ManagedBean(name = "prestadorServicoBean")
@Component
@RequestScoped
public class PrestadorServicoBean {

	/* Instanciamos um novo objecto PrestadorServicoBusiness */
	@Autowired
	private IPrestadorServicoBusiness prestadorServicoBusiness;

	/*
	 * Instanciamos um novo objecto CidadeBusiness para poder acerder à lista de
	 * Cidades existentes
	 */
	@Autowired
	private ICidadeBusiness cidadeBusiness;

	/*
	 * Instanciamos um novo objecto TelefoneBusiness para poder acerder à lista de
	 * Telefones existentes
	 */
	@Autowired
	private ITelefoneBusiness telefoneBusiness;

	/*
	 * Instanciamos um novo objecto PrestadorServico para receber os dados do
	 * Frontend
	 */
	private PrestadorServico prestadorServico = new PrestadorServico();

	/*
	 * Instanciamos um novo objecto Cidade para poder inserir uma nova Cidade a
	 * partir da página de criação de um novo Prestador de Serviços
	 */
	private Cidade cidadeAdicional = new Cidade();

	/*
	 * Instanciamos um novo objecto Telefone receber os telefones registados no
	 * FrontEnd
	 */
	public Telefone telefoneAdicional = new Telefone();

	public PrestadorServico getPrestadorServico() {

		return prestadorServico;
	}

	public void setPrestadorServico(PrestadorServico prestadorServico) {

		this.prestadorServico = prestadorServico;
	}

	/**
	 * Obtêm os Tipos de Logradouro disponívies
	 * 
	 * @return
	 */
	public TipoLogradouro[] getTiposLogradouro() {

		return TipoLogradouro.values();
	}

	public Cidade getCidadeAdicional() {
		return cidadeAdicional;
	}

	public void setCidadeAdicional(Cidade cidade) {
		this.cidadeAdicional = cidade;
	}

	/**
	 * Insere uma nova Cidade na lista de cidades existentes
	 * 
	 * @return
	 */
	public String submeterCidade() {

		try {

			cidadeAdicional = cidadeBusiness.create(cidadeAdicional);

			/* Re-instanciamos a variavel para limpar o formulário no Frontend */
			cidadeAdicional = new Cidade();

			return "create";
		} catch (BusinessException e) {

			String messageDetails = e.getLocalizedMessage();
			FacesContext.getCurrentInstance().addMessage("submeterCidade",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro!", messageDetails));
		}

		return null;
	}

	/**
	 * Obtêm a lista de Cidades existentes
	 * 
	 * @return
	 */
	public Collection<Cidade> getListaCidades() {

		return cidadeBusiness.read();
	}

	/**
	 * Obtêm o nome da cidade do actual Prestador de Serviço
	 * 
	 * @return
	 */
	public String getNomeCidade() {

		try {

			return cidadeBusiness.getNomeCidade(prestadorServico.getCidade().getCodigo());
		} catch (BusinessException e) {

			String messageDetails = e.getLocalizedMessage();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro!", messageDetails));
		}

		return null;
	}

	public Telefone getTelefoneAdicional() {
		return telefoneAdicional;
	}

	public void setTelefoneAdicional(Telefone telefoneAdicional) {
		this.telefoneAdicional = telefoneAdicional;
	}

	/**
	 * Adiciona um telefone ao Set de Telefones do Prestador de Serviços
	 * 
	 * @param telefoneAdicional
	 * @throws BusinessException
	 */
	public void adicionarTelefoneSet() {

		/* Verificamos se os dados recebidos são nulos */
		if (telefoneAdicional.getNumero() == null || telefoneAdicional.getNumero() == 0) {

			FacesContext.getCurrentInstance().addMessage("submissaoTelefone", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro!", "Este número de telefone já foi indicado"));
			
			return;
		}
		
		
		/*
		 * Verificamos se o número de telefone fornecido já foi adicionado antes no
		 * Frontend
		 */
		for (Telefone telefoneActual : prestadorServico.getTelefones()) {

			if (telefoneActual.getNumero() == telefoneAdicional.getNumero()) {

				FacesContext.getCurrentInstance().addMessage("submissaoTelefone", new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Ocorreu um erro!", "Este número de telefone já foi indicado"));

				return;
			}
		}

		/* Verificamos se o número de telefone fornecido já existe na Base de Dados */
		if (telefoneBusiness.jaExisteEsteTelefone(telefoneAdicional)) {

			FacesContext.getCurrentInstance().addMessage("submissaoTelefone", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro!", "Este número de telefone já foi anteriormente registado"));

			return;
		}

		/*
		 * Feitas as validações, adicionamos registamos o Prestado de Serviços no
		 * objecto Telefone
		 */
		telefoneAdicional.setPrestadorServico(prestadorServico);

		/* Adicionamos o objecto Telefone ao Set de Telefones do Prestador de Serviço */
		prestadorServico.getTelefones().add(telefoneAdicional);

		/* Re-instanciamos a variavel para limpar o formulário no Frontend */
		telefoneAdicional = new Telefone();
	}

	/**
	 * Carrega a página para criar um novo Prestador de Serviços
	 * 
	 * @param prestadorServico
	 * @return
	 */
	public String navegarCreatePrestadorServiço() {

		prestadorServico = new PrestadorServico();

		return "/app/prestador/create?faces-redirect=true";
	}

	/**
	 * Cancela a criação de um Novo Prestador de Serviços e retorna à listagem de
	 * Prestadores de Serviço
	 * 
	 * @return
	 */
	public String cancelarCreatePrestadorServico() {

		prestadorServico = new PrestadorServico();

		return "/app/index?faces-redirect=true";
	}

	/**
	 * Cria e insere um novo Prestador de Serviço
	 * 
	 * @param prestadorServico
	 * @return
	 */
	public String submterPrestadorServico() {

		try {

			prestadorServico = prestadorServicoBusiness.create(prestadorServico);

			return "read?faces-redirect=true";
		} catch (BusinessException e) {

			String messageDetails = e.getLocalizedMessage();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro!", messageDetails));
		}

		prestadorServico = new PrestadorServico();

		return null;
	}

	/**
	 * Lê e devolve a lista de Prestadores de Serviço registados
	 * 
	 * @return
	 */
	public List<PrestadorServico> getListaPrestadoresServico() {

		return prestadorServicoBusiness.read();
	}

	/**
	 * Carrega a página para visualizar o Prestador de Serviços escolhido no
	 * Frontend
	 * 
	 * @param prestadorServico
	 * @return
	 */
	public String navegarReadPrestadorServico(PrestadorServico prestadorServico) {

		this.prestadorServico = prestadorServico;

		return "/app/prestador/read?faces-redirect=true";
	}

	/**
	 * Carrega a página para actualizar o Prestador de Serviços escolhido no
	 * Frontend
	 * 
	 * @param prestadorServico
	 * @return
	 */
	public String navegarUpdatePrestadorServico(PrestadorServico prestadorServico) {

		this.prestadorServico = prestadorServico;

		return "update?faces-redirect=true";
	}

	/**
	 * Actualiza os dados do Prestador de Serviço
	 * 
	 * @return
	 */
	public String actualizarPrestadorServico(PrestadorServico prestadorServico) {

		try {

			prestadorServicoBusiness.update(prestadorServico);

			return "read?faces-redirect=true";
		} catch (BusinessException e) {

			String messageDetails = e.getLocalizedMessage();
			FacesContext.getCurrentInstance().addMessage("formPrestador:submeterCidade",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro!", messageDetails));
		}

		return null;
	}

	public String deletePrestadorServico(PrestadorServico prestadorServico) {

		try {

			prestadorServicoBusiness.delete(prestadorServico.getCodigo());

			return "/app/index?faces-redirect=true";
		} catch (BusinessException e) {

			String messageDetails = e.getLocalizedMessage();
			FacesContext.getCurrentInstance().addMessage("formPrestador:submeterCidade",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro!", messageDetails));
		}

		return null;
	}
}
