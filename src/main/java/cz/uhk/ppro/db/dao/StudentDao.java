package cz.uhk.ppro.db.dao;

import java.util.List;

import cz.uhk.ppro.db.model.Student;

/**
 * Rozhrani DAO studenta
 * @author Tomas Kozel, Pavel Kriz
 *
 */
public interface StudentDao {
	/**
	 * Nacteni pomoci id
	 * @param id
	 * @return vraci instanci Studenta nebo null, pokud Student s danym id neexistuje
	 */
	public Student getById(int id);
	/**
	 * Odstraneni studenta
	 * @param s
	 */
	public void remove(Student s);
	/**
	 * Ziskani vsech v evidenci
	 * @return
	 */
	public List<Student> getAll();
	/**
	 * Aktualizace dat studenta
	 * @param s
	 */
	public void update(Student s);
	
	/**
	 * Vlozeni noveho studenta
	 * @param s
	 */
	public void add(Student s);
}
