package com.inf.sp0.service;

import com.inf.sp0.order.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
