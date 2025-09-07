package cart;

import java.util.ArrayList;
import java.util.List;
import jakarta.ejb.Remove;
import jakarta.ejb.Stateful;

@Stateful
public class CartBean implements CartBeanLocal {
    private String customerName;
    private String customerId;
    private List<String> contents = new ArrayList<>();

    public void initialize(String person, String id) {
        if (person == null) {
            throw new IllegalArgumentException("Null person not allowed.");
        } else {
            customerName = person;
        }

        if ("ABC".equals(person) && "123".equals(id)) {
            customerId = id;
        } else {
            throw new IllegalArgumentException("Invalid id: " + id);
        }
    }

    public void addBook(String title) {
        contents.add(title);
    }

    public void removeBook(String title) {
        boolean result = contents.remove(title);
        if (!result) {
            throw new IllegalArgumentException(title + " not in cart.");
        }
    }

    public List<String> getContents() {
        return contents;
    }

    @Remove
    public void remove() {
        contents = null;
    }
}
