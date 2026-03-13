package exceptions;

import lombok.Getter;

@Getter
public enum Errors {

    ERROR0001("0001", "Data inicio deve ser igual ou maior a atual."),
    ERROR0002("00002", "Data fim deve ser maior que a data inicio."),
    ERROR0003("00003", "Data fim deve ser igual ou maior a atual.");


    private String code;
    private String message;

    private Errors(String code, String message){
        this.code = code;
        this.message = message;
    }
}
