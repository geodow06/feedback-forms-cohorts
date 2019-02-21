package com.qa.feedbackformscohorts.service;

import java.util.List;
import java.util.Optional;

import com.qa.feedbackformscohorts.persistence.domain.Cohort;

public interface CohortService {
	
    List<Cohort> getCohorts();
    
    Optional<Cohort> getCohort(Long id);
    
    Cohort addCohort(Cohort cohort);
    


}
