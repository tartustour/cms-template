package net.mpopov.oservice.service;

import java.util.Date;
import java.util.List;

import net.mpopov.oservice.dao.UserDAO;
import net.mpopov.oservice.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public int count()
    {
        return userDAO.count();
    }

    @Transactional
    public void add(User user)
    {
        userDAO.add(user);
    }

    @Transactional
    public List<User> list()
    {
        return userDAO.list();
    }

    @Transactional
	public List<User> list(String athority)
    {
        return userDAO.list(athority);
    }

    @Transactional
    public void remove(Long userId)
    {
        userDAO.remove(userId);
    }

    @Transactional
    public void remove(Date dateTime, boolean isEnabled)
    {
        userDAO.remove(dateTime, isEnabled);
    }

    @Transactional
    public boolean canRemove(Long userId)
    {
        return userDAO.canRemove(userId);
    }

    @Transactional
    public User loadHashCode(String hashCode)
    {
        return userDAO.loadHashCode(hashCode);
    }

    @Transactional
    public void setHashCode(String email, String hashCode)
    {
        userDAO.setHashCode(email, hashCode);
    }

    @Transactional
    public User load(String email, boolean isEnabled)
    {
        return userDAO.load(email, isEnabled);
    }

    @Transactional
    public User load(Long userId)
    {
        return userDAO.load(userId);
    }

    @Transactional
    public User load(String userLogin)
    {
        return userDAO.load(userLogin);
    }

    @Transactional
    public void save(User user)
    {
        userDAO.save(user);
    }

    @Transactional
    public List<User> list(int pageIndex, int pageCount, String sortColumn,
            String sortOrder)
    {
        return userDAO.list(pageIndex, pageCount, sortColumn, sortOrder);
    }
}
