package models;

import utils.StringUtils;

public class Valid<T> {
    private T model;
    private String errorMessage;

    private Valid(T model, String errorMessage) {
        this.model = model;
        this.errorMessage = errorMessage;
    }

    public static <T> Valid<T> getInstaceForModel(T model) {
        return new Valid<>(model, "");
    }

    public static <T> Valid<T> getInstaceForError(String errorMessage) {
        return new Valid<>(null, errorMessage);
    }

    public T getModel() {
        return model;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isValid() {
        return !StringUtils.isEmptyOrNull(errorMessage);
    }
}