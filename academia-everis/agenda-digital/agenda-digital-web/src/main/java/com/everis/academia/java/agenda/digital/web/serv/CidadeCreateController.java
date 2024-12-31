package com.everis.academia.java.agenda.digital.web.serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.agenda.digital.business.impl.CidadeBusiness;
import com.everis.academia.agenda.digital.business.inter.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.entity.Cidade;
import com.everis.academia.java.agenda.digital.web.html.HeadHtml;

@WebServlet(name = "nova-cidade", urlPatterns = "/nova-cidade")
public class CidadeCreateController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/* Instanciamos um novo objecto CidadeBusiness */
	private ICidadeBusiness cidadeBusiness = new CidadeBusiness();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Obtemos o nome da cidade inserido no formulário */
		String nomeCidade = request.getParameter("cidade");
		
		/* Criamos um objecto cidade com o nome de cidade recebido */
		Cidade cidadeNova = new Cidade();
		cidadeNova.setNome(nomeCidade);
		
		try {
			
			/* Executamos o método create() e actualizamos a variável com os dados retornados pelo método */
			cidadeNova = cidadeBusiness.create(cidadeNova);
			
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println(new HeadHtml("Inserida nova cidade - Agenda Digital").getHead());
			out.println("<body>");
			out.println("<div class=\"container-fluid\">");
			
			out.println("<div clas=\"row-fluid\">");
			out.println("<div clas=\"span12\">");
			out.println("<h1>Academia Java</h1>");
			out.println("<h2>Agenda Digital</h2>");
			out.println("<h3>Cidade Inserida</h3>");
			
			out.println("<table class=\"table\">");
			out.println("<thead>");
			out.println("<tr><th>Codigo</th><th>Cidade</th><th></th></tr>");
			out.println("</thead>");
			out.println("<tbody>");
			out.println("<tr>"
							+ "<td>" + cidadeNova.getCodigo() + "</td>"
							+ "<td>" + cidadeNova.getNome() + "</td>"
							+ "<td>"
							+ "<a href=\"" + request.getContextPath() + "/jsp/cidade/update.jsp?codigo=" + cidadeNova.getCodigo() + "&cidade=" + cidadeNova.getNome() + "\""
									+ "class=\"btn btn-small btn-success\""
									+ "style=\"margin-right: 10px\">Editar</a>"
							+ "<a href=\"" + request.getContextPath() + "/delete?codigo=" + cidadeNova.getCodigo() + "\""
									+ "class=\"btn btn-small btn-danger\">Eliminar</a>"
						+ "</td>"
						+ "</tr>");
			out.println("</tbody>");
			out.println("</table>");
			
			
			
			out.println("<p>"
							+ "<a href=\"" + request.getContextPath() + "/jsp/cidade/create.jsp\""
								+ "class=\"btn\" style=\"margin-right: 10px;\">Inserir nova cidade"
								+ "</a>"
							+ "<a href=\"" + request.getContextPath() + "/jsp/cidade/read.jsp\""
								+ "class=\"btn btn-primary\">Ver todas as cidades"
							+ "</a>"
						+ "</p>");
			
			out.println("</div>");
			out.println("</div>");
			
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			
			throw new ServletException(e);
		}
	}
}
