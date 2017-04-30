/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelli;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author marta_nga0hmy
 */
public class Login extends HttpServlet {

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

        HttpSession session = request.getSession();

        if (request.getParameter("logout") != null) {
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        if (session.getAttribute("loggedIn") != null
                && session.getAttribute("loggedIn").equals(true)) {

            request.getRequestDispatcher("Bacheca").forward(request, response);
            return;

        } else {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (username != null && password != null) {
                int loggedUserID = UtentiRegistratiFactory.getInstance().getIdByUserAndPassword(username, password);

                //se l'utente è valido...
                if (loggedUserID != -1) {
                    session.setAttribute("loggedIn", true);
                    session.setAttribute("loggedUserID", loggedUserID);

                    if (UtentiRegistratiFactory.getInstance().controlloprofilo(loggedUserID) == false) {
                        request.getRequestDispatcher("profilo.jsp").forward(request, response);
                    } else {

                        request.getRequestDispatcher("Bacheca").forward(request, response);
                        return;
                    }

                } else { //altrimenti se la coppia user/pass non è valida (id==-1)

                    //ritorno al form del login informandolo che i dati non sono validi
                    request.setAttribute("invalidData", true);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    return;
                }

            }
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
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

    private boolean controlloprofilo(UtentiRegistrati utentiRegistratiById) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
