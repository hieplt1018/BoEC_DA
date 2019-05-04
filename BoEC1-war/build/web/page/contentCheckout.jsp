<%--
    Document   : contentCheckout
    Created on : Mar 30, 2019, 5:32:14 PM
    Author     : asus
--%>
<%@page import="dao.ClothesDaoImpl"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.TreeMap"%>
<%@page import="entity.Clothes"%>
<%@page import="model.Cart"%>
<%
    ClothesDaoImpl clothesDao = new ClothesDaoImpl();
    Clothes clothes = clothesDao.getClothesDetails(String.valueOf(request.getParameter("ID")));
    String str = session.getAttribute("total").toString();
    double m = Double.valueOf(str).doubleValue();

    NumberFormat nf = NumberFormat.getInstance();
    nf.setMinimumIntegerDigits(0);
    Cart cart = (Cart) session.getAttribute("cart");
    HashMap<Long, Clothes> list = cart.getList();
    HashMap<Long, Integer> quantity = cart.getQuantity();
    int so_luong = 0;
    float total = 0;
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Page info -->
<div class="page-top-info">
    <div class="container">
        <h4>Your Order</h4>
        <div class="site-pagination">
            <a href="">Home</a> /
            <a href="">Your order</a>
        </div>
    </div>
</div>
<!-- Page info end -->


<!-- checkout section  -->
<section class="checkout-section spad">
    <div class="container">
        <div class="row">
            
            <div class="col-lg-8 order-2 order-lg-1">
                <!--<form class="checkout-form" action="ThanhToanServlet" method="post"-->
                <h2 class="cf-title">Billing Address</h2>
                <hr>
                <form class="checkout-form" action="${pageContext.request.contextPath}/ThanhToanServlet" method="post">

                    <div class="row">
                        <div class="col-md-4">
                            <p>*Billing Information</p>
                        </div>
                        <div class="col-md-5">
                            <div class="cf-radio-btns address-rb">
                                <div class="cfr-item">
                                    <input type="radio" name="pm" id="one">
                                    <label for="one">Use my regular address</label>
                                </div>
                                <div class="cfr-item">
                                    <input type="radio" name="pm" id="two">
                                    <label for="two">Use a different address</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row address-inputs">
                        <div class="col-md-12">
                            <input type="text" id="one" placeholder="Address">
                            <input type="text" id="two" placeholder="Address line 2">
                            <input type="text" placeholder="Country">
                        </div>
                        <div class="col-md-6">
                            <input type="text" placeholder="Zip code">
                        </div>
                        <div class="col-md-6">
                            <input type="text" placeholder="Phone no.">
                        </div>
                    </div>
                
                    <hr>
                    <div class="cf-title">Delievery Info</div>
                    <div class="row shipping-btns">
                        <div class="col-6">
                            <h4>Standard</h4>
                        </div>
                        <div class="col-6">
                            <div class="cf-radio-btns">
                                <div class="cfr-item">
                                    <input type="radio" name="Addess_Shipping" id="ship-1">
                                    <label for="ship-1">Free</label>
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
                            <h4>Next day delievery  </h4>
                        </div>
                        <div class="col-6">
                            <div class="cf-radio-btns">
                                <div class="cfr-item">
                                    <input type="radio" name="shipping" id="ship-2">
                                    <label for="ship-2">$3.45</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <hr>
                    <div class="cf-title">Payment Info</div>
                    <div class="row shipping-btns">
                        <div class="col-6">
                            <h4>Pay In Cash</h4>
                        </div>
                        <div class="col-6">
                            <div class="cf-radio-btns">
                                <div class="cfr-item">
                                    <input type="radio" name="paycash" id="ship-1">
                                    <label for="paycard">Pay in cash</label>
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
                            <h4>Pay Credit Card  </h4>
                        </div>
                        <div class="col-6">
                            <div class="cf-radio-btns">
                                <div class="cfr-item">
                                    <input type="radio" name="paycredit" id="ship-2">
                                    <label for="paycard">Pay Credit Card</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <button class="site-btn submit-order-btn" type="submit">Place Order</button>
                </form>
            </div>
            <div class="col-lg-4 order-1 order-lg-2">
            <div class="checkout-cart">
                <h3>Your Cart</h3>
                <ul class="product-list">
                    <%
                        for (Map.Entry<Long, Clothes> ds : list.entrySet()) {
                            Long key = Long.parseLong(ds.getValue().getName(), 36);
                    %>
                    <li>
                        <div class="pl-thumb"><img src="<%=ds.getValue().getImage()%>" alt=""></div>
                        <h6><%=ds.getValue().getId()%></h6>
                        <p><%=ds.getValue().getPrice()%> $</p>
                        <p><%=nf.format(quantity.get(key) * ds.getValue().getPrice() * 24000)%> VND</p>
                    </li>
                    <%
                            so_luong += quantity.get(key);
                            total += quantity.get(key) * ds.getValue().getPrice();
                        }
                    %>
                </ul>
                <ul class="price-list">
                    <li>Total<span><%=m%> $ </span></li>
                    <li>Shipping<span>free</span></li>
                    <li class="total">Total<span><%=m%> $ (<%=nf.format(m * 24000)%> VND)</span></li>
                </ul>
            </div>

        </div>
    </div>
</section>
<!-- checkout section end -->
