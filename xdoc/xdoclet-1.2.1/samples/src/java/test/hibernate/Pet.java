package test.hibernate;

/**
 * @author Administrator
 *
 * @hibernate.subclass
 *  table="PETS"
 *  discriminator-value="pet"
 */
public class Pet extends Product {

	private Animal animal;

	/**
	 * Constructor for Pet.
	 */
	public Pet() {
		super();
	}

	/**
	 * @hibernate.one-to-one
	 * @return Animal
	 */
	public Animal getAnimal() {
		return animal;
	}

	/**
	 * Sets the animal.
	 * @param animal The animal to set
	 */
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

}
