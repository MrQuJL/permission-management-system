package test.hibernate;

/**
 * @author Administrator
 *
 * @hibernate.subclass
 *  discriminator-value="contraband"
 */
public class Contraband extends ImportedProduct {

	/**
	 * Constructor for Contraband.
	 */
	public Contraband() {
		super();
	}

}
