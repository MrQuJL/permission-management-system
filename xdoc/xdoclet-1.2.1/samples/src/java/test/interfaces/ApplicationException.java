
package test.interfaces;

/**
 * Every J2EE application needs to specify custom exceptions, that are thrown by business logic.
 * For example when validating a value set on an entity bean, this exception can be thrown. When
 * implementing the Session Facade Pattern, these exceptions can be wrapped in a RemoteException
 * and passed to the client. The client can then act on these in a user-friendly way.
 *
 * <p>For ease-of-use this exception is in the interfaces package. When you have many more
 * application-specific exceptions, put them in a seperate package, it improves reuse and
 * maintainability.</p>
 *
 * <p>For more information on EJB exception handling, read the
 * <a href="http://www-106.ibm.com/developerworks/java/library/j-ejbexcept.html">
 * Best practices in EJB exception handling</a> article at <a href="http://www-106.ibm.com/developerworks/">IBM developerWorks</a>.
 *
 * @author  <a href="mailto:youremail@yourdomain.com">youremail@yourdomain.com</a>
 */
public class ApplicationException extends Exception {
    public ApplicationException(String string) {
        super(string);
    }
}