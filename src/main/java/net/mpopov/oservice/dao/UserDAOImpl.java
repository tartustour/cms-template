package net.mpopov.oservice.dao;

import java.util.Date;
import java.util.List;

import net.mpopov.oservice.domain.User;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    public void add(User user)
    {
        sessionFactory.getCurrentSession().save(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> list()
    {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "from User");
        List<User> list = query.list();
        return list;
    }

	@SuppressWarnings("unchecked")
	public List<User> list(String athority)
	{
        String hql = "from User user where user.athority.athorityRole = :athority  order by user.username";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        query.setString("athority",athority);

        List<User> list = query.list();

        return list;
		
	}


    @SuppressWarnings("unchecked")
    public List<User> list(int pageIndex, int pageCount, String sortColumn,
            String sortOrder)
    {
        String hql = String.format("from User user order by user.%s %s",
                sortColumn, sortOrder);

        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        query.setFirstResult(pageIndex * pageCount - pageCount);
        query.setMaxResults(pageCount);

        List<User> list = query.list();

        return list;
    }

    public int count()
    {
        String hql = "select count(user.userId) from User user";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        int count = ((Number) query.uniqueResult()).intValue();

        return count;
    }

    public void remove(Long userId)
    {
        User user = (User) sessionFactory.getCurrentSession().load(User.class,
                userId);
        if (user != null)
        {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    public void remove(Date dateTime, boolean isEnabled)
    {
        String hql = "delete from User where registrationDateTime <= :dateTime "
                + " and isEnabled = :isEnabled ";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setTimestamp("dateTime", dateTime);
        query.setBoolean("isEnabled", isEnabled);

        query.executeUpdate();
    }


    public boolean canRemove(Long userId)
    {
        return true;
    }

    public boolean canAdd(User user)
    {
        return true;
    }

    public User load(Long userId)
    {
        String queryString = "from User u where u.userId = :userId";
        Query query = sessionFactory.getCurrentSession().createQuery(
                queryString);
        query.setParameter("userId", userId);
        User user = (User) query.uniqueResult();

        return user;
    }

    @SuppressWarnings("unchecked")
    public User loadHashCode(String hashCode)
    {
        User user = null;
        String queryString = "from User u where u.hashCode = :hashCode";

        Query query = sessionFactory.getCurrentSession().createQuery(
                queryString);

        query.setParameter("hashCode", hashCode);
        List<User> users = query.list();

        if (!users.isEmpty())
        {
            user = users.get(0);
        }

        return user;
    }
   

    public void setHashCode(String email, String hashCode)
    {
        String queryString = "update User u SET u.hashCode = :hashCode where u.email = :email";

        Query query = sessionFactory.getCurrentSession().createQuery(
                queryString);

        query.setParameter("hashCode", hashCode);
        query.setParameter("email", email);
        query.executeUpdate();
    }

    public User load(String email, boolean isEnabled)
    {
        String hql = "from User u where u.email = :email "
                + " and u.isEnabled = :isEnabled ";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("email", email);
        query.setBoolean("isEnabled", isEnabled);

        User user = (User) query.uniqueResult();
        
        return user;
    }

    public User load(String username)
    {
        String queryString = "from User u where u.username = :username";
        Query query = sessionFactory.getCurrentSession().createQuery(
                queryString);
        query.setParameter("username", username);
        User user = (User) query.uniqueResult();

        return user;
    }

    public void save(User user)
    {
        sessionFactory.getCurrentSession().merge(user);
    }
}
