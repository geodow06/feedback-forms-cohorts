package com.qa.feedbackformscohorts.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.feedbackformscohorts.persistence.domain.Cohort;
import com.qa.feedbackformscohorts.persistence.domain.SentCohort;
import com.qa.feedbackformscohorts.service.CohortService;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class CohortRest {
	
    @Autowired
    private CohortService service;
	
    @Autowired
    private JmsTemplate jmsTemplate;
    
    
    @PostMapping("${path.createCohort}")
    public Cohort createAccount(@RequestBody Cohort Cohort) {
    	SentCohort cohortToSend = new SentCohort(Cohort);
        sendToQueue(cohortToSend);
    	return service.addCohort(Cohort);
    }
    
    @GetMapping("${path.getCohortbyId}")
    public Optional<Cohort> getCohort (@PathVariable Long id) {
    	return service.getCohort(id);
    	
    }
    
    @GetMapping("${path.getCohorts}")
    public List<Cohort> getCohorts () {
    	return service.getCohorts();
    }
    	
    
    

    
    private void sendToQueue(SentCohort cohortToSend){
        jmsTemplate.convertAndSend("CohortQueue", cohortToSend);
    }
    
    
	
	

}
