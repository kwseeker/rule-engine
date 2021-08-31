package top.kwseeker.easyrules;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;

@Data
public class Order implements Cloneable {

    private Customer customer;

    private Integer totalPrice;

    private int loyalCustomerDiscount = 0;
    private int vipDiscount = 0;
    //红包减免(固定减免)
    private int redEnvelopeDiscount = 0;
    //抵用券减免
    private int voucherDiscount = 0;

    public int finalCost() {
        return totalPrice + loyalCustomerDiscount + vipDiscount + redEnvelopeDiscount + voucherDiscount;
    }

    public Order deepClone() {
        return JSON.parseObject(JSONObject.toJSONString(this), this.getClass());
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Customer {
        private String name;
        //是否是老顾客
        private boolean isLoyal;
        private boolean isVip;
        private boolean hasRedEnvelope;
        private LinkedList<Integer> voucherList;
    }
}
