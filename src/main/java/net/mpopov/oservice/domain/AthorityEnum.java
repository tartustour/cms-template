package net.mpopov.oservice.domain;

public enum AthorityEnum
{
    ADMIN("ROLE_ADMIN", "label.administrator");

    private final String identifier;
    
    private final String name;

    private AthorityEnum(String identifier, String name)
    {
        this.identifier = identifier;
        this.name = name;
    }

    public String getIdentifier()
    {
        return identifier;
    }

    public String getName()
    {
        return name;
    }
}
