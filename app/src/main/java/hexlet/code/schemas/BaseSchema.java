package hexlet.code.schemas;

import java.util.Objects;

public class BaseSchema {
    private boolean requiredActive = false;
    /**
     * This function mark the required flag.
     * @return scheme-type
     */
    public BaseSchema required() {
        requiredActive = true;
        return this;
    }
    /**
     * This function check empty and null input.
     @return valid or not input object
     @param inputData is Object which must be validated
     */
    public boolean isValid(Object inputData) {
        return !requiredActive && (Objects.equals(inputData, null) || Objects.equals(inputData, ""));
    }
}
