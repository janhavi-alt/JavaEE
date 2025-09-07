package ejb;

import jakarta.ejb.Singleton;

@Singleton
public class HitCounterBean {
    private int count = 0;

    public int incrementAndGet() {
        count++;
        return count;
    }
}
