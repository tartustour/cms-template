package net.mpopov.oservice.service;

import java.util.List;

import net.mpopov.oservice.dao.AthorityDAO;
import net.mpopov.oservice.domain.Athority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AthorityServiceImpl implements AthorityService
{

    @Autowired
    private AthorityDAO athorityDAO;

    @Transactional
    public int count()
    {
        return athorityDAO.count();
    }

    @Transactional
    public void add(Athority athority)
    {
        athorityDAO.add(athority);
    }

    @Transactional
    public List<Athority> list()
    {
        return athorityDAO.list();
    }

    @Transactional
    public void remove(Long athorityId)
    {
        athorityDAO.remove(athorityId);
    }

    @Transactional
    public boolean canRemove(Long athorityId)
    {
        return athorityDAO.canRemove(athorityId);
    }

    @Transactional
    public Athority load(Long athorityId)
    {
        return athorityDAO.load(athorityId);
    }

    @Transactional
    public Athority load(String role)
    {
        return athorityDAO.load(role);
    }

    @Transactional
    public void save(Athority athority)
    {
        athorityDAO.save(athority);
    }

    @Transactional
    public List<Athority> list(int pageIndex, int pageCount, String sortColumn,
            String sortOrder)
    {
        return athorityDAO.list(pageIndex, pageCount, sortColumn, sortOrder);
    }
}
