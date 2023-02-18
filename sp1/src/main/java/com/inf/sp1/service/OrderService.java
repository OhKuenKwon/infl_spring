package com.inf.sp1.service;

import com.inf.sp1.order.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
