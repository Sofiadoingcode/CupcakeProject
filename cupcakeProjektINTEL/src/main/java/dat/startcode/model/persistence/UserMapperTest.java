package dat.startcode.model.persistence;

import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest
{
    private static String USER = "cphbusiness";

    private static String PASSWORD = "code";

    private final static String URL = "jdbc:mysql://localhost:3306/cupcakeDatabase?serverTimezone=CET&allowPublicKeyRetrieval=true&useSSL=false";

    private static ConnectionPool connectionPool;
    private static UserMapper userMapper;

    @BeforeAll
    public static void setUpClass() {
            connectionPool = new ConnectionPool(USER, PASSWORD, URL);
            userMapper = new UserMapper(connectionPool);
    }

    @BeforeEach
    void setUp()
    {
        try (Connection testConnection = connectionPool.getConnection()) {
            try (Statement stmt = testConnection.createStatement() ) {
                // Remove all rows from all tables
                stmt.execute("delete from user");
                // Indsæt et par brugere
                stmt.execute("insert into user (username, password, role, email) " +
                        "values ('user','1234','user','a'),('admin','1234','admin','a'), ('ben','1234','user','a')");
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            Assertions.fail("Database connection failed");
        }
    }

    @Test
    void testConnection() throws SQLException
    {
        Connection connection = connectionPool.getConnection();
        Assertions.assertNotNull(connection);
        if (connection != null)
        {
            connection.close();
        }
    }

    @Test
    void login() throws DatabaseException
    {
        User expectedUser = new User("user","1234","user");
        User actualUser = userMapper.login("user","1234");
        Assertions.assertEquals(expectedUser, actualUser);
    }

    @Test
    void invalidPasswordLogin() throws DatabaseException
    {
        Assertions.assertThrows(DatabaseException.class, () -> userMapper.login("user","123"));
    }

    @Test
    void invalidUserNameLogin() throws DatabaseException
    {
        Assertions.assertThrows(DatabaseException.class, () -> userMapper.login("bob","1234"));
    }

    @Test
    void    createUser() throws DatabaseException
    {
        User newUser = userMapper.createUser("jill", "1234", "user", "j@jmail.com", 0);
        User logInUser = userMapper.login("jill","1234");
        User expectedUser = new User("jill", "1234", "user");
        Assertions.assertEquals(expectedUser, newUser);
        Assertions.assertEquals(expectedUser, logInUser);

    }
    }
