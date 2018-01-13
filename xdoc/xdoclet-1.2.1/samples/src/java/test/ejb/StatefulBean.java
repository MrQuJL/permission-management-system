package test.ejb;

/**
 * @ejb.bean
 *     name="Stateful"
 *     type="Stateful"
 *     description="bébé"
 *
 * @jonas.bean ejb-name="Stateful"
 *             jndi-name="StatefulHome"
 */
public abstract class StatefulBean implements javax.ejb.SessionBean {
    private String x;

    /**
     * @ejb.interface-method
     */
    public String foobar() {
        return "Foobar";
    }

    /**
     * @ejb.create-method
     */
    public void ejbCreateWithParam(String x) {
        this.x = x;
    }

    /**
     * @ejb.create-method
     */
    public void ejbCreate(String x) {
        this.x = x;
    }

}
