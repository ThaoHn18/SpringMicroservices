package thaohn.accountservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
public class AccountDTO {

    private Long id;

    private String password;

    private String username;

    private Set<String> roles;
}
