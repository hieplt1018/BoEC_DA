/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.WebAccountFacadeLocal;

/**
 *
 * @author asus
 */
public class LoginServlet extends HttpServlet {
    @EJB
    private WebAccountFacadeLocal webAccountFacade;
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String rememberMe = request.getParameter("remember");
            if (webAccountFacade.checkLogin(username, password)) {
                HttpSession session = request.getSession();
                request.setAttribute("username", username);
                session.setAttribute("user", username);
                if (request.getParameter("remember") != null) {
                    String remember = request.getParameter("remember").trim();
                    System.out.println("remember : " + remember);
                    Cookie cUserName = new Cookie("cookuser", username);
                    Cookie cPassword = new Cookie("cookpass", password);
                    Cookie cRemember = new Cookie("cookrem", remember);
                    cUserName.setMaxAge(60 * 60 * 24 * 15);     //15 days
                    cPassword.setMaxAge(60 * 60 * 24 * 15);
                    cRemember.setMaxAge(60 * 60 * 24 * 15);
                    response.addCookie(cUserName);
                    response.addCookie(cPassword);
                    response.addCookie(cRemember);
                } 
                request.getRequestDispatcher("./page/index.jsp").forward(request, response);
            }else{
                String errorMessage = "Wrong username or password!";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("./page/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
