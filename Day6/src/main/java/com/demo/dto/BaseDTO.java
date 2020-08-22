package com.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseDTO<T> {
    private int status;
    private String message;
    private T data;
    private List<T> datas;

    public void setMessage(String success) {
    }

    public void setStatus(int i) {
    }
//
//    public void setDatas(List<List<ProductEntity>> content) {
//    }
}
