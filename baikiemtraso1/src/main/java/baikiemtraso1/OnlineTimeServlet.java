package baikiemtraso1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/online")
public class OnlineTimeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        long currentTime = System.currentTimeMillis();
        long creationTime = session.getCreationTime();
        long onlineTime = (currentTime - creationTime) / 1000; // Tính bằng giây

        session.setAttribute("onlineTime", onlineTime);
        request.getRequestDispatcher("/online.jsp").forward(request, response);
    }
}