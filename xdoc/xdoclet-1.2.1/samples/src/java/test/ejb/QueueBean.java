package test.ejb;

import javax.ejb.EJBException;
import javax.ejb.MessageDrivenBean;
import javax.ejb.MessageDrivenContext;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * A message-driven bean based on a Queue.
 *
 * <p>A message-driven bean is an EJB that acts as a message consumer in the WebLogic JMS messaging
 * system. As with standard JMS message consumers, message-driven beans receive messages from a JMS
 * Queue or Topic, and perform business logic based on the message contents.</p>
 *
 * <p>More info on message-driven beans can be found here:
 * <a href="http://www.onjava.com/pub/a/onjava/excerpt/ejb3_ch13/index.html?page=5#17">
 * http://www.onjava.com/pub/a/onjava/excerpt/ejb3_ch13/index.html?page=5#17</a></p>
 *
 * @ejb.bean
 *     name="QueueBean"
 *     acknowledge-mode="Auto-acknowledge"
 *     destination-type="javax.jms.Queue"
 *     subscription-durability="NonDurable"
 *     transaction-type="Bean"
 *
 * @jboss.destination-jndi-name
 *     name="queue/testQueue"
 *
 * @weblogic.pool
 *     initial-beans-in-free-pool="1"
 *     max-beans-in-free-pool="3"
 *
 * @weblogic.message-driven
 *     connection-factory-jndi-name="moe"
 *     destination-jndi-name="queue/testQueue"
 *     initial-context-factory="meenie"
 *     jms-client-id="a"
 *     jms-polling-interval-seconds="4"
 *     provider-url="minie"
 *
 * @weblogic.transaction-descriptor
 *     trans-timeout-seconds="10"
 *
 * @weblogic.resource-description
 *     jndi-name="cream"
 *     res-ref-name="ice"
 *
 * @weblogic.resource-env-description
 *     jndi-name="pie"
 *     res-env-ref-name="blueberry"
 *
 * @weblogic.ejb-reference-description
 *     ejb-ref-name="hot"
 *     jndi-name="iron"
 *
 * @weblogic.ejb-local-reference-description
 *     ejb-ref-name="mashed"
 *     jndi-name="potatoes"
 *
 * @weblogic.enable-call-by-reference True
 *
 * @weblogic.run-as-identity-principal True
 *
 * @jonas.bean ejb-name="QueueBean"
 * @jonas.message-driven-destination jndi-name="queue/testQueue"
 * 
 * @author  <a href="mailto:youremail@yourdomain.com">youremail@yourdomain.com</a>
 */
public class QueueBean implements MessageDrivenBean, MessageListener {
    /** The context for the message-driven bean, set by the EJB container. */
    private MessageDrivenContext messageContext = null;

    /** Required method for container to set context. */
    public void setMessageDrivenContext(MessageDrivenContext messageContext) throws EJBException {
        this.messageContext = messageContext;
    }

    /**
     * Required creation method for message-driven beans.
     *
     * @ejb.create-method
     */
    public void ejbCreate() {
        // no specific action required for message-driven beans
    }

    /** Required removal method for message-driven beans. */
    public void ejbRemove() {
        messageContext = null;
    }

    /**
     * This method implements the business logic for the EJB.
     *
     * <p>Make sure that the business logic accounts for asynchronous message processing.
     * For example, it cannot be assumed that the EJB receives messages in the order they were
     * sent by the client. Instance pooling within the container means that messages are not
     * received or processed in a sequential order, although individual onMessage() calls to
     * a given message-driven bean instance are serialized.
     *
     * <p>The <code>onMessage()</code> method is required, and must take a single parameter
     * of type javax.jms.Message. The throws clause (if used) must not include an application
     * exception. Must not be declared as final or static.
     */
    public void onMessage(Message message) {
        System.out.println("QueueBean got message " + message);
        // do business logic here
    }

}
