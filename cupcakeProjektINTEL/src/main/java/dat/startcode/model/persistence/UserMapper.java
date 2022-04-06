package dat.startcode.model.persistence;

import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserMapper implements IUserMapper
{
    ConnectionPool connectionPool;

    public UserMapper(ConnectionPool connectionPool)
    {
        this.connectionPool = connectionPool;
    }

    @Override
    public User login(String username, String password) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
        System.out.println("a");
        User user = null;

        String sql = "SELECT * FROM `user` WHERE username = ? AND password = ?";
        System.out.println("b");
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                System.out.println("c");
                ps.setString(1, username);
                System.out.println("1a");
                ps.setString(2, password);
                System.out.println("1b");
                ResultSet rs = ps.executeQuery();
                System.out.println("1c");
                if (rs.next())
                {

                    System.out.println("1d");
                    String role = rs.getString("role");
                    System.out.println("d");
                    user = new User(username, password, role);
                    System.out.println("e");

                } else
                {
                    throw new DatabaseException("Wrong username or password");
                }
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Error logging in. Something went wrong with the database");
        }
        System.out.println("f");
        return user;
    }

    @Override
    public User createUser(String username, String password, String role, String email) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
        User user;
        String sql = "insert into user (username, password, role,email) values (?,?,?,?)";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, role);
                ps.setString(4,email);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1)
                {
                    user = new User(username, password, role);
                } else
                {
                    throw new DatabaseException("The user with username = " + username + " could not be inserted into the database");
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Could not insert username into database");
        }
        return user;
    }


}
