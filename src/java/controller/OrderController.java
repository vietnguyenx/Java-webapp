/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Cart;
import model.Category;
import model.Product;

/**
 *
 * @author imnvi
 */
@WebServlet(name = "OrderController", urlPatterns = {"/order"})
public class OrderController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        double price = Double.valueOf(request.getParameter("price"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("Cart");
        if (cart == null) {
                cart = new Cart();
            }
        Product p = new Product(id, name, image, price, title, description);
        cart.add(p);
        session.setAttribute("Cart", cart);
//        Cookie arr[] = request.getCookies();
//        List<Product> list = new ArrayList<>();
//        DAO dao = new DAO();
//        for(Cookie o : arr){
//            if(o.getName().equals("id")){
//                String txt[] = o.getValue().split(",");
//                for(String s : txt){
//                    list.add(dao.getProduct(s))
//                }
//            }
//        }
//        for(int i = 0; i < list.size(); i++){
//            int count = 1;
//            for( int j = i+1; j< list.size(); j++){
//                if(list.get(i).getId() == list.get(j).getId()){
//                    count++;
//                    list.remove(j);
//                    j--;
//                    list.get(i).setAmount(count);
//                }
//            }
//        }
//        for(Cookie o : arr){
//            o.setMaxAge(0);
//            response.addCookie(o);
//        }
//        response.sendRedirect("Home.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
