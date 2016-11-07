package net.mpopov.oservice.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.mpopov.oservice.common.ConfigUtil;
import net.mpopov.oservice.domain.Insight;

@Repository
public class InsightDAOImpl implements InsightDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ConfigUtil configUtil;

    public void add(Insight insight)
    {
        sessionFactory.getCurrentSession().save(insight);
    }

    @SuppressWarnings("unchecked")
    public List<Insight> list()
    {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "from Insight order by code desc");
        List<Insight> list = query.list();
        return list;
    }

    public Insight last() {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Insight order by billPeriodBegin desc");
        Insight insight = (Insight) query.uniqueResult();
        return insight;
    }

    @SuppressWarnings("unchecked")
    public List<Insight> list(int pageIndex, int pageCount, String sortColumn,
            String sortOrder)
    {
        String hql = String.format(
                "from Insight insight order by insight.%s %s", sortColumn,
                sortOrder);

        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        query.setFirstResult(pageIndex * pageCount - pageCount);
        query.setMaxResults(configUtil.getRecordsPerAdminPage());

        List<Insight> list = query.list();

        return list;
    }

    public int count()
    {
        String hql = "select count(insight.insightId) from Insight insight";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        int count = ((Number) query.uniqueResult()).intValue();

        return count;
    }

    public void remove(Long insightId)
    {
        Insight insight = (Insight) sessionFactory.getCurrentSession().load(
                Insight.class, insightId);
        if (insight != null)
        {
            sessionFactory.getCurrentSession().delete(insight);
        }
    }

    public boolean canRemove(Long insightId)
    {
        return true;
    }

    public Insight load(Long insightId)
    {
        return (Insight) sessionFactory.getCurrentSession().get(
                Insight.class, insightId);
    }

    public void save(Insight insight)
    {
        sessionFactory.getCurrentSession().merge(insight);
    }
}
