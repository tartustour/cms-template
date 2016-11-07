package net.mpopov.oservice.dao;

import java.util.List;

import net.mpopov.oservice.domain.Athority;

public interface AthorityDAO
{
    public int count();

    public Athority load(Long athorityId);

    public void add(Athority athority);

    public void save(Athority athority);

    public void remove(Long athorityId);

    public boolean canRemove(Long athorityId);

    public List<Athority> list();

    public List<Athority> list(int pageIndex, int pageCount, String sortColumn,
            String sortOrder);

	public Athority load(String role);
}