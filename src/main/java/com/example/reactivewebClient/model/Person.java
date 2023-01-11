package com.example.reactivewebClient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person extends  PersonResponse{
    private String firstname;
    private String lastname;
}
