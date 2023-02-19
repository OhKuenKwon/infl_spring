package com.inf.sp4.service;

import com.inf.sp4.order.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
