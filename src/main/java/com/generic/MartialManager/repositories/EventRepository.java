package com.generic.MartialManager.repositories;

import com.generic.MartialManager.models.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventModel, Long> {
}
