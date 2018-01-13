package test.hibernate;
/**
 * @hibernate.class
 *  table="ITEMS"
 *  mutable="false"
 *  schema="SHOP"
 *  proxy="LineItem"
 * 
 * @author Administrator
 *
 */
public class LineItem extends Persistent {
	
	private Order order;
	private Product product;
	private int quantity;

	/**
	 * Constructor for LineItem.
	 */
	public LineItem() {
		super();
	}

	/**
	 * @hibernate.many-to-one
	 *  outer-join="true"
	 *  cascade="save-update"
	 *  column="ORDER_ID"
	 *  not-null="true"
	 *  sql-type="BIGINT"
	 * @return Order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * Sets the order.
	 * @param order The order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @hibernate.property
	 *  column="AMOUNT"
	 *  not-null="true"
	 *  unique="false"
	 * Returns the quantity.
	 * @return int
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 * @param quantity The quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @hibernate.many-to-one
	 *  column="PRODUCT_ID"
	 *  outer-join="true"
	 *  not-null="true"
	 * @return Product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Sets the product.
	 * @param product The product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

}
