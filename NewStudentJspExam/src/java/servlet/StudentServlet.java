
package servlet;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Student;

@WebServlet("/studentServelet")
public class StudentServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
         String action = req.getParameter("action");

        if ("add".equals(action)) {

            Student student = new Student();

            student.setName(req.getParameter("name"));
            student.setEmail(req.getParameter("email"));
            student.setSalary(Float.parseFloat(req.getParameter("salary")));

            StudentDao.saveStudent(student);

            resp.sendRedirect("allstudent.jsp");
        } else if ("update".equals(action)) {

            Student student = new Student();

            student.setName(req.getParameter("name"));
            student.setEmail(req.getParameter("email"));
            student.setSalary(Float.parseFloat(req.getParameter("salary")));
            student.setId(Integer.parseInt(req.getParameter("id")));

            StudentDao.updateStudent(student);

            resp.sendRedirect("allstudent.jsp");

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
         String action = req.getParameter("action");

        if ("delete".equals(action)) {
            StudentDao.deleteStudent(Integer.parseInt(req.getParameter("id")));
            resp.sendRedirect("allstudent.jsp");
        } else if ("edit".equals(action)) {

            Student s = StudentDao.getById(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("student", s);
            req.getRequestDispatcher("editstudent.jsp").forward(req, resp);
        }
    }
    
    
}
