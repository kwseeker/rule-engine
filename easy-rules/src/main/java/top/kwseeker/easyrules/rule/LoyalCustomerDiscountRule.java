package top.kwseeker.easyrules.rule;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import top.kwseeker.easyrules.Order;

/**
 * 老用户津贴优惠
 */
@Rule
public class LoyalCustomerDiscountRule {

    @Condition
    public boolean isLoyalCustomer(@Fact("order") Order order) {
        return order.getCustomer().isLoyal();
    }

    @Action
    public void loyalDiscount(@Fact("order") Order order) {
        order.setLoyalCustomerDiscount(-1);
    }
}
