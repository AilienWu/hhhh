/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author 淡色Ailien
 */
public class order extends HttpServlet {

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
        String num1=request.getParameter("numsss");
        String num2=request.getParameter("numxxx");
        String num3=request.getParameter("numhhh");
        String carphone=Test.phone;
        
        String sql1="insert into car values('"+num1+"', '"+carphone+"', '741','"+(int)(100000*Math.random())+"')";
        String sql2="insert into car values('"+num2+"', '"+carphone+"', '852','"+(int)(100000*Math.random())+"')";
        String sql3="insert into car values('"+num3+"', '"+carphone+"', '963','"+(int)(100000*Math.random())+"')";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String jdbc="jdbc:mysql://127.0.0.1:3306/shopping?characterEncoding=GBk";
            Connection conn=DriverManager.getConnection(jdbc,"root","wqtaly1997");
            Statement state=conn.createStatement();
            state.executeUpdate(sql1);
            state.executeUpdate(sql2);
            state.executeUpdate(sql3);
            JOptionPane.showMessageDialog(null, "添加成功！"); 
            request.getRequestDispatcher("car.jsp").forward(request, response);
           
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
