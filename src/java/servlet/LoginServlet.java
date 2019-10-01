/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Model.AccountServices;
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
public class LoginServlet extends HttpServlet {


    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
         HttpSession session = request.getSession();
   
    String username = (String) session.getAttribute("username");

    String action = request.getParameter("action");
   
    
    if(action==null)
    {
    action="";
    }else{
    action=action;
    }

    switch (action) {
      case "logout":
        session.setAttribute("username", null);
        request.setAttribute("success", "Logout Success");
      
        break;
      default:
        if (username != null) {
          response.sendRedirect("home");
          return;
        }
    }

    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
            .forward(request, response);
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         HttpSession session = request.getSession();
     request.setAttribute("success", null);
    
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        
        //checking that creditentials are null or not
         if (username == null || username.equals("")
            || password == null || password.equals("")) {
      request.setAttribute("e", "Please Enter all the Fileds ");
      getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
              .forward(request, response);
      return;
    }
        AccountServices a=new AccountServices();
        
        //calling the login method 
      if (a.login(username, password) == null) {
      request.setAttribute("e", "Invalid Login");
      getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
              .forward(request, response);
      return;
    }
      
      session.setAttribute("username", username);

    getServletContext().getRequestDispatcher("/WEB-INF/home.jsp")
            .forward(request, response);
        
    }

  
  

}
