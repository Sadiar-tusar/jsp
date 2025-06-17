
package sarvelet;

import dao.EmpDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Emp;


public class EmpServelet {
    
    
    @WebServlet("/empServelet")
    public class empServelet extends HttpServlet{

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            
            String action=req.getParameter("action");
            
            if("add".equals(action)){
            
                Emp emp=new Emp();
                
                emp.setName(req.getParameter("name"));
                emp.setSalary(Float.parseFloat(req.getParameter("salry")));
                
                EmpDao.saveEmp(emp);
                
                resp.sendRedirect("allemployee.jsp");
            }
            else if("update".equals(action)){
            
                Emp emp=new Emp();
                
                emp.setName(req.getParameter("name"));
                emp.setSalary(Float.parseFloat(req.getParameter("salary")));
                emp.setId(Integer.parseInt(req.getParameter("id")));
                
                EmpDao.updateEmp(emp);
                
                resp.sendRedirect("allemployee.jsp");
            
            }
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            
             String action = req.getParameter("action");

        if ("delete".equals(action)) {
            EmpDao.deleteEmp(Integer.parseInt(req.getParameter("id")));
            resp.sendRedirect("allemployee.jsp");
        } else if ("edit".equals(action)) {

            Emp e = EmpDao.getById(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("emp", e);
            req.getRequestDispatcher("editemp.jsp").forward(req, resp);
        }
        }

       
    
        
    
    }
}
