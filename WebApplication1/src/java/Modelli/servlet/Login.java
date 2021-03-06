package Modelli.servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Modelli.classi.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author marta_nga0hmy
 */
@WebServlet(loadOnStartup = 0)
public class Login extends HttpServlet {
    
    private static final String JDBC_DRIVER = "org.apache.derby.jdb.EmbreddedDriver";
    private static final String DB_CLEAN_PATH ="../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH ="WEB-INF/db/ammdb";
    
    @Override
   public void init(){
       String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
       try {
           Class.forName(JDBC_DRIVER);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
       }
       GruppiFactory.getInstance().setConnectionString(dbConnection);
       PostFactory.getInstance().setConnectionString(dbConnection);
       UtentiRegistratiFactory.getInstance().setConnectionString(dbConnection);
   }

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
                    //la sessione è iniziata 
                    session.setAttribute("loggedIn", true);
                    session.setAttribute("loggedUserID", loggedUserID);
                    //se ha campi incompleti viene rimandato in profilo
                    if (UtentiRegistratiFactory.getInstance().controlloprofilo(loggedUserID) == false) {
                        request.getRequestDispatcher("profilo.jsp").forward(request, response);
                    } else {
                        //altrimenti in bacheca
                        request.getRequestDispatcher("Bacheca").forward(request, response);
                        return;
                    }

                } else { //nel caso in cui la coppia user name e password non sia valida, torno di nuovo nel login

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

}
