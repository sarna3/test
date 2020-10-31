package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "addServlet",urlPatterns = {"/addServlet/*"})
public class addServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        String[] urlSp = url.split("/");
        String regex = "^a=(-?[0-9]+)&b=(-?[0-9]+)$";
        Pattern p = Pattern.compile(regex);
        if (urlSp.length != 4) {
            PrintWriter writer = response.getWriter();
            writer.println("error!");
        } else {
            Matcher m = p.matcher(urlSp[3]);
            boolean flag = false;
            if (m.find()) {
                flag = true;
                Integer anum = Integer.parseInt(m.group(1));
                Integer bnum = Integer.parseInt(m.group(2));
                request.setAttribute("a", anum);
                request.setAttribute("b", bnum);
            }
            if (flag == true) {
                request.getRequestDispatcher("/doneServlet").forward(request, response);
            } else {
                PrintWriter writer = response.getWriter();
                writer.println("Parameter error!");
            }
        }
    }
}
