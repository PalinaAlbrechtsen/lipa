package by.kosha.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "program", schema = "max_schema")
public class Program extends IdBase<Integer> {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "description", unique = true)
    private String description;

    @OneToMany(mappedBy = "program")
    private Set<Purchase> purchases = new HashSet<>();

    public Program(String name, String description, BigDecimal price) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
