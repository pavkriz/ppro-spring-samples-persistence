package cz.uhk.ppro.db.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cz.uhk.ppro.db.dao.StudentDao;
import cz.uhk.ppro.db.model.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class JpaStudentDao implements StudentDao {
	@PersistenceContext
    private EntityManager em;

	@Override
	public void add(final Student s) {
		em.persist(s);
	}

	@Override
	public List<Student> getAll() {
		return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
	}

	@Override
	public Student getById(int id) {
		return em.find(Student.class, id);
	}

	@Override
	public void remove(final Student s) {
		Student ps = em.merge(s);
		em.remove(ps);
	}

	@Override
	public void update(Student s) {
		add(s);
	}

}
