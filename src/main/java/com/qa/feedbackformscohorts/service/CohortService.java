package com.qa.feedbackformscohorts.service;

import java.util.List;

import com.qa.feedbackformscohorts.persistence.domain.Cohort;

public interface CohortService {
	
    List<Cohort> getCohorts();
    
    Cohort addCohort(Cohort cohort);


}
