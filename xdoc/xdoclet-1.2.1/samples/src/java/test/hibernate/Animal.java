package test.hibernate;

import java.util.Set;

/**
 * @author Administrator
 *
 * @hibernate.class
 *  table="ANIMALS"
 *  dynamic-update="true"
 */
public class Animal extends Persistent {
	
	private Set prey;
	private char sex;

	/**
	 * Constructor for Animal.
	 */
	public Animal() {
		super();
	}

	/**
	 * @hibernate.set
	 *  lazy="true"
	 *  table="PREDATOR_PREY"
	 *  order-by="PREY_ID"
	 * @hibernate.collection-key
	 *  column="PREDATOR_ID"
	 * @hibernate.collection-many-to-many
	 *  column="PREY_ID"
	 * @return Set
	 */
	public Set getPrey() {
		return prey;
	}

	/**
	 * Sets the prey.
	 * @param prey The prey to set
	 */
	public void setPrey(Set prey) {
		this.prey = prey;
	}

	/**
	 * @hibernate.property
	 *  not-null="true"
	 * Returns the sex.
	 * @return char
	 */
	public char getSex() {
		return sex;
	}

	/**
	 * Sets the sex.
	 * @param sex The sex to set
	 */
	public void setSex(char sex) {
		this.sex = sex;
	}

}
