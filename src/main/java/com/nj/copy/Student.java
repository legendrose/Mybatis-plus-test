package com.nj.copy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Student implements Serializable {
    private String id;
    private String name;
    private Car car;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
