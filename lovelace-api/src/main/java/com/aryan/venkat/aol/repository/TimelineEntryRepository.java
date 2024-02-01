package com.aryan.venkat.aol.repository;

import com.aryan.venkat.aol.entity.TimelineEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimelineEntryRepository extends JpaRepository<TimelineEntry, Long> {
    List<TimelineEntry> findByUserId(Long userId);
    List<TimelineEntry> findByUserIdOrderByEventYear(long userId);

}
