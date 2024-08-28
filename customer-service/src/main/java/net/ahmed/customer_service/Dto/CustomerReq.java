package net.ahmed.customer_service.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
@Data@AllArgsConstructor@NoArgsConstructor
public  class CustomerReq {
    private  String firstName;
    private  String lastName;
    private  String email;

}
