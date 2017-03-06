package org.hibernate.bugs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
	}

	@After
	public void destroy() {
		entityManagerFactory.close();
	}

	// Entities are auto-discovered, so just add them anywhere on class-path
	// Add your tests, using standard JUnit.
	@Test
	public void hhh11549Test() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Person p = new Person("123", UUID.randomUUID().toString(),new Date());

		entityManager.persist(p);
		entityManager.flush();

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PersonLookupDTO> query = builder.createQuery(PersonLookupDTO.class);
		Root<Person> root = query.from(Person.class);

		query.multiselect(root.get("name"),root.get("version"));
		List<PersonLookupDTO> data = entityManager.createQuery(query).getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
