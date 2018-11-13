package cz.uhk.ppro.db.dao.hibernate;

import java.util.List;

import cz.uhk.ppro.db.dao.StudentDao;

import cz.uhk.ppro.db.model.Student;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class HibStudentDao implements StudentDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(Student s) {
		sessionFactory.getCurrentSession()
				.saveOrUpdate(s);
	}

	@Override
	public List<Student> getAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from Student", Student.class)
				.list();
	}

	@Override
	public Student getById(int id) {
		return sessionFactory.getCurrentSession()
				.get(Student.class, id);
	}

	@Override
	public void remove(Student s) {
		sessionFactory.getCurrentSession()
				.delete(s);
	}

	@Override
	public void update(Student s) {
		add(s);
	}

}
