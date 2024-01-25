package com.consultoria.Web.Controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CatalogoBrokerDTO {

    private Integer codigo;

    private  String broker;

    private String rfc;
}
