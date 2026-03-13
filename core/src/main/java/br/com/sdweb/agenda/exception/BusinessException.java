package br.com.sdweb.agenda.exception;

import exceptions.Errors;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@Setter
public class BusinessException extends RuntimeException {

    private List<Errors> errorList;

    public BusinessException(String message, List<Errors> errorList) {
        super(message);
        log.error(message);

        this.errorList = errorList;
    }

    public BusinessException(String message, List<Errors> errorList, Throwable cause) {
        super(message, cause);
        log.error(message, cause);

        this.errorList = errorList;
    }
}
