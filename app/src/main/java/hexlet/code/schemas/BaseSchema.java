package hexlet.code.schemas;

import java.util.Objects;

public class BaseSchema {
    private boolean requiredActive = false;
    /**
     * This function
     @return scheme-type and mark the required flag
     */
    public BaseSchema required() {
        requiredActive = true;
        return this;
    }
    /**
     * This function check empty and null input
     @return valid or not input object
     */
    public boolean isValid(Object inputData) {
        return !requiredActive && (Objects.equals(inputData, null) || Objects.equals(inputData, ""));
    }
}
