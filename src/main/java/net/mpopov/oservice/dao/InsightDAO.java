package net.mpopov.oservice.dao;

import java.util.List;

import net.mpopov.oservice.domain.Insight;

public interface InsightDAO
{
    public int count();

    public Insight load(Long insightId);

    public void add(Insight insight);

    public void save(Insight insight);

    public void remove(Long insightId);

    public boolean canRemove(Long insightId);

    public List<Insight> list();

    public Insight last();

    public List<Insight> list(int pageIndex, int pageCount, String sortColumn,
            String sortOrder);
}