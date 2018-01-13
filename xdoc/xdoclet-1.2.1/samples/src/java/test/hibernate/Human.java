package test.hibernate;

/**
 * @author Administrator
 *
 * @hibernate.joined-subclass
 *  table="HUMANS"
 *  dynamic-update="true"
 * @hibernate.joined-subclass-key
 *  column="ANIMAL_ID"
 */
public class Human extends Animal {

	private Name name;
	private String occupation;

	/**
	 * Constructor for Human.
	 */
	public Human() {
		super();
	}
	
	/**
	 * @hibernate.component
	 * Returns the name.
	 * @return Name
	 */
	public Name getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * @param name The name to set
	 */
	public void setName(Name name) {
		this.name = name;
	}

	/**
	 * @hibernate.property
	 * Returns the occupation.
	 * @return String
	 */
	public String getOccupation() {
		return occupation;
	}

	/**
	 * Sets the occupation.
	 * @param occupation The occupation to set
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

}
