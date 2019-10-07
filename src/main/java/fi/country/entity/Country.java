package fi.country.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRY")
public class Country extends Base {

	private static final long serialVersionUID = 1L;

	@Column(name = "NAME", insertable = true, updatable = true, nullable = false, length = 64)
	private String name;

	public Country() {
		super();
	}

	public Country(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
