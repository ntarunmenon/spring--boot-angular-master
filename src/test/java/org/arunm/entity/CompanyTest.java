package org.arunm.entity;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.arunm.ProgrammingAssignmentApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@SpringApplicationConfiguration(classes = ProgrammingAssignmentApplication.class)
public class CompanyTest {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void company_Association_Test() {
		Company company = new Company();
		company.setCity("City1");
		company.setAddress("LandMark1, Location1");
		company.setCountry("India");
		company.setEmail("test@test.com");
		company.setName("name1");
		company.setPhoneNumber("123");

		Owner owner = new Owner();

		owner.setName("1234");

		company.addOwner(owner);

		entityManager.persist(company);
		entityManager.flush();

		List<?> count = entityManager.createQuery(
				"select owner from Owner owner", Owner.class).getResultList();

		assertThat(count.size(), equalTo(1));
	}
}
