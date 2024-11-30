package br.anhembi.a3.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvestimentoLinkDTO {
    private List<Integer> investimentoIds;
    /*
     * FORMATO JASON PARA ESTE DTO
     * 
     * {
     *  "investimentoIds": [1, 2, 3]
     * }
     * 
     */
}
