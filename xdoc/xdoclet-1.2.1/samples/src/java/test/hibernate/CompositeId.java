/*
 * Copyright (c) 2001, 2002 The XDoclet team
 * All rights reserved.
 */
package test.hibernate;

import java.io.Serializable;
/**
 * composite ID class example
 *
 * @created   January 6, 2003
 */
public class CompositeId implements Serializable
{

    /**
     */
    Integer         _foo;

    /**
     */
    long            _bar;

    /**
     */
    String          _baz;

    /**
     */
    Order           _order;

    /**
     * @return
     * @hibernate.property
     */
    public Integer getFoo()
    {
        return _foo;
    }

    /**
     * @return
     * @hibernate.property
     */
    public long getBar()
    {
        return _bar;
    }

    /**
     * @return
     * @hibernate.property
     */
    public String getBaz()
    {
        return _baz;
    }

    /**
     * @return
     * @hibernate.many-to-one
     */
    public Order getOrder()
    {
        return _order;
    }

    /**
     * @param foo
     */
    public void setFoo(Integer foo)
    {
        _foo = foo;
    }

    /**
     * @param bar
     */
    public void setBar(long bar)
    {
        _bar = bar;
    }

    /**
     * @param baz
     */
    public void setBaz(String baz)
    {
        _baz = baz;
    }

    /**
     * @param order
     */
    public void setOrder(Order order)
    {
        _order = order;
    }

    /**
     * @param o
     * @return
     */
    public boolean equals(Object o)
    {
        if (o == null) {
            return false;
        }
        if (getClass().equals(o.getClass()) &&
            _foo.equals(((CompositeId) o).getFoo()) &&
            _bar == ((CompositeId) o).getBar() &&
            _baz.equals(((CompositeId) o).getBaz())
            ) {
            return true;
        }
        else {
            return false;
        }

    }

    public int hashCode()
    {
		return _baz.hashCode();
	}
}
