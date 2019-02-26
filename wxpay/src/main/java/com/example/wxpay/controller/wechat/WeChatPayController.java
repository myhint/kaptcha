package com.example.wxpay.controller.wechat;

import com.example.wxpay.service.wechat.WeChatPayService;
import com.example.wxpay.utils.WxUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by Blake on 2018/10/31
 */
@RestController
@RequestMapping("/api/payment")
public class WeChatPayController {

    @Autowired
    private WeChatPayService wxPayService;

    @Autowired
    private WxUtils wxUtils;

    /**
     * 获取 openid
     */
    @GetMapping("/wx-pay/openid")
    public String getOpenId() throws IOException {

        String fromurl = "";
        String appid = "";

        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appid + "&redirect_uri="
//                + encodeURIComponent(fromurl) +
               + "&response_type=code&scope=snsapi_base&state=123#wechat_redirect";

        return wxUtils.executeHttpGet(url);
    }

    /**
     * 微信统一下单
     */
    @PostMapping("/wx-pay/pre-pay")
    public String createPayOrder() throws IOException {

        String orderId = UUID.randomUUID().toString().substring(0, 32);
        String body = "微信支付测试Demo";
        String ipAddress = "127.0.0.1";

        String preOrderResponse = wxPayService.createOrder(orderId, new BigDecimal("1"), body, ipAddress);

        return preOrderResponse;
    }

    /**
     * 支付回调
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/wx-pay/notify", method = {RequestMethod.POST, RequestMethod.GET})
    public String wxNotify(HttpServletRequest request, HttpServletResponse response) {

        try {
            return wxPayService.callBack(request, response);
        } catch (Exception e) {
            response.setHeader("Content-type", "application/xml");
            return "<xml>\n" +
                    "  <return_code><![CDATA[FAIL]]></return_code>\n" +
                    "  <return_msg><![CDATA[]]></return_msg>\n" +
                    "</xml>";
        }
    }
}
