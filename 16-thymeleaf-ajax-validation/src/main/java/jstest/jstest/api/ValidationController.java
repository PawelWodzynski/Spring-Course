package jstest.jstest.api;

import jakarta.validation.Valid;
import jstest.jstest.DTO.HomieOkResponseDTO;
import jstest.jstest.entity.Homie;
import jstest.jstest.api.utils.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

// Controller for handling validation of Homie entities from HTML forms
@RestController
public class ValidationController {






    // Handles validation for Homie entity objects submitted from HTML forms
    @PostMapping("/validation")
    public ResponseEntity<?> validation(@Valid @ModelAttribute("homie") Homie theHomie, BindingResult theBindingResult) {

        if (theBindingResult.hasErrors()) {
        // If validation result has errors, return a Bad Request status with error details
            Map<String, String> fieldErrors = ValidationError.getErrors(theBindingResult);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldErrors);
        } else {
        // If validation result is successful, return an OK status with a success message
            HomieOkResponseDTO homieOkResponseDTO = new HomieOkResponseDTO("Validation ok: homie is homie, homie");
            return ResponseEntity.ok(homieOkResponseDTO);
        }
    }








}



