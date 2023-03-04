package br.com.woll.med.api.exception.dto;

import lombok.Data;
import org.springframework.validation.FieldError;

@Data
public class ValidationErrorData {
  private String field, message;

  public ValidationErrorData(FieldError error) {
    this.field = error.getField();
    this.message = error.getDefaultMessage();
  }
}
