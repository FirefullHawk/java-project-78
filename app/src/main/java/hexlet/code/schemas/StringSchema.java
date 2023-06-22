package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {

    @Override
    public StringSchema required() {
        super.required();

        Predicate<Object> typeCheck =
                inputDate -> inputDate instanceof String;
        addCheck(typeCheck);

        return this;
    }

    @Override
    public boolean isValid(Object inputData) {
        return super.isValid(inputData);
    }

    public StringSchema minLength(int minLengthInput) {
        Predicate<Object> minLength =
                inputData -> inputData.toString().length() >= minLengthInput;
        addCheck(minLength);
        return this;
    }

    public StringSchema contains(String substring) {
        Predicate<Object> contains =
                inputData -> inputData.toString().contains(substring);
        addCheck(contains);
        return this;
    }
}
