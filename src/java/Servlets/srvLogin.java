package Servlets;

import controller.LivroController;
import controller.UsuarioController;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Carlos
 */
@WebServlet(name = "srvLogin", urlPatterns = {"/srvLogin"})
public class srvLogin extends HttpServlet {

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
            String cmd = request.getParameter("cmd");
            String login = request.getParameter("txtlogin");
            
            DecimalFormat df = new DecimalFormat("#0.00");
            
            if(cmd.equals("incluir")){
                String resp ="";
                String caminho = "usuario.png"; 
                String nome = request.getParameter("nome");
                String senha = request.getParameter("senha");
                login = request.getParameter("login");
                String email = request.getParameter("email");
                resp = UsuarioController.salvar(nome, login, senha, caminho, email);
                
                if (resp.equals("")){
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                    
                }else{
                    String aux = "Login Existente";
                    RequestDispatcher rd = request.getRequestDispatcher("cadastro.jsp?resposta=" + aux);
                    rd.forward(request, response);
                }
                
            }else if(cmd.equals("autentica")){
                login = request.getParameter("txtlogin");
                String senha = request.getParameter("txtsenha");
                String status = "";
                if (UsuarioController.validaUsuario(login, senha) == true) {
                    HttpSession session = request.getSession();
                    session.setAttribute("idUsuario", UsuarioController.retornaId(login));
                    session.setAttribute("login", login);
                    session.setAttribute("senha", senha);
                    
                    String aux = session.getAttribute("idUsuario").toString();
                    session.setAttribute("email", UsuarioController.retornaCampo(aux, "email"));
                    session.setAttribute("nome", UsuarioController.retornaCampo(aux, "nome"));
                    
                    
                    RequestDispatcher rd = request.getRequestDispatcher("srvLogin?cmd=inicial");
                    rd.forward(request, response);
                } else {
                    status = "Login ou senha incorretos";
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp?status=" + status);
                    rd.forward(request, response);
                }
            }else if(cmd.equals("inicial")){
                String foto = "";
               
                String aux = Integer.toString(UsuarioController.retornaId(login));
                foto = UsuarioController.retornaCampo(aux, "caminhofoto");
                String listar = LivroController.listaLivroPorUsuario(aux);
                
                
                //status da leitura
                Float lendo = 0.0f;
                Float lido = 0.0f;
                Float queroler = 0.0f;
                Float relendo = 0.0f;
                Float desisti = 0.0f;
                
                HttpSession session = request.getSession();
                
                lendo = Float.parseFloat(LivroController.contaLivroPorUsuarioEFiltro(aux, "statusleitura", "1"));
                lido = Float.parseFloat(LivroController.contaLivroPorUsuarioEFiltro(aux, "statusleitura", "2"));
                queroler = Float.parseFloat(LivroController.contaLivroPorUsuarioEFiltro(aux, "statusleitura", "3"));
                relendo = Float.parseFloat(LivroController.contaLivroPorUsuarioEFiltro(aux, "statusleitura", "4"));
                desisti = Float.parseFloat(LivroController.contaLivroPorUsuarioEFiltro(aux, "statusleitura", "5"));
                
                Float total = lendo + lido + queroler + relendo + desisti;
                
                if (lendo != 0){
                    lendo = (lendo/total) * 100;
                    session.setAttribute("lendo", df.format(lendo));
                }else{
                    session.setAttribute("tenho",lendo);
                }
                
                
                session.setAttribute("imagem", foto);
                session.setAttribute("listar", listar);
                session.setAttribute("lendo", df.format((lendo/total) * 100));
                session.setAttribute("lido", df.format((lido/total) * 100));
                session.setAttribute("queroler", df.format((queroler/total) * 100));
                session.setAttribute("relendo", df.format((relendo/total) * 100));
                session.setAttribute("desisti", df.format((desisti/total) * 100));
                
                //status do aquisição 
                Float tenho = 0.0f;
                Float faltante = 0.0f;
                Float sem = 0.0f;
                tenho = Float.parseFloat(LivroController.contaLivroPorUsuarioEFiltro(aux, "status", "1"));
                faltante = Float.parseFloat(LivroController.contaLivroPorUsuarioEFiltro(aux, "status", "2"));
                sem = Float.parseFloat(LivroController.contaLivroPorUsuarioEFiltro(aux, "status", "3"));
                Float totalaqu = tenho + faltante + sem;
                Integer totallivro = Integer.parseInt(LivroController.contaLivroPorUsuarioEFiltro(aux, "status", "1")) + Integer.parseInt(LivroController.contaLivroPorUsuarioEFiltro(aux, "status", "2")) + Integer.parseInt(LivroController.contaLivroPorUsuarioEFiltro(aux, "status", "3"));
                
                if (tenho != 0){
                    tenho = (tenho/totalaqu) * 100;
                    session.setAttribute("tenho", df.format(tenho));
                }else{
                    session.setAttribute("tenho",tenho);
                }
                
                if (faltante != 0){
                    faltante = (faltante/totalaqu) * 100;
                    session.setAttribute("faltante", df.format(tenho));
                }else{
                    session.setAttribute("faltante",tenho);
                }
                
                
                if (sem != 0){
                    sem = (sem/totalaqu) * 100;
                    session.setAttribute("sem", df.format(sem));
                }else{
                    session.setAttribute("sem",sem);
                }
               
                   
                
                
                
                
                
                session.setAttribute("total", totallivro);
                
                
                
                //String lendo = LivroController.listaLivroPorUsuarioFiltrado(aux, "statusleitura", "2");
                
                RequestDispatcher rd = request.getRequestDispatcher("Principal.jsp?foto=" + foto);
                rd.forward(request, response);
                
            }else if(cmd.equals("altera")){
                String imagem = request.getParameter("imagem");
                HttpSession session = request.getSession();
                String logon = session.getAttribute("login").toString();
                session.setAttribute("imagem", imagem);
                String email = session.getAttribute("email").toString();
                String nome = session.getAttribute("nome").toString();
                String senha = session.getAttribute("senha").toString();
                String id = session.getAttribute("idUsuario").toString();
                
                UsuarioController.editar(id, nome, logon, senha, imagem, email);
               
                
                RequestDispatcher rd = request.getRequestDispatcher("Principal.jsp?");
                rd.forward(request, response);
            }else if (cmd.equals("modifica")){
                String nome = request.getParameter("nome");
                String senha = request.getParameter("senha");
                String email = request.getParameter("email");
                HttpSession session = request.getSession();
                String logon = session.getAttribute("login").toString();
                String id = session.getAttribute("idUsuario").toString();
                String foto = UsuarioController.retornaCampo(id, "caminhofoto");
                UsuarioController.editar(id, nome, logon, senha, foto, email);
                session.setAttribute("nome", nome);
                RequestDispatcher rd = request.getRequestDispatcher("Principal.jsp?foto=" + foto);
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