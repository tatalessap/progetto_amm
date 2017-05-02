/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelli;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author marta_nga0hmy
 */
public class Profilo extends HttpServlet {

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

        HttpSession session = request.getSession(false);

        //se la sessione esiste ed esiste anche l'attributo loggedIn impostato a true
        if (session != null
                && session.getAttribute("loggedIn") != null
                && session.getAttribute("loggedIn").equals(true)) {

            String user = request.getParameter("user");

            int userID;

            if (user != null) {
                userID = Integer.parseInt(user);
            } else {
                Integer loggedUserID = (Integer) session.getAttribute("loggedUserID");
                userID = loggedUserID;
            }

            UtentiRegistrati utente = UtentiRegistratiFactory.getInstance().getUtentiRegistratiById(userID);
            if (utente != null) {

                if (request.getParameter("cambio") != null) {
                    this.SalvPar(session, request);

                } else {

                    request.setAttribute("utente", utente);

                }
                //List<UtentiRegistrati> DButenti = UtentiRegistratiFactory.getInstance().getDataBaseUtenti(utente);
                //request.setAttribute("DButenti", DButenti);

                request.getRequestDispatcher("profilo.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("Login").forward(request, response);
            }
            //request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }

    public void SalvPar(HttpSession session, HttpServletRequest request) {

        String nomeUtente = request.getParameter("nomeUtente");
        request.setAttribute("nomeUtente", nomeUtente);

        String cognomeUtente = request.getParameter("cognomeUtente");
        request.setAttribute("cognomeUtente", nomeUtente);

        String url = request.getParameter("url");
        request.setAttribute("url", url);

        String biografia = request.getParameter("biografia");
        request.setAttribute("biografia", biografia);

        String dataNascita = request.getParameter("dataNascita");
        request.setAttribute("dataNascita", dataNascita);

        String password = request.getParameter("password");
        request.setAttribute("password", password);
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
