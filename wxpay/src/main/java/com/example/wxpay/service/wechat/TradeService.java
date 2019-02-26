package com.example.wxpay.service.wechat;

import org.springframework.stereotype.Service;

/**
 * Created by Blake on 2018/10/31
 */
@Service
public class TradeService {

    /**
     * 交易是否处理完成
     *
     * @param orderId
     * @return
     */
    public boolean hasProcessed(String orderId) {
        return false;
    }
}
