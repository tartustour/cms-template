package net.mpopov.oservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.mpopov.oservice.dao.InsightDAO;
import net.mpopov.oservice.domain.Insight;

@Service
public class InsightServiceImpl implements InsightService {

    @Autowired
    private InsightDAO insightDAO;

    @Transactional(readOnly = true)
    public int count() {
        return insightDAO.count();
    }

    @Transactional
    public void add(Insight insight) {
        insightDAO.add(insight);
    }

    @Transactional(readOnly = true)
    public List<Insight> list() {
        return insightDAO.list();
    }

    @Transactional(readOnly = true)
    public Insight last() {
        return insightDAO.last();
    }

    @Transactional
    public void remove(Long insightId) {
        insightDAO.remove(insightId);
    }

    @Transactional
    public boolean canRemove(Long insightId) {
        return insightDAO.canRemove(insightId);
    }

    @Transactional
    public Insight load(Long insightId) {
        return insightDAO.load(insightId);
    }

    @Transactional
    public void save(Insight insight) {
        insightDAO.save(insight);
    }

    @Transactional(readOnly = true)
    public List<Insight> list(int pageIndex, int pageCount, String sortColumn, String sortOrder) {
        return insightDAO.list(pageIndex, pageCount, sortColumn, sortOrder);
    }
}
