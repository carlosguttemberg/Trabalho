/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import controller.LivroController;
import controller.UsuarioController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usuario
 */
public class srvCadastroLivro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String opcao = request.getParameter("opcao");
            
            if(opcao.equals("incluir")){        
                String titulo = request.getParameter("titulo");
                String idAutor = request.getParameter("selautores");
                String idEditora = request.getParameter("seleditoras");
                String idCategoria = request.getParameter("selcategorias");
                String idGenero = request.getParameter("selgeneros");
                String ano = request.getParameter("ano");
                String paginas = request.getParameter("paginas");
                String edicao = request.getParameter("edicao");
                String volume = request.getParameter("volume");
                String idStatus = request.getParameter("selStatusLivro");
                String idStatusLeitura = request.getParameter("selStatusLeitura");
                String idUsuario = request.getParameter("idUsuario");

                LivroController.salvar(titulo, ano, volume, paginas, edicao, "", idAutor, idEditora, idCategoria, idGenero, idStatus, idStatusLeitura, idUsuario);

                String idLivro = String.valueOf(LivroController.retornaId(titulo));

                HttpSession session = request.getSession();
                session.setAttribute("idLivro", idLivro);
                session.setAttribute("titulo", titulo);
                session.setAttribute("idAutor", idAutor);
                session.setAttribute("idEditora", idEditora);
                session.setAttribute("idCategoria", idCategoria);
                session.setAttribute("idGenero", idGenero);
                session.setAttribute("ano", ano);
                session.setAttribute("paginas", paginas);
                session.setAttribute("edicao", edicao);
                session.setAttribute("volume", volume);
                session.setAttribute("idStatus", idStatus);
                session.setAttribute("idStatusLeitura", idStatusLeitura);

                RequestDispatcher rd = request.getRequestDispatcher("capaLivro.jsp");
                rd.forward(request, response);
            }else if(opcao.equals("alterar")){
                
                String caminhofoto = request.getParameter("imagem");
                HttpSession session = request.getSession();
                
                 String id = session.getAttribute("idLivro").toString();
                 String titulo = session.getAttribute("titulo").toString();
                 String idAutor = session.getAttribute("idAutor").toString();
                 String idEditora = session.getAttribute("idEditora").toString();
                 String idCategoria = session.getAttribute("idCategoria").toString();
                 String idGenero = session.getAttribute("idGenero").toString();
                 String ano = session.getAttribute("ano").toString();
                 String paginas = session.getAttribute("paginas").toString();
                 String edicao = session.getAttribute("edicao").toString();
                 String volume = session.getAttribute("volume").toString();
                 String idStatus = session.getAttribute("idStatus").toString();
                 String idStatusLeitura = session.getAttribute("idStatusLeitura").toString();
                 
                 LivroController.editar(id, titulo, ano, volume, paginas, edicao, caminhofoto, idAutor, idEditora, idCategoria, idGenero, idStatus, idStatusLeitura);
                
                 RequestDispatcher rd = request.getRequestDispatcher("srvCadastroNovo?tipo=listar");
                 rd.forward(request, response);
                 
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
