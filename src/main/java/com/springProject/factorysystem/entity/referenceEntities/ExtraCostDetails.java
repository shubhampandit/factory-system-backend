package com.springProject.factorysystem.entity.referenceEntities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExtraCostDetails {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String type;
    private Float integratedTax;
    private Float centralTax;
    private Float stateTax;
    private Double commissionedLoadingRate;
    private Double unCommissionedLoadingRate;
    private Double localTransitInsurance;
    private Double interstateTransitInsurance;
    private Double cuttingRate;
}
