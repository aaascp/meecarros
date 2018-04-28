package models;

import java.util.List;

public class Valid<T> {
    private T model;
    private List<?> errors;

    private Valid(T model, List<?> errors) {
        this.model = model;
        this.errors = errors;
    }

    public static <T> Valid<T> getInstanceForModel(T model) {
        return new Valid<>(model, null);
    }

    public static <T> Valid<T> getInstanceForError(List<?> errors) {
        return new Valid<>(null, errors);
    }

    public T getModel() {
        return model;
    }

    public List<?> getErrors() {
        return errors;
    }

    public void setErrors(List<?> errors) {
        this.errors = errors;
    }

    public boolean isValid() {
        return errors == null;
    }
}