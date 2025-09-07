package ejb;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.EJB;  // ✅ Use @EJB for injecting EJBs
import jakarta.ejb.MessageDriven;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

@MessageDriven(
    activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/VisitorQueue"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue")
    }
)
public class VisitorMessageBean implements MessageListener {

    @EJB   // ✅ Changed from @Inject to @EJB
    private VisitorStatBean visitorStatBean;

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Visitor Message Received!");
            visitorStatBean.incrementVisitor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
