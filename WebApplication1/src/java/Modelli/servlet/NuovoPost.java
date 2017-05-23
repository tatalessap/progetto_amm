/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelli.servlet;

import Modelli.classi.UtentiRegistrati;
import Modelli.classi.UtentiRegistratiFactory;
import Modelli.classi.Post;
import Modelli.classi.Post;
import Modelli.classi.PostFactory;
import Modelli.classi.PostFactory;
import Modelli.classi.UtentiRegistratiFactory;
import Modelli.servlet.*;
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
public class NuovoPost extends HttpServlet {

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
            /*Due possibilità:
            *   -devo ancora scrivere un messaggio (nessun post in request)
            *   -ho gia scritto il messaggio e devo confermare (esiste un post in request)
             */
            if (request.getParameter("thereIsPost") != null) {
                /*Altre due possibilità
                *   -aspetto conferma da jsp
                *   -devo salvare su DB
                 */
                String thereIsPost = request.getParameter("thereIsPost");
                String content = request.getParameter("content");
                String postType = request.getParameter("postType");
                
                Integer loggedUserID = (Integer) session.getAttribute("loggedUserID");
                int userID = loggedUserID;
                
                UtentiRegistrati utentetmp= UtentiRegistratiFactory.getInstance().getUtentiRegistratiById(userID);
                
                if (thereIsPost.equals("needConfirm")) {
                    request.setAttribute("nome", utentetmp.getNomeUtente());
                    request.setAttribute("cognome", utentetmp.getCognomeUtente());
                    request.setAttribute("content", content);
                    request.setAttribute("postType", postType);
                    request.setAttribute("newpost", "true");
                    request.getRequestDispatcher("Bacheca").forward(request, response);
                    return;
                } else {
                    //salvo
                    Post post = new Post();
                    post.setContent(content);
                    if (postType.equals("textType")) {
                        post.setPostType(Post.PostType.POST_TESTO);
                    } else {
                        post.setPostType(Post.PostType.POST_IMMAGINE);
                    }

                    post.setUtente(UtentiRegistratiFactory.getInstance().getUtentiRegistratiById((Integer) session.getAttribute("loggedUserID")));

                    PostFactory.getInstance().addNewPost(post);
                    request.getRequestDispatcher("Bacheca").forward(request, response);
                }
            } else {
                request.getRequestDispatcher("Bacheca").forward(request, response);
                return;
            }
        } else {
            request.getRequestDispatcher("Login").forward(request, response);
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
