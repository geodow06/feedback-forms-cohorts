package com.qa.feedbackformscohorts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.feedbackformscohorts.persistence.domain.Cohort;
import com.qa.feedbackformscohorts.persistence.repository.CohortRepository;

@Service
public class CohortServiceImpl implements CohortService{
	
	 @Autowired
	    private CohortRepository repo;

	@Override
	public Cohort addCohort(Cohort cohort) {
		return repo.save(cohort);
	}


}
