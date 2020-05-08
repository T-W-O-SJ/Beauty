package ru.sj.beauty.model;

import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.Set;
@Entity
@Table( name = "users",uniqueConstraints = @UniqueConstraint(name = "users_unique_email_idx", columnNames = "email"))

@NamedQueries(
        {
                @NamedQuery(name = User.DELETE ,query ="delete from User u where u.id =:id" ),
                @NamedQuery(name = User.GetByEmail , query = "select from User u Left Join Fetch u.roles  where u.email=?1"),
                @NamedQuery(name = User.GetSorted, query = "select from  User u Left Join Fetch u.roles where u.name,u.email")
        }
)
public class User extends AbstractNamedEntity {
    public static final String DELETE ="User.delete";
    public static final String GetByEmail= "User.getByEmail";
    public static final String GetSorted = "User.getSorted";
    @Column(name = "email", unique = true, nullable = false)
    @NotNull
@Email
    @Size(max=100)
    private String email;
   @Column(name = "password",unique = false,nullable = false)
@NotNull
   @Size(min =6 , max = 12)
    private String password;
@NotBlank
@Size( min = 11, max = 11)
@Column(name= "phone", nullable = false, unique = true)

    private  String phone;
@Column(name ="enabled",nullable = false,unique = false,columnDefinition = "bool default true")
@NotNull
    private boolean enabled = true;

@Column(name = "registered",nullable = false,unique = false,columnDefinition = "timestamp default ()now")
@NotNull
    private Date registered = new Date();
@Enumerated(EnumType.STRING)
@CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
@Column(name = "role")
@ElementCollection(fetch = FetchType.EAGER)
        private Set<Role> roles;

    public User() {
    }

    public User(User u) {
        this(u.getId(), u.getName(), u.getEmail(), u.getPassword(), u.phone, u.isEnabled(), u.getRegistered(), u.getRoles());
    }


    public User(Integer id, String name, String phone, String email, String password, Role role, Role... roles) {
        this(id, name, email, password, phone,true, new Date(), EnumSet.of(role, roles));
    }

    public User(Integer id, String name, String email,String password,String phone, boolean enabled, Date registered, Collection<Role> roles) {
        super(id, name);
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.enabled = enabled;
        this.registered = registered;
        setRoles(roles);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }



    public boolean isEnabled() {
        return enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = CollectionUtils.isEmpty(roles) ? EnumSet.noneOf(Role.class) : EnumSet.copyOf(roles);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email=" + email +
                ", name=" + name +
                ", enabled=" + enabled +
                ", roles=" + roles +
                ", cellphone=" + phone +
                '}';
    }
}