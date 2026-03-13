package br.com.sdweb.agenda.validator;

import br.com.sdweb.agenda.exception.BusinessException;
import br.com.sdweb.domains.Agenda;
import exceptions.Errors;
import utils.LocalDateTimeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EventValidator {

    public static void valid(Agenda agenda) {
        List<Errors> errorDTOList = new ArrayList<>();
        validarDataInicio(agenda, errorDTOList);
        validarDataFim(agenda, errorDTOList);


        if(!errorDTOList.isEmpty()){
            throw new BusinessException(
                    "Falha na validação das Datas.",
                    errorDTOList
            );
        }
    }

    private static void validarDataInicio(Agenda agenda, List<Errors> errorDTOList) {

        if (LocalDateTimeUtils.isDateBeforeOfDateNow(agenda.getDataInicio())) {
            errorList(errorDTOList, Errors.ERROR0001);
        }

        if (Objects.nonNull(agenda.getDataFim()) && LocalDateTimeUtils.isDateBeforeOfBetween(agenda.getDataFim(), agenda.getDataInicio())) {
            errorList(errorDTOList, Errors.ERROR0002);
        }
    }


    private static void validarDataFim(Agenda agenda, List<Errors> errorDTOList) {

        if (Objects.nonNull(agenda.getDataFim()) &&  LocalDateTimeUtils.isDateBeforeOfDateNow(agenda.getDataFim())) {
            errorList(errorDTOList, Errors.ERROR0003);
        }
    }

    private static void errorList(List<Errors> errorDTOList, Errors error) {
        errorDTOList.add(
                error
        );
    }
}
