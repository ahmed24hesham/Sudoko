package result;

import java.util.ArrayList;
import java.util.List;

public class DuplicateResult {
    private boolean valid = true;
    private final List<String> messages = new ArrayList<>();

    public void add(String msg) {
        valid = false;
        messages.add(msg);
    }

    public boolean isValid() {
        return valid;
    }

    public List<String> getMessages() {
        return messages;
    }
}