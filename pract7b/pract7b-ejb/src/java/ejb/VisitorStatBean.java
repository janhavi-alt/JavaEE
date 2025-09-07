package ejb;

import jakarta.ejb.Stateless;

@Stateless
public class VisitorStatBean {
    private static int visitorCount = 0;

    public void incrementVisitor() {
        visitorCount++;
    }

    public int getVisitorCount() {
        return visitorCount;
    }
}
