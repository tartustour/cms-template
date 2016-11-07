package net.mpopov.oservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "public.athorities")
public class Athority
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "athorities_athorities_id_seq")
    @SequenceGenerator(name = "athorities_athorities_id_seq",
            sequenceName = "athorities_athorities_id_seq")
    @Column(name = "athorities_id", nullable = false)
    private Long athorityId;

    @Column(name = "name")
    @Size(min = 1, max = 256)
    private String name;

    @Column(name = "athority_role")
    @Size(min = 1, max = 256)
    private String athorityRole;

    /**
     * @return the athorityId
     */
    public Long getAthorityId()
    {
        return athorityId;
    }

    /**
     * @param athorityId
     *            the athorityId to set
     */
    public void setAthorityId(Long athorityId)
    {
        this.athorityId = athorityId;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the athorityRole
     */
    public String getAthorityRole()
    {
        return athorityRole;
    }

    /**
     * @param athorityRole
     *            the athorityRole to set
     */
    public void setAthorityRole(String athorityRole)
    {
        this.athorityRole = athorityRole;
    }

	@Override
	public String toString() {
		return "Athority [athorityId=" + athorityId + ", name=" + name
				+ ", athorityRole=" + athorityRole + "]";
	}

}
