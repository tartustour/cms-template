package net.mpopov.oservice.dao;

import java.util.List;

import net.mpopov.oservice.domain.Athority;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AthorityDAOImpl implements AthorityDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    public void add(Athority athority)
    {
        sessionFactory.getCurrentSession().save(athority);
    }

    @SuppressWarnings("unchecked")
    public List<Athority> list()
    {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "from Athority");
        List<Athority> list = query.list();
        return list;
    }

    @SuppressWarnings("unchecked")
    public List<Athority> list(int pageIndex, int pageCount, String sortColumn,
            String sortOrder)
    {
        String hql = String.format(
                "from Athority athority order by athority.%s %s", sortColumn,
                sortOrder);

        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        query.setFirstResult(pageIndex * pageCount - pageCount);
        query.setMaxResults(pageCount);

        List<Athority> list = query.list();

        return list;
    }

    public int count()
    {
        String hql = "select count(athority.athorityId) from Athority athority";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        int count = ((Number) query.uniqueResult()).intValue();

        return count;
    }

    public void remove(Long athorityId)
    {
        Athority athority = (Athority) sessionFactory.getCurrentSession().load(
                Athority.class, athorityId);
        if (athority != null)
        {
            sessionFactory.getCurrentSession().delete(athority);
        }
    }

    public boolean canRemove(Long athorityId)
    {
        String hql = "select user.userId from User user  "
                + " where user.athority.athorityId = :athorityId ";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setLong("athorityId", athorityId);
        query.setMaxResults(1);
        @SuppressWarnings("unchecked")
        List<Long> userIds = query.list();

        return userIds.isEmpty();
    }

    public Athority load(Long athorityId)
    {
        return (Athority) sessionFactory.getCurrentSession().get(
                Athority.class, athorityId);
    }

    @SuppressWarnings("unchecked")
    public Athority load(String athorityRole)
    {
        Athority athority = null;
        String queryString = "from Athority a where a.athorityRole = :athorityRole";

        Query query = sessionFactory.getCurrentSession().createQuery(
                queryString);

        query.setParameter("athorityRole", athorityRole);
        List<Athority> athorities = query.list();

        if (!athorities.isEmpty())
        {
            athority = athorities.get(0);
        }

        return athority;
    }

    public void save(Athority athority)
    {
        sessionFactory.getCurrentSession().merge(athority);
    }
}
