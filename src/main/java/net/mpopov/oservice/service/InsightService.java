package net.mpopov.oservice.service;

import java.util.List;

import net.mpopov.oservice.domain.Insight;

public interface InsightService {
    public int count();

    public void add(Insight insight);

    public void save(Insight insight);

    public Insight load(Long insightId);

    public void remove(Long insightId);

    public boolean canRemove(Long insightId);

    public List<Insight> list();

    public Insight last();

    public List<Insight> list(int pageIndex, int pageCount, String sortColumn, String sortOrder);

}
