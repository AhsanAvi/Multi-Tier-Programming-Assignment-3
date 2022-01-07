/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Worker;
import model.WorkerDAO;

/**
 *
 * @author Ahsan
 */
public class MainServlet extends HttpServlet {

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
       
        String action = request.getServletPath();
        switch(action) {
            
            case "/logout": {
                request.getSession().invalidate();
                //invalidating session so user is logged out.
                getServletContext().getRequestDispatcher("/index.html").forward(request, response);
                break;
            }
            
            case "/add": {
                try {
                    String id = request.getParameter("id");
                    String name = request.getParameter("name");
                    double salary = Double.parseDouble(request.getParameter("salary"));
                    //getting required information from user

                    if (id == null || id.trim().isEmpty() || name == null || 
                            name.trim().isEmpty()) {
                        throw new Exception(">>> Input data error.");
                    }   
                    if (salary < 0 || salary > 100) {
                        //salary has to be between 0-100 inclusive, otherwise cannot continue.
                        throw new Exception(">>> Input data error.");
                    }
                    //if any required information is empty or invalid, throw exception
                    
                    Worker worker = new Worker(id, name, salary);
                    int result = WorkerDAO.addWorker(worker);
                    //if result is > 0, that means the query executed successfully
                    if (result > 0) {
                        request.setAttribute("message", ">>> New worker added to DB: ");
                        request.setAttribute("worker", new Worker(id, name, salary));
                    }
                    else {
                        request.setAttribute("message", ">>> New worker cannot be added ");
                    }
                } catch(Exception ex) {
                        request.setAttribute("message", ex.getMessage());
                }
                break;
            }
            
            case "/search": {
                try{
                    double minSal = Double.parseDouble(request.getParameter("minSal"));
                    double maxSal = Double.parseDouble(request.getParameter("maxSal"));
                    if (minSal < 0 || maxSal < minSal || maxSal > 100) {
                        throw new Exception(">>> Can't search DB, check input data.");
                    }  //verifying min and max is within allowed range 
                    
                    ArrayList<Worker> workers = WorkerDAO.searchWorkers(minSal, maxSal);
                    
                    if (!workers.isEmpty()) {
                        request.setAttribute("minSal", minSal);
                        request.setAttribute("maxSal", maxSal);
                        request.setAttribute("workers", workers);
                        request.setAttribute("workerCounter", workers.size());
                        request.setAttribute("averageSalary", WorkerDAO.getAverageSalary(workers));
                        request.setAttribute("topWorker", WorkerDAO.getTopWorker(workers));
                        request.setAttribute("resultMessage", ">>> Found following workers in DB.");
                        //if the searched workers arraylist is not empty then send these values to the JSP
                    }
                    else {
                        throw new Exception(">>> No workers found.");
                        //if searched workers arraylist is empty then throw exception.
                    }
                } catch (Exception ex) {
                    request.setAttribute("message", ex.getMessage());
                }
                break;
            }
            default:
        }
         getServletContext().getRequestDispatcher(action+".jsp").forward(request, response);
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
