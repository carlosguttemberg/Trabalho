/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import controller.LivroController;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
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
public class srvCadastroLote extends HttpServlet {

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
            String opcao1 = request.getParameter("op1");
            String opcao2 = request.getParameter("op2");
            DecimalFormat df = new DecimalFormat("#0.00");
           
            
            
            
            if(opcao1.equals("primeiro")){
            
                session.setAttribute("Lote", "sim");
                String tituloLote = request.getParameter("titulo");
                String volumeLote = request.getParameter("volume");
                int i =1;
                
                session.setAttribute("tituloLote", tituloLote);
                session.setAttribute("volumeLote", volumeLote);
                session.setAttribute("i", i);
                
                RequestDispatcher rd = request.getRequestDispatcher("srvCadastroNovo?tipo=listar");
                rd.forward(request, response);
                
                
            }else if(opcao1.equals("segundo")){
        
                
                    int volumeLote = Integer.parseInt(session.getAttribute("volumeLote").toString());
                    int i = Integer.parseInt(session.getAttribute("i").toString());


                        if(opcao2.equals("incluir")){
                            String titulo = session.getAttribute("tituloLote").toString();
                            String subtitulo = request.getParameter("subtitulo");
                            String idAutor = request.getParameter("selautores");
                            String idEditora = request.getParameter("seleditoras");
                            String idCategoria = request.getParameter("selcategorias");
                            String idGenero = request.getParameter("selgeneros");
                            String ano = request.getParameter("ano");
                            String paginas = request.getParameter("paginas");
                            String edicao = request.getParameter("edicao");
                            String volume = session.getAttribute("i").toString();
                            String idStatus = request.getParameter("selStatusLivro");
                            String idStatusLeitura = request.getParameter("selStatusLeitura");
                            String idUsuario = request.getParameter("idUsuario");

                            LivroController.salvar(titulo, subtitulo, ano, volume, paginas, edicao, "", idAutor, idEditora, idCategoria, idGenero, idStatus, idStatusLeitura, idUsuario);

                            String idLivro = String.valueOf(LivroController.retornaLivrosId(titulo,volume, edicao));

                            session.setAttribute("idLivro", idLivro);
                            session.setAttribute("titulo", titulo);
                            session.setAttribute("subtitulo", subtitulo);
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
                        

                    }else if(opcao2.equals("alterar")){
                
                            String caminhofoto = request.getParameter("imagem");

                             String id = session.getAttribute("idLivro").toString();
                             String titulo = session.getAttribute("titulo").toString();
                             String subtitulo = session.getAttribute("subtitulo").toString();
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

                             LivroController.editar(id, titulo, subtitulo, ano, volume, paginas, edicao, caminhofoto, idAutor, idEditora, idCategoria, idGenero, idStatus, idStatusLeitura);

                             //atualizando a page inicial

                            String aux = session.getAttribute("idUsuario").toString();

                            String listar = LivroController.listaLivroPorUsuario(aux);
                             //status da leitura
                            Float lendo = Float.parseFloat(LivroController.contaLivroPorUsuarioEFiltro(aux, "statusleitura", "1"));
                            Float lido = Float.parseFloat(LivroController.contaLivroPorUsuarioEFiltro(aux, "statusleitura", "2"));
                            Float queroler = Float.parseFloat(LivroController.contaLivroPorUsuarioEFiltro(aux, "statusleitura", "3"));
                            Float relendo = Float.parseFloat(LivroController.contaLivroPorUsuarioEFiltro(aux, "statusleitura", "4"));
                            Float desisti = Float.parseFloat(LivroController.contaLivroPorUsuarioEFiltro(aux, "statusleitura", "5"));
                
                            Float total = lendo + lido + queroler + relendo + desisti;
                
                
                
                
                            session.setAttribute("listar", listar);
                            session.setAttribute("lendo", df.format((lendo/total) * 100));
                            session.setAttribute("lido", df.format((lido/total) * 100));
                            session.setAttribute("queroler", df.format((queroler/total) * 100));
                            session.setAttribute("relendo", df.format((relendo/total) * 100));
                            session.setAttribute("desisti", df.format((desisti/total) * 100));
                
                            //status do aquisição 
                            Float tenho = Float.parseFloat(LivroController.contaLivroPorUsuarioEFiltro(aux, "status", "1"));
                            Float faltante = Float.parseFloat(LivroController.contaLivroPorUsuarioEFiltro(aux, "status", "2"));
                            Float sem = Float.parseFloat(LivroController.contaLivroPorUsuarioEFiltro(aux, "status", "3"));
                            Float totalaqu = tenho + faltante + sem;
                            Integer totallivro = Integer.parseInt(LivroController.contaLivroPorUsuarioEFiltro(aux, "status", "1")) + Integer.parseInt(LivroController.contaLivroPorUsuarioEFiltro(aux, "status", "2")) + Integer.parseInt(LivroController.contaLivroPorUsuarioEFiltro(aux, "status", "3"));
                            session.setAttribute("tenho", df.format((tenho/totalaqu) * 100));
                            session.setAttribute("faltante", df.format((faltante/totalaqu) * 100));
                            session.setAttribute("sem", df.format((sem/totalaqu) * 100));
                            session.setAttribute("total", totallivro);
                            
                            i++;

                            session.setAttribute("i", i);
                            
                            if(i<=volumeLote){
                            
                                RequestDispatcher rd = request.getRequestDispatcher("srvCadastroNovo?tipo=listar");
                                rd.forward(request, response);
                            }else{
                                session.setAttribute("Lote", "nao");
                                RequestDispatcher rd = request.getRequestDispatcher("Principal.jsp");
                                rd.forward(request, response);

                        }
                    }
                
                
            
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
