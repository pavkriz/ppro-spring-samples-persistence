package cz.uhk.ppro.db.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cz.uhk.ppro.db.dao.StudentDao;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import cz.uhk.ppro.db.model.Student;

public class JdbcStudentDao extends JdbcDaoSupport
		implements StudentDao {

	private SimpleJdbcInsert insert;

	@Override
	public void initDao() {
		assert getJdbcTemplate() != null;
		this.insert = new SimpleJdbcInsert(getJdbcTemplate())
				.withTableName("studenti")
				.usingGeneratedKeyColumns("id");
	}

	@Override
	public List<Student> getAll() {
		return getJdbcTemplate().query("select * from studenti", new StudentRowMapper());
	}

	@Override
	public Student getById(int id) {
		try {
			return getJdbcTemplate().queryForObject(
					"select * from studenti where id=?",
					new StudentRowMapper(),
					id
			);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void remove(Student s) {
		getJdbcTemplate().update(
				"delete from studenti where id=?",
				s.getCisloStudia()
		);
	}

	@Override
	public void update(Student s) {
		getJdbcTemplate().update(
				"update studenti set jmeno=?,prijmeni=? where id=?",
				s.getPrijmeni(),
				s.getJmeno(),
				s.getCisloStudia()
		);
	}

	@Override
	public void add(Student s) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("PRIJMENI", s.getPrijmeni());
		parameters.put("JMENO", s.getJmeno());
		Number id = insert.executeAndReturnKey(parameters);
		s.setCisloStudia(id.intValue());
	}

	class StudentRowMapper implements RowMapper<Student> {
		/**
		 * Mapujeme sloupce na atributy objektu
		 */
		@Override
		public Student mapRow(ResultSet res, int row)
				throws SQLException {
			Student s = new Student();
			s.setCisloStudia(res.getInt(1));
			s.setPrijmeni(res.getString(2));
			s.setJmeno(res.getString(3));
			return s;
		}
	}
}
