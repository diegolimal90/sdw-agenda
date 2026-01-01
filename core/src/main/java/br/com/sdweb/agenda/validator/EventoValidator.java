package br.com.sdweb.agenda.validator;

import br.com.sdweb.agenda.exception.BusinessException;
import br.com.sdweb.domains.Agenda;
import exceptions.ErrorDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EventoValidator {

    public static void valid(Agenda agenda) {
        List<ErrorDTO> errorDTOList = new ArrayList<>();
        validarDataInicio(agenda, errorDTOList);
        validarDataFim(agenda, errorDTOList);
    }

    private static void validarDataInicio(Agenda agenda, List<ErrorDTO> errorDTOList) {

        if (agenda.getDataInicio().isBefore(LocalDateTime.now())) {

            errorList(errorDTOList, "00001", "Data inicio deve ser igual ou maior a atual.");
        }

        if (Objects.nonNull(agenda.getDataFim()) && agenda.getDataInicio().isAfter(agenda.getDataFim())) {
            errorList(errorDTOList, "00002", "Data fim deve ser maior a data inicio.");
        }

        if(!errorDTOList.isEmpty()){
            throw new BusinessException(
                    "Falha na validação de Data Inicio.",
                    errorDTOList
            );
        }
    }


    private static void validarDataFim(Agenda agenda, List<ErrorDTO> errorDTOList) {

        if (agenda.getDataFim().isBefore(LocalDateTime.now())) {

            errorList(errorDTOList, "00001", "Data fim deve ser igual ou maior a atual.");
        }

        if(!errorDTOList.isEmpty()){
            throw new BusinessException(
                    "Falha na validação de Data Inicio.",
                    errorDTOList
            );
        }
    }

    private static void errorList(List<ErrorDTO> errorDTOList, String code, String message) {
        errorDTOList.add(
                ErrorDTO.builder()
                        .code(code)
                        .message(message)
                        .build()
        );
    }
}
