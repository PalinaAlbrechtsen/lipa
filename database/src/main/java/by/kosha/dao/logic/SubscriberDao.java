package by.kosha.dao.logic;

import by.kosha.entity.Gender;
import by.kosha.entity.Subscriber;

import java.util.List;

public interface SubscriberDao extends GeneralDao<Long, Subscriber> {

    List<Subscriber> getByBirthDate();

    List<Subscriber> getByGender(Gender gender);

    Subscriber getByUserId(Long id);
}
