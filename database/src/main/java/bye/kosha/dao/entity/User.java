package bye.kosha.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
public class User extends IdBase<Long> {

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String pass;

    @ManyToOne
    private Role role;

    @OneToOne
    @JoinColumn(name = "subscriber_id")
    private Subscriber subscriber;

    public User(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }
}
