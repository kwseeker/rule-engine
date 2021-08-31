package top.kwseeker.easyrules.rule;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import top.kwseeker.easyrules.Order;

@Rule
public class VipDiscountRule {

    @Condition
    public boolean isVip(@Fact("order") Order order) {
        return order.getCustomer().isVip();
    }

    @Action
    public void vipDiscount(@Fact("order") Order order) {
        order.setVipDiscount(-3);
    }
}
