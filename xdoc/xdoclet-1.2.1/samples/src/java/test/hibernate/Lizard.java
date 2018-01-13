package test.hibernate;

/**
 * @author Administrator
 *
 * @hibernate.joined-subclass
 *  table="LIZARDS"
 * @hibernate.joined-subclass-key
 *  column="ANIMAL_ID"
 */
public class Lizard extends Reptile {
	
	private float bodyTemperature;

	/**
	 * Constructor for Lizard.
	 */
	public Lizard() {
		super();
	}

	/**
	 * @hibernate.property
	 *  not-null="true"
	 * @return float
	 */
	public float getBodyTemperature() {
		return bodyTemperature;
	}

	/**
	 * Sets the bodyTemperature.
	 * @param bodyTemperature The bodyTemperature to set
	 */
	public void setBodyTemperature(float bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
	}

}
