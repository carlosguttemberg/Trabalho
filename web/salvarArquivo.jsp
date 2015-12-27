<%@ page import="java.io.*" %> 
<%@ page import="java.util.*" %> 
<%@ page import="org.apache.commons.fileupload.*" %> 

<%
    try {
        
        String caminho = request.getParameter("arquivo");
        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        
        
        DiskFileUpload fu = new DiskFileUpload();

        List fileItems = fu.parseRequest(request);

        Iterator i = fileItems.iterator();

        FileItem fi = (FileItem) i.next();

        InputStream in = fi.getInputStream();

        File file = new File("C:/Users/Carlos/Documents/NetBeansProjects/TrabalhoP1/imagem" + caminho);

        FileOutputStream fos = new FileOutputStream(file);

        int c;
        while ((c = in.read()) != -1) {
            fos.write(c);
        }

        fos.close();
        out.println("arquivo salvo: C:/Users/Carlos/Documents/NetBeansProjects/TrabalhoP1/imagem");
        //RequestDispatcher rd = request.getRequestDispatcher("srvLogin?cmd=incluir&caminho=" + caminho + "&nome=" + nome + "&senha=" + senha + "&login=" + login + "&email=" + email);
        //rd.forward(request, response);
    } catch (Exception e) {
        out.println(e.toString());
    }
%> 