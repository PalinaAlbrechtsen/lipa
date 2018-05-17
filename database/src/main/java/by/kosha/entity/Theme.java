package by.kosha.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "theme", schema = "max_schema")
public class Theme extends IdBase<Integer> {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "theme")
    private Set<Subtopic> subtopics = new HashSet<>();

    public Theme(String name) {
        this.name = name;
    }
}
