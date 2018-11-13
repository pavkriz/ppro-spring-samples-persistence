package cz.uhk.ppro.db.model;

import javax.persistence.*;

/**
 * Trida studenta
 * Anotace jsou pouzivany jen v JPA. Pro ostatni prezentovane varianty 
 * pristupu k datum nejsou vyuzivany
 * 
 * @author Tomas Kozel
 * 
 */
@Entity
@Table(name="studenti")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int cisloStudia;
	private String prijmeni;
	private String jmeno;

	public Student() {
		super();
	}

	public Student(int cisloStudia, String prijmeni, String jmeno) {
		super();
		this.cisloStudia = cisloStudia;
		this.prijmeni = prijmeni;
		this.jmeno = jmeno;
	}

	public Student(String prijmeni, String jmeno) {
		this.prijmeni = prijmeni;
		this.jmeno = jmeno;
	}

	public int getCisloStudia() {
		return cisloStudia;
	}

	public void setCisloStudia(int cisloStudia) {
		this.cisloStudia = cisloStudia;
	}

	public String getPrijmeni() {
		return prijmeni;
	}

	public void setPrijmeni(String prijmeni) {
		this.prijmeni = prijmeni;
	}

	public String getJmeno() {
		return jmeno;
	}

	public void setJmeno(String jmeno) {
		this.jmeno = jmeno;
	}

}
