package br.com.sdweb.agenda.configuration.handler;

import br.com.sdweb.agenda.entrypoint.controller.httmodel.ResponseHttpModel;
import br.com.sdweb.agenda.exception.BusinessException;
import exceptions.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@ControllerAdvice
public class ControllerAdviceException {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ResponseHttpModel<ErrorDTO>> businessException(BusinessException ex){

        var err = new ResponseHttpModel<>(
                "ERROR",
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                System.currentTimeMillis(),
                "Request error",
                ex.getErrorList().stream()
                        .map(s -> ErrorDTO.builder()
                                .code(s.getCode())
                                .message(s.getMessage())
                                .build())
                        .toList()
        );
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseHttpModel<ErrorDTO>> businessException(HttpMessageNotReadableException ex){

        var err = new ResponseHttpModel<>(
                "ERROR",
                HttpStatus.BAD_REQUEST.value(),
                System.currentTimeMillis(),
                "Request error",
                List.of(ErrorDTO.builder()
                        .code("9999")
                        .message(ex.getMessage())
                        .build())
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
}
