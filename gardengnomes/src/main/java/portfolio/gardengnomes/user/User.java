package portfolio.gardengnomes.user;

import jakarta.persistence.*;
import java.util.UUID;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true)
    private String username;

    private String passwordHash;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean enabled = true;

    // getters/setters
    public String getPassword(){
        return this.passwordHash;
    }

    public void setPassword(String newPassword){
        this.passwordHash = newPassword;
    }

    public String getUserName(){
        return this.username;
    }

    public Role getRole(){
        return this.role;
    }

    public void setRole(Role newRole){
        this.role = newRole ;
    }
}