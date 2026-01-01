package br.com.sdweb.agenda.configuration.handler;

import br.com.sdweb.agenda.entrypoint.controller.httmodel.ResponseHttpModel;
import br.com.sdweb.agenda.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

@ControllerAdvice
public class ControllerAdviceException {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ResponseHttpModel> businessException(BusinessException ex){

        var err = new ResponseHttpModel<>(
                "ERROR",
                422,
                System.currentTimeMillis(),
                "Request error",
                ex.getErrorList()
        );
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
    }
}
