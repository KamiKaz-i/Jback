package bbs.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import bbs.event.entity.Event;
@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
}
