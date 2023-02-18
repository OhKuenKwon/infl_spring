package com.inf.sp3.service;

import com.inf.sp3.order.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
