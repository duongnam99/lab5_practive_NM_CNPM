package servlet;

import dao.MemberDAO;
import model.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProfileServlet", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("hiddenUsername");
        MemberDAO memberDAO = new MemberDAO();
        Member member = memberDAO.getMemberByUsername(username);
        out.print("<h1>PROFILE</h1>");
        out.print("<br> Username:       " + member.getUsername());
        out.print("<br> First name:     " + member.getFirstName());
        out.print("<br> Last name:      " + member.getLastName());
        out.print("<br> Address:        " + member.getAddress());
        out.print("<br> Email:          " + member.getEmail());
        out.print("<br> Phone number:   " + member.getPhoneNumber());
    }
}
