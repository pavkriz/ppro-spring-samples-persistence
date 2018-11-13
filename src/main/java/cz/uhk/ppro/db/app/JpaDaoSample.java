package cz.uhk.ppro.db.app;

import java.util.List;

import cz.uhk.ppro.db.dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cz.uhk.ppro.db.model.Student;

public class JpaDaoSample {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-jpa.xml");
		StudentDao studentDao = (StudentDao) ctx.getBean("jpaStudentDao");

		List<Student> studenti = studentDao.getAll();

		for (Student s : studenti) {
			if (s.getJmeno().equals("Josef")) {
				studentDao.remove(s);
			}
			System.out.printf("%4d | %-30s | %-30s\n", s.getCisloStudia(),
						s.getPrijmeni(), s.getJmeno());
		}

		System.out.println("============================================================");

		Student ns = new Student("Hynek", "Josef");
		studentDao.add(ns);
		System.out.println("New student id=" + ns.getCisloStudia());

		System.out.println("============================================================");

		studenti = studentDao.getAll();

		for (Student s : studenti) {
			System.out.printf("%4d | %-30s | %-30s\n", s.getCisloStudia(),
					s.getPrijmeni(), s.getJmeno());
		}
		
	}

}
