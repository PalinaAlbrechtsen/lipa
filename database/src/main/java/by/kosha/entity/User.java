package by.kosha.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@ToString
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table(name = "user", schema = "max_schema")
public class User extends IdBaseClass<Long> {

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String pass;

    @ManyToOne
    private Role role;

    @OneToOne
    private Subscriber subscriber;

    public User(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }
}
