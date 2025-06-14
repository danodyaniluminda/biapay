package com.biapay.core.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KeycloakGroup {
    private String id;
    private String name;
    private List<KeycloakRole> roles;
}
