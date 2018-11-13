package cz.uhk.ppro.db.app;

import java.util.List;

import cz.uhk.ppro.db.dao.StudentDao;
import cz.uhk.ppro.db.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDaoSample {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-jdbc.xml");
		//StudentDao studentDao = (StudentDao) ctx.getBean("jdbcStudentDao2");
		StudentDao studentDao = (StudentDao) ctx.getBean("jdbcStudentDao");

		List<Student> studenti = studentDao.getAll();

		for (Student s : studenti) {
			if (s.getJmeno().equals("Josef") && s.getPrijmeni().equals("Hynek")) {
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
