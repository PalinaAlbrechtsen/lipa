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
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "param", schema = "max_schema")
public class Param extends IdBase<Long> {

    @ManyToOne
    @JoinColumn(name = "subscriber_id")
    private Subscriber subscriber;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "height")
    private Integer height;

    @Column(name = "weight", nullable = false)
    private BigDecimal weight;

    public Param(BigDecimal weight) {
        this.weight = weight;
    }
}
