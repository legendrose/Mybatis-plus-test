package com.nj.copy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Car implements Serializable {
    private String xh;
    private String price;
}
