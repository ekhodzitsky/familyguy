package ru.free4all.familyguy.entities;

import org.springframework.security.core.GrantedAuthority;

public enum Translation implements GrantedAuthority {

    FILIZA, COLDFILM, JASKIER, OMSKBIRD, SUNSHINE, KOSHARA, BAIBAKO, RENTV;

    @Override
    public String getAuthority() {
        return name();
    }
}
