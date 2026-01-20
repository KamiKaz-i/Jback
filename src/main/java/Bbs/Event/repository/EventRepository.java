package Bbs.Event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Bbs.Event.entity.Event;
@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
    Event getEventById(long i);
}
