package test.hibernate;

import java.util.Date;

/**
 * @author Administrator
 */
public abstract class Persistent {

	private Long id;
	private int version;
	private Date created;

	/**
	 * Constructor for Persistent.
	 */
	public Persistent() {
		super();
	}

	/**
	 * @hibernate.id
	 *  unsaved-value="null"
	 *  generator-class="sequence"
	 * @hibernate.generator-param
	 *  name="table"
	 *  value="HIVAL"
	 * @hibernate.generator-param
	 *  name="column"
	 *  value="NEXT"
	 * @return Long
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * @param id The id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @hibernate.version
	 * @return int
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * Sets the version.
	 * @param version The version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * @hibernate.property
	 *  update="false"
	 *  insert="true"
	 *  type="timestamp"
	 * Returns the created.
	 * @return Date
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * Sets the created.
	 * @param created The created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

}
