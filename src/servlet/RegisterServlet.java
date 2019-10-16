package servlet;

import dao.MemberDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String passwordConfirm = request.getParameter("password-confirm");
        String phoneNumber = request.getParameter("phone-number");
        String address = request.getParameter("address");
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");

        MemberDAO memberDAO = new MemberDAO();
        if (!password.equals(passwordConfirm)) {
            out.print("<font color=red>Password and confirm password must be the same!</font>");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }
        if (!memberDAO.isUnique(username)) {
            out.print("<font color=red>Username must be unique!</font>");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }
        if (memberDAO.registerSuccessfully(
                username,
                firstName,
                lastName,
                address,
                phoneNumber,
                email,
                password
        )) {
            out.print("<h1>Registered successfully!</h1>");
            out.print("<br>Welcome, " + firstName);
            out.print("<form action='profile' method='GET'>");
            out.print("<input type='hidden' name='hiddenUsername' value='" + username
                    + "' />");
            out.print("<input type='submit' value='View Profile' />");
            out.print("</form>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
