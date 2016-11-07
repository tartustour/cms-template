package net.mpopov.oservice.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "public.users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "users_users_id_seq")
    @SequenceGenerator(name = "users_users_id_seq",
            sequenceName = "users_users_id_seq")
    @Column(name = "users_id", nullable = false)
    private Long userId;

    @Column(name = "username")
    @Size(min = 1, max = 256)
    private String username;

    @Column(name = "password")
    @Size(min = 1, max = 256)
    private String password;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "athorities_id")
    @NotNull
    private Athority athority;

    @Column(name = "is_enabled")
    private boolean isEnabled;

    /**
     * @return the userId
     */
    public Long getUserId()
    {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    /**
     * @return the username
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * @param username
     *            the username to set
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * @return the athority
     */
    public Athority getAthority()
    {
        return athority;
    }

    /**
     * @param athority
     *            the athority to set
     */
    public void setAthority(Athority athority)
    {
        this.athority = athority;
    }

    /**
     * @return the isEnabled
     */
    public boolean getIsEnabled()
    {
        return isEnabled;
    }

    /**
     * @param isEnabled
     *            the isEnabled to set
     */
    public void setIsEnabled(boolean isEnabled)
    {
        this.isEnabled = isEnabled;
    }

}
