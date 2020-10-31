package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet",urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String psw = request.getParameter("psw");
        PrintWriter writer = response.getWriter();
        if ("admin".equals(name) && "123456".equals(psw))
        {
            writer.println("Success!");
            HttpSession session = request.getSession();
            session.setAttribute("login","You are right");
        }
        else
        {
            writer.println("Error login");
        }
    }
}
