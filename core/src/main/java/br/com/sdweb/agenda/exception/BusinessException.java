package br.com.sdweb.agenda.exception;

import exceptions.ErrorDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@Setter
public class BusinessException extends RuntimeException {

    private List<ErrorDTO> errorList;

    public BusinessException(String message, List<ErrorDTO> errorList) {
        super(message);
        log.error(message);

        this.errorList = errorList;
    }

    public BusinessException(String message, List<ErrorDTO> errorList, Throwable cause) {
        super(message, cause);
        log.error(message, cause);

        this.errorList = errorList;
    }
}
