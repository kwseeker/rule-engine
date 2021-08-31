package top.kwseeker.easyrules.rule;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import top.kwseeker.easyrules.Order;

@Rule
public class VoucherLevelDiscountRule {

    private int levelValue;
    private int discount;

    public VoucherLevelDiscountRule() {
        new VoucherLevelDiscountRule(0, 0);
    }

    public VoucherLevelDiscountRule(int levelValue, int discount) {
        this.levelValue = levelValue;
        this.discount = discount;
    }

    @Condition
    public boolean match(@Fact("order") Order order) {
        boolean match = order.getTotalPrice() > levelValue;
        return match && order.getCustomer().getVoucherList().contains(discount);
    }

    @Action
    public void vipDiscount(@Fact("order") Order order) {
        order.setVoucherDiscount(discount);
        order.getCustomer().getVoucherList().remove(discount);
    }
}
