<%@ page import="java.io.*" %> 
<%@ page import="java.util.*" %> 
<%@ page import="org.apache.commons.fileupload.*" %> 

<%
    
    String caminho = request.getParameter("arquivo");
    String nome = request.getParameter("nome");
    String senha = request.getParameter("senha");
    String login = request.getParameter("login");
    String email = request.getParameter("email");
    try {
        DiskFileUpload fu = new DiskFileUpload();

        List fileItems = fu.parseRequest(request);

        Iterator i = fileItems.iterator();

        FileItem fi = (FileItem) i.next();

        InputStream in = fi.getInputStream();

        File file = new File("c:/arquivoSaida" + "/teste.jpeg");

        FileOutputStream fos = new FileOutputStream(file);

        int c;
        while ((c = in.read()) != -1) {
            fos.write(c);
        }

        fos.close();
        out.println("arquivo salvo: c:/arquivoSaida");
    } catch (Exception e) {
        out.println(e.toString());
    }
%> 