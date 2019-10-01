/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 798125
 */
public class HomeServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
     HttpSession session = request.getSession();

    // Parameters
    String username = (String) session.getAttribute("username");

    if (username == null) {
      response.sendRedirect("/login");//direct sending to the login servlet and it give syou the get method
      return;
    }

    getServletContext().getRequestDispatcher("/WEB-INF/home.jsp")
            .forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    return;
  }
    
    }

  
    

   
