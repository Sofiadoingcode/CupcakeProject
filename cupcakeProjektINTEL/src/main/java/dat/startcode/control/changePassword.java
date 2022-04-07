package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.UserMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "changePassword", value = "/changePassword")
public class changePassword extends HttpServlet {
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserMapper userMapper = new UserMapper(connectionPool);
        String currentPassword = request.getParameter("password");
        String newPassword = request.getParameter("newPassword");
        User user = (User) session.getAttribute("user");
        session.setAttribute("hasBeenThroughTheMatrix", false);
        if (session.getAttribute("typedCorrectPassword") == null || !((boolean) session.getAttribute("typedCorrectPassword"))) {
            if (currentPassword.equals(user.getPassword())) {
                session.setAttribute("typedCorrectPassword", true);
                session.setAttribute("hasBeenThroughTheMatrix", true);
            } else {
                session.setAttribute("typedCorrectPassword", false);
            }
        } else if ((boolean) session.getAttribute("typedCorrectPassword"))/* change to ) else { */ {
            try {
                System.out.println("1");
                userMapper.changePassword(newPassword, user.getUserId());
                session.setAttribute("hasBeenThroughTheMatrix", false);

            } catch (DatabaseException e) {
                e.printStackTrace();
            }
        }
        request.getRequestDispatcher("profilepage.jsp").forward(request, response);


        // Update password for user while in session


    }
}
