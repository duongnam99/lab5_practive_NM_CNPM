package servlet;

import dao.MemberDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        MemberDAO memberDAO = new MemberDAO();
        if (memberDAO.logInValidate(username, password)){
            out.print("<h1>You are successfully logged in!</h1>");
            out.print("<br>Welcome, " + memberDAO.getMemberByUsername(username).getFirstName());
            out.print("<form action='profile' method='GET'>");
            out.print("<input type='hidden' name='hiddenUsername' value='" + username
                    + "' />");
            out.print("<input type='submit' value='View Profile' />");
            out.print("</form>");
        } else {
            out.print("<font color=red>Sorry, username or password error!</font>");
            request.getRequestDispatcher("index.jsp").include(request,
                    response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
