package by.kosha.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "subtopic", schema = "max_schema")
public class Subtopic extends IdBase<Long> {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "text", unique = true, nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;

    public Subtopic(String name, String text) {
        this.name = name;
        this.text = text;
    }
}
