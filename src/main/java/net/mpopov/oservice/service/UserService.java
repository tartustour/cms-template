package net.mpopov.oservice.service;

import java.util.Date;
import java.util.List;

import net.mpopov.oservice.domain.User;

public interface UserService
{
    public int count();

    public void add(User user);

    public void save(User user);

    public User load(Long userId);

    public void remove(Long userId);

    public void remove(Date dateTime, boolean isEnabled);

    public boolean canRemove(Long userId);

    public List<User> list();

    public List<User> list(int pageIndex, int pageCount, String sortColumn,
            String sortOrder);

	public User load(String userLogin);

	public User load(String email, boolean isEnabled);

    public User loadHashCode(String hashCode);

    public void setHashCode(String email, String hashCode);

	public List<User> list(String athority);

}
