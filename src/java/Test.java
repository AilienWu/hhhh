/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author 淡色Ailien
 */
public class Test extends HttpServlet {
    public static String phone;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String u=request.getParameter("userName");
        String p=request.getParameter("password");
        
        String sql="select * from user where phone='"+u+"' and password='"+p+"'";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String jdbc="jdbc:mysql://127.0.0.1:3306/shopping?characterEncoding=GBk";
            Connection conn=DriverManager.getConnection(jdbc,"root","wqtaly1997");
            PreparedStatement stmt=conn.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            
            if(rs.next()){
                request.setAttribute("us", u);
                request.setAttribute("pa", p);
                String cs=rs.getString(1);
                phone=u;
                request.setAttribute("na", cs);
                request.getRequestDispatcher("shop.jsp").forward(request, response);
            }else{
                JOptionPane.showMessageDialog(null, "it maybe wrong.");
            }
        } catch (ClassNotFoundException | SQLException ex) {
           JOptionPane.showMessageDialog(null,"666");
        }

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
