package com.inf.sp2.service;

import com.inf.sp2.order.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
