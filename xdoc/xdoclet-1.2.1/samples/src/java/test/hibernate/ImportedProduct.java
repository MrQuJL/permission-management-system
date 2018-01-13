package test.hibernate;

import java.util.Locale;

/**
 * @author Administrator
 *
 * @hibernate.subclass
 *  discriminator-value="imported"
 */
public class ImportedProduct extends Product {
	
	private String origin;
	private Locale locale;

	/**
	 * Constructor for ImportedProduct.
	 */
	public ImportedProduct() {
		super();
	}

	/**
	 * @hibernate.property
	 *  not-null="true"
	 * Returns the origin.
	 * @return String
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * Sets the origin.
	 * @param origin The origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * @hibernate.property
	 * @return Locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * Sets the locale.
	 * @param locale The locale to set
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

}
