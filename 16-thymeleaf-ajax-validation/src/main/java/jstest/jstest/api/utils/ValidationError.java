package jstest.jstest.api.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;


import java.util.Map;
import java.util.stream.Collectors;

public class ValidationError {
    public static Map<String, String> getErrors(BindingResult bindingResult) {
        return bindingResult.getFieldErrors()
                .stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
    }
}
