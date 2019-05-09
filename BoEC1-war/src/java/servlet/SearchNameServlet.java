/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import entity.Clothes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import search.CareTaker;
import search.ItemFacade;
import search.Originator;
import search.State;

/**
 *
 * @author asus
 */
public class SearchNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        String searchProduct = request.getParameter("searchProduct");
        
        try{
            Originator originator = new Originator();
            CareTaker careTaker = new CareTaker();
            State<String, List<Clothes>> state1 = new State<>(searchProduct, ItemFacade.getInstance().searchByName(searchProduct));

            originator.setState(state1);
            careTaker.add(originator.saveStateToMemento());

            originator.getStateFromMemento(careTaker.get(0));
            session.setAttribute("nameSearch", originator.getState().getB());
            request.getRequestDispatcher("./page/search.jsp").forward(request, response);
        }
        catch(Exception e) {
            System.err.println(e);
        }
    }
}
