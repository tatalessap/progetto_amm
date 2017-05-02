package Modelli.servlet;

import Modelli.classi.Post;
import Modelli.classi.PostFactory;
import Modelli.classi.UtentiRegistrati;
import Modelli.classi.UtentiRegistratiFactory;
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(false);

//          l'attributo loggeIn è impostato a true se la sessione esiste
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
            //"creazione" dell'utente e ricevimento delle info tramite id
            UtentiRegistrati utente = UtentiRegistratiFactory.getInstance().getUtentiRegistratiById(userID);
            if (utente != null) {

                //inserimento dei dati
                if (request.getParameter("salva") != null) {

                    String nome = request.getParameter("nome");
                    request.setAttribute("nome", nome);

                    String cognome = request.getParameter("cognome");
                    request.setAttribute("cognome", cognome);

                    String immagine = request.getParameter("immagine");
                    request.setAttribute("immagine", immagine);

                    String date = request.getParameter("date");
                    request.setAttribute("date", date);

                    String password = request.getParameter("password");
                    request.setAttribute("password", password);

                    String fraseDescrizione = request.getParameter("fraseDescrizione");
                    request.setAttribute("fraseDescrizione", fraseDescrizione);

                } else {

                    request.setAttribute("utente", utente);

                }
                //lista utenti per la visualizzazione latosx
                List<UtentiRegistrati> Listautenti = UtentiRegistratiFactory.getInstance().getUtenti(utente);
                request.setAttribute("Listautenti", Listautenti);

                request.getRequestDispatcher("profilo.jsp").forward(request, response);
            } else {

                request.getRequestDispatcher("Login").forward(request, response);
            }

        }
        //altrimenti messaggio di errore
        request.getRequestDispatcher("MexError.jsp").forward(request, response);
        //request.getRequestDispatcher("Login").forward(request, response);

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
