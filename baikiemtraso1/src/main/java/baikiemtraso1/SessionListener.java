package baikiemtraso1;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer activeSessions = (Integer) context.getAttribute("activeSessions");
        if (activeSessions == null) {
            activeSessions = 0;
        }
        activeSessions++;
        context.setAttribute("activeSessions", activeSessions);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer activeSessions = (Integer) context.getAttribute("activeSessions");
        if (activeSessions != null && activeSessions > 0) {
            activeSessions--;
            context.setAttribute("activeSessions", activeSessions);
        }
    }
}
