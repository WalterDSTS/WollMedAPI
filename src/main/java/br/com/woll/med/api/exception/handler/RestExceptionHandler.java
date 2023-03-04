package br.com.woll.med.api.exception.handler;

import br.com.woll.med.api.exception.dto.ValidationErrorData;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandler {
  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity handleError404() {
    return ResponseEntity.notFound().build();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity handleError400(MethodArgumentNotValidException ex) {
    List<FieldError> errors = ex.getFieldErrors();
    return ResponseEntity.badRequest().body(
        errors
            .stream()
            .map(ValidationErrorData::new)
            .collect(Collectors.toList()));
  }
}
