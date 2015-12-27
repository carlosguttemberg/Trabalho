<%@ page import="java.io.*" %> 
<%@ page import="java.util.*" %> 
<%@ page import="org.apache.commons.fileupload.*" %> 

<%
    try {
        String login = session.getAttribute("login").toString();    
        DiskFileUpload fu = new DiskFileUpload();

        List fileItems = fu.parseRequest(request);

        Iterator i = fileItems.iterator();

        FileItem fi = (FileItem) i.next();

        InputStream in = fi.getInputStream();
        
        String imagem = login + ".jpeg";

        File file = new File("C:/Users/Carlos/Documents/NetBeansProjects/TrabalhoP1/build/web/" + login + ".jpeg");
        
        FileOutputStream fos = new FileOutputStream(file);

        int c;
        while ((c = in.read()) != -1) {
            fos.write(c);
        }

        fos.close();
        //out.println("arquivo salvo: C:/Users/Carlos/Documents/NetBeansProjects/TrabalhoP1/imagem/");
        RequestDispatcher rd = request.getRequestDispatcher("srvLogin?cmd=altera&imagem=" + imagem);
        rd.forward(request, response);
    } catch (Exception e) {
        out.println(e.toString());
    }
%> 