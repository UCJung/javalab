/*
 * @(#)OrderModel.java $version 2015. 6. 19.
 *
 * Copyright 2015 Godosoft. All rights Reserved.
 * Godosoft PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.yjwee.designpattern.state;

/**
 * @author YeongJong Wee
 */
public class OrderModel {

    private int state;
    private int totalAmount;
    private String productName;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

}
