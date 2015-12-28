/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import controller.AutorController;
import controller.CategoriaController;
import controller.EditoraController;
import controller.GeneroController;
import controller.LivroController;
import controller.StatusController;
import controller.StatusLeituraController;
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
public class srvEdicaoLivro extends HttpServlet {

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
            
            HttpSession session = request.getSession();
            String opcao = request.getParameter("opcao");
            
            if(opcao.equals("listar")){
            
                String listarLivros = LivroController.retornaSelect();
                RequestDispatcher rd = request.getRequestDispatcher("selecionarLivro.jsp?listarLivros="+listarLivros);
                rd.forward(request, response);
                
            }else if(opcao.equals("selecionar")){
            
                String idLivro = request.getParameter("selLivros");
                String capaLivro = LivroController.retornaCampo(idLivro, "caminhofoto");
                
               
                //session.setAttribute("idLivroEditar", idLivro);
                //session.setAttribute("capaLivro", capaLivro);
                
                
                String titulo = LivroController.retornaCampo(idLivro, "titulo");
                String listarAutor = AutorController.retornaSelect();
                String listarEditora = EditoraController.retornaSelect();
                String listarCategoria = CategoriaController.retornaSelect();
                String listarGenero = GeneroController.retornaSelect();
                String ano = LivroController.retornaCampo(idLivro, "ano");
                String paginas = LivroController.retornaCampo(idLivro, "paginas");
                String edicao = LivroController.retornaCampo(idLivro, "edicao");
                String volume = LivroController.retornaCampo(idLivro, "edicao");
                String listarStatus = StatusController.retornaSelect();
                String listarStatusLeitura = StatusLeituraController.retornaSelect();
                
                RequestDispatcher rd = request.getRequestDispatcher("editarLivro.jsp?titulo="+titulo+"&listarAutor="+listarAutor+
                        "&listarEditora="+listarEditora+"&listarCategoria="+listarCategoria+"&listarGenero="+listarGenero+"&ano="+ano+
                        "&paginas="+paginas+"&edicao="+edicao+"&volume="+volume+"&listarStatus="+listarStatus+"&listarStatusLeitura="+listarStatusLeitura+
                        "&idLivro="+idLivro+"&capaLivro="+capaLivro);
                rd.forward(request, response);                
                
            }else if(opcao.equals("atualizar")){
            
                //String id = session.getAttribute("idLivroEditar").toString();
                //String caminhofoto = session.getAttribute("capaLivro").toString();
                String id = request.getParameter("idLivro");
                String caminhofoto = request.getParameter("capaLivro");
                
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
                
                //editar(String id, String titulo, String ano, String volume, String paginas, String edicao, String caminhofoto, String idAutor, String idEditora, String idCategoria, String idGenero, String idStatus, String idStatusLeitura){
                LivroController.editar(id, titulo, ano, volume, paginas, edicao, caminhofoto, idAutor, idEditora, idCategoria, idGenero, idStatus, idStatusLeitura);
                
                RequestDispatcher rd = request.getRequestDispatcher("Principal.jsp");
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
