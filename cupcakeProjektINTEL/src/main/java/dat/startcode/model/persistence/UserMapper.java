package dat.startcode.model.persistence;

import dat.startcode.model.DTOs.OrderListDTO;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
        User user = null;

        String sql = "SELECT * FROM `user` WHERE username = ? AND password = ?";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    String role = rs.getString("role");
                    String email = rs.getString("email");
                    int balance = rs.getInt("balance");
                    user = new User(username, password, role, email, balance);
                } else
                {
                    throw new DatabaseException("Wrong username or password");
                }
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Error logging in. Something went wrong with the database");
        }
        return user;
    }

    @Override
    public User createUser(String username, String password, String role, String email, int balance) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
        User user;
        String sql = "insert into user (username, password, role, email, balance) values (?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, role);
                ps.setString(4, email);
                ps.setInt(5, balance);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1)
                {
                    user = new User(username, password, role, email, balance);
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

    @Override
    public List<User> getAllCustomers() throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        List<User> customerList = new ArrayList<>();

        String sql = "SELECT idUser, username, email, balance FROM `user` where role='customer'";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {

                    int userId = rs.getInt("idUser");
                    String username = rs.getString("username");
                    String email = rs.getString("email");
                    int balance = rs.getInt("balance");
                    User user = new User(userId,username,email,balance);
                    customerList.add(user);
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Fejl under indlæsning fra databasen");
        }
        return customerList;
    }

    @Override
    public boolean deleteUser(int userId) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        boolean isDeleted = false;
        String sql = "delete from `user` where idUser = ?";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1,userId);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    isDeleted = true;
                } else {
                    throw new DatabaseException("Elementet blev ikke fjernet");
                }
            } catch (SQLException e) {
                throw new DatabaseException("Elementet blev ikke fjernet");
            }
        } catch (SQLException e) {
            throw new DatabaseException("Elementet blev ikke fjernet");
        }
        return isDeleted;
    }


}
