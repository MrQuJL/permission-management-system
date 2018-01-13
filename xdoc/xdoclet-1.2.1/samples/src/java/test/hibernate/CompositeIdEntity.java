package test.hibernate;

/**
 * demonstrate composite ID
 *
 * @author                    ko5tik ( Konstantin Pribluda )
 * @hibernate.class
 */
public class CompositeIdEntity
{

 	private CompositeId _id;
	private String _foo;
	/**
     * @hibernate.id    generator-class="assigned"
	 */
	public CompositeId getId() {
		return _id;
	}

	public void setId(CompositeId id) {
		_id = id;
	}

	public String getFoo() {
		return _foo;
	}
    /**
     * foo value
     *
     * @return               String
     * @hibernate.property
     */

	public void setFoo(String foo) {
		_foo = foo;
	}

}

