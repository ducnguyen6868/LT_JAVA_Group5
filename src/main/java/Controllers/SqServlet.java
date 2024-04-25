package Controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/homepage")
public class SqServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        // Chỉ định đường dẫn tới file HomePage.jsp
        String jspPath = "/HomePage.jsp";

        // Tạo một RequestDispatcher để chuyển hướng request tới file HomePage.jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher(jspPath);

        // Chuyển hướng request tới file HomePage.jsp
        dispatcher.forward(req, res);
    }
}
