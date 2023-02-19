package com.inf.sp5.service;

import com.inf.sp5.order.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
