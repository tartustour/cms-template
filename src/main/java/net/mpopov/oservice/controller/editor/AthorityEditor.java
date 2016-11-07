package net.mpopov.oservice.controller.editor;

import java.beans.PropertyEditorSupport;

import net.mpopov.oservice.domain.Athority;
import net.mpopov.oservice.service.AthorityService;

public class AthorityEditor extends PropertyEditorSupport
{

    private final AthorityService athorityService;

    public AthorityEditor(AthorityService athorityService)
    {
        this.athorityService = athorityService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException
    {
        Athority athority = athorityService.load(Long.parseLong(text));
        setValue(athority);
    }
}