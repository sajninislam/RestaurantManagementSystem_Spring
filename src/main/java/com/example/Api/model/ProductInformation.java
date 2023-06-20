package com.example.Api.model;

import com.example.Api.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductInformation extends BaseModel{


    private String foodDetails;
    private String foodImg;
    private String foodName;
    private String foodPrice;
    private String quantity;
    private String total;
    private String userName;



//    @Column(updatable = false)
//    @CreationTimestamp
//    private LocalDateTime possibleDeliveredTime= getCreatedBy().plusDays(1)


    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

}
