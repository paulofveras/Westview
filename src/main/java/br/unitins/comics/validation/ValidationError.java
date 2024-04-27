package br.unitins.comics.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends br.unitins.comics.util.Error {

    record FieldError(String fieldName, String message) {};

    private List<FieldError> errors = null;

    public ValidationError(String code, String message) {
        super(code, message);
    }

    public void addFieldError(String fieldName, String message) {
        if (errors == null)
            errors = new ArrayList<FieldError>();
        errors.add(new FieldError(fieldName, message));
    }

    public List<FieldError> getErrors() {
        return errors.stream().toList();
    }
  
}
