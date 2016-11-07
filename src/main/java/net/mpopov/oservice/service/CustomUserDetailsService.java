package net.mpopov.oservice.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.mpopov.oservice.dao.UserDAO;
import net.mpopov.oservice.domain.Athority;
import net.mpopov.oservice.domain.AthorityEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService
{
    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException
    {
        net.mpopov.oservice.domain.User domainUser = userDAO.load(username);

        boolean enabled = domainUser.getIsEnabled();
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new User(domainUser.getUsername(), domainUser.getPassword(),
                enabled, accountNonExpired, credentialsNonExpired,
                accountNonLocked, getAuthorities(domainUser.getAthority()));
    }

    public Collection<GrantedAuthority> getAuthorities(Athority athority)
    {
        List<String> authorities = getAthorities();
        List<GrantedAuthority> grantedAuthorities = getGrantedAuthorities(
                authorities, athority);
        return grantedAuthorities;
    }

    public List<String> getAthorities()
    {
        List<String> authorities = new ArrayList<String>();
        for (AthorityEnum athorityEnum : AthorityEnum.values())
        {
            authorities.add(athorityEnum.getIdentifier());
        }

        return authorities;
    }

    public static List<GrantedAuthority> getGrantedAuthorities(
            List<String> authorities, Athority athority)
    {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        for (String authority : authorities)
        {
            if (authority.equals(athority.getAthorityRole()))
            {
                grantedAuthorities.add(new SimpleGrantedAuthority(authority));
            }
        }
        return grantedAuthorities;
    }

}
