package com.qa.feedbackforms.cohorts.service;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.feedbackformscohorts.persistence.domain.Cohort;
import com.qa.feedbackformscohorts.persistence.repository.CohortRepository;
import com.qa.feedbackformscohorts.service.CohortServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CohortsServiceTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@InjectMocks
	private CohortServiceImpl service;

	@Mock
	private CohortRepository repo;

	private static final Cohort MOCK_COHORT_1 = new Cohort("December 2018", "Mathew Hunt", 4, "Introduction to Java EE");

	@Test
	public void addCohortTest() {
		Mockito.when(repo.save(MOCK_COHORT_1)).thenReturn(MOCK_COHORT_1);
		assertEquals(MOCK_COHORT_1, service.addCohort(MOCK_COHORT_1));
		Mockito.verify(repo).save(MOCK_COHORT_1);
	}

}
