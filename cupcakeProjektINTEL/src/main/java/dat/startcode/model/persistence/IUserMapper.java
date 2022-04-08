package dat.startcode.model.persistence;

import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.util.List;

public interface IUserMapper
{
    public User login(String email, String kodeord) throws DatabaseException;
    public User createUser(String username, String password, String role, String email, int balance) throws DatabaseException;
    public List<User> getAllCustomers() throws DatabaseException;
    public boolean deleteUser(int userId) throws DatabaseException;
}
