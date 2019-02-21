package com.qa.feedbackformscohorts.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.feedbackformscohorts.persistence.domain.Cohort;

@Repository
public interface CohortRepository extends JpaRepository<Cohort, Long> {
}