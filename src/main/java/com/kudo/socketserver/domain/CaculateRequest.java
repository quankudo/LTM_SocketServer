/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kudo.socketserver.domain;

import com.kudo.socketserver.enums.OperationMethod;

/**
 *
 * @author HP
 */
public class CaculateRequest {
    private int number1;
    private int number2;
    private OperationMethod method;

    public CaculateRequest(int number1, int number2, OperationMethod method) {
        this.number1 = number1;
        this.number2 = number2;
        this.method = method;
    }

    public CaculateRequest() {
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public OperationMethod getMethod() {
        return method;
    }

    public void setMethod(OperationMethod method) {
        this.method = method;
    }
    
}
