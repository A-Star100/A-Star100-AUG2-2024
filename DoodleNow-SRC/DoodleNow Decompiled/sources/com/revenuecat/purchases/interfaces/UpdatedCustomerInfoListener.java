package com.revenuecat.purchases.interfaces;

import com.revenuecat.purchases.CustomerInfo;

public interface UpdatedCustomerInfoListener {
    void onReceived(CustomerInfo customerInfo);
}
