package net.mpopov.oservice.dao;

import java.util.Date;
import java.util.List;

import net.mpopov.oservice.domain.User;

public interface UserDAO
{
    public int count();

    public User load(Long userId);

    public User load(String username);

    public void add(User user);

    public void save(User user);

    public void remove(Long userId);

    public void remove(Date dateTime, boolean isEnabled);

    public boolean canRemove(Long userId);

    public boolean canAdd(User user);

    public List<User> list();

    public List<User> list(int pageIndex, int pageCount, String sortColumn,
            String sortOrder);

    public User loadHashCode(String hashCode);

    public void setHashCode(String email, String hashCode);

    public User load(String email, boolean isEnabled);

	public List<User> list(String athority);
    
}