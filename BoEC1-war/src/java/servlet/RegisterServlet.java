/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import entity.WebAccount;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.WebAccountFacadeLocal;

/**
 *
 * @author asus
 */
public class RegisterServlet extends HttpServlet {
    @EJB
    private WebAccountFacadeLocal webAccountFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String url = "";
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        try {
            System.out.println(username);
            if (username != null) {
                // Chuyen trang
                url = "./page/index.jsp";
                WebAccount account = new WebAccount.WebAccountBuilder()
                        .username(username).password(password).build();
                webAccountFacade.create(account);
                
                session.setAttribute("user", account.getUsername());
                RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                dispatcher.forward(request, response);
            } else {
                url = "./page/register.jsp";
                String errorMessage = "Register failed! Please register again!";

                request.setAttribute("errorRegister", errorMessage);
                RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                dispatcher.forward(request, response);
            }
        } catch (Exception ex) {
            System.out.println("RegisterServlet Failed!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
