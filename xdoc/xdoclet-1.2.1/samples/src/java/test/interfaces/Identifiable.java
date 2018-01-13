package test.interfaces;

/**
 * This interface can be implemented by objects that have a
 * String id (primary key) and a getter for it. At the client side
 * the developer can cast using this interface to obtain the id.
 */
public interface Identifiable {
    public java.lang.String getId();
}