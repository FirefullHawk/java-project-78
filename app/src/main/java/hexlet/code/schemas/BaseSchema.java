package hexlet.code.schemas;

import java.util.Objects;

public class BaseSchema {
    private boolean requiredActive = false;

    public BaseSchema required() {
        requiredActive = true;
        return this;
    }
    public boolean isValid(Object inputData) {
        return !requiredActive && Objects.equals(inputData, null);
    }
}
