package com.consultoria.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "catalogo_broker")

public class CatalogoBrokerEntity {

@Id
@Column(name ="codigo",nullable = false)
    private Integer codigo;

@Column(name = "Broker",nullable = false)
   private String broker;

@Column(name = "RFC",nullable = false)
private String rfc;

}
