package test.hibernate;

import java.util.Calendar;
import java.util.List;

/**
 * @author Administrator
 *
 * @hibernate.jcs-cache
 *  usage="read-write"
 * @hibernate.class
 *  table="ORDERS"
 *  polymorphism="explicit"
 *  mutable="false"
 */
public class Order extends Persistent implements Updateable {
	
	private List items;
	private Human customer;
	private Calendar date;
	private String updateComment;

	/**
	 * Constructor for Order.
	 */
	public Order() {
		super();
	}

	/**
	 * @hibernate.list
	 *  lazy="true"
	 *  inverse="true"
	 *  cascade="all"
	 * @hibernate.jcs-cache
	 *  usage="read-write"
	 * @hibernate.collection-key
	 *  column="ORDER_ID"
	 * @hibernate.collection-index
	 *  column="ORDER_POS"
	 * @hibernate.collection-one-to-many
	 *  class="test.hibernate.LineItem"
	 * @return List
	 */
	public List getItems() {
		return items;
	}

	/**
	 * Sets the items.
	 * @param items The items to set
	 */
	public void setItems(List items) {
		this.items = items;
	}

	/**
	 * @hibernate.property
	 *  type="calendar_date"
	 * Returns the date.
	 * @return Calendar
	 */
	public Calendar getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 * @param date The date to set
	 */
	public void setDate(Calendar date) {
		this.date = date;
	}

	/**
	 * @hibernate.many-to-one
	 *  column="CUSTOMER_ID"
	 *  not-null="true"
	 * @return Human
	 */
	public Human getCustomer() {
		return customer;
	}

	/**
	 * Sets the customer.
	 * @param customer The customer to set
	 */
	public void setCustomer(Human customer) {
		this.customer = customer;
	}

	public String getUpdateComment() {
		return updateComment;
	}

	public void setUpdateComment(String string) {
		updateComment = string;
	}

}
