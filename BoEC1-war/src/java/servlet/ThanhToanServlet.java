/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import dao.BillDaoImpl;
import dao.ChiTietHoaDonDaoImpl;
import entity.Clothes;
import entity.WebAccount;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.Bill;
import javax.ejb.EJB;
import model.Cart;
import model.ChiTietHoaDon;
import session.WebAccountFacadeLocal;

public class ThanhToanServlet extends HttpServlet {
    @EJB
    private WebAccountFacadeLocal webAccountFacade;

    private BillDaoImpl billDao = new BillDaoImpl();
    private ChiTietHoaDonDaoImpl cthdDao = new ChiTietHoaDonDaoImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String username = String.valueOf(session.getAttribute("user"));
        long cartID = (long) session.getAttribute("cartid");
        float total = (float) session.getAttribute("total");
        Cart cart = (Cart) session.getAttribute("cart");
        
        HashMap<Long, Clothes> list = cart.getList();
        for (Entry<Long, Clothes> entry : list.entrySet()) {
            Long key = entry.getKey();
            Clothes value = entry.getValue();
            
            ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(cartID, value.getId(), value.getQuantity());
            cthdDao.themChiTietHD(chiTietHoaDon);
        };
        
        
        try {
            WebAccount account = webAccountFacade.findByUsername(username);
            int accountID = account.getId();
            System.out.println("Account ID:" + accountID);
            System.out.println(accountID);
            String paymentMethod = "";
            String billStatus = "";
            Bill bill = new Bill(accountID, billStatus, cartID, total, paymentMethod);
            billDao.insertBill(bill);
            
            String url = "";
            url = "/page/message.jsp";
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
