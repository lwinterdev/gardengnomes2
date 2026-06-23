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
}