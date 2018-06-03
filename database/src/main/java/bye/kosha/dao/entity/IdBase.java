package bye.kosha.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
public abstract class IdBase<PK extends Serializable> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private PK id;
}
