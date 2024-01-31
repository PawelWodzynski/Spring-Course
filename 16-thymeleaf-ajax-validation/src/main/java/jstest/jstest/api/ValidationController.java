package jstest.jstest.api;

import jakarta.validation.Valid;
import jstest.jstest.entity.Homie;
import jstest.jstest.api.utils.ValidationError;
import jstest.jstest.api.utils.ValidationErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidationController {

    // Rest Controller for processing validation on objects from html forms





    // Post mapping for handling validation on Homie entity object
    @PostMapping("/validation")
    public ResponseEntity<?> validation(@Valid @ModelAttribute("homie") Homie theHomie, BindingResult theBindingResult) {

        // if validation result has error, put Validation error into error response list, and return HTTP answer with error response
        if (theBindingResult.hasErrors()) {
            ValidationErrorResponse errorResponse = new ValidationErrorResponse();
            errorResponse.setErrors(ValidationError.getErrors(theBindingResult));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

        // if validation result has no errors, return string, in this place can execute many other operations
        } else {
            return ResponseEntity.ok("homie-is-homie");
        }
    }








}



