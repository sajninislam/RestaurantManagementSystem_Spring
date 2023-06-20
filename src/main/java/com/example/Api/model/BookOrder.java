package com.example.Api.model;

import com.example.Api.enums.OrderStatus;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookOrder extends BaseModel{

    private String foodDetails;
    private String foodImg;
    private String foodName;
    private String foodPrice;
    private String quantity;
    private String total;
    private String userName;
    private String customerName;
    private String customerPhNu;
    private String customerAddress;
    private String PaymentMethod;
//    private String createdAt;


//    private String orderstatus;



    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;


}
