package br.com.sdweb.agenda.entrypoint.controller.httmodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseHttpModel<T> {
    private String status;
    private Integer code;
    private Long timestamp;
    private String message;
    private List<T> data;
}
