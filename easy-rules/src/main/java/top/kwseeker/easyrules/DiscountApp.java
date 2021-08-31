package top.kwseeker.easyrules;

import com.alibaba.fastjson.JSONObject;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.support.composite.ActivationRuleGroup;
import top.kwseeker.easyrules.rule.LoyalCustomerDiscountRule;
import top.kwseeker.easyrules.rule.RedEnvelopeDiscountRule;
import top.kwseeker.easyrules.rule.VipDiscountRule;
import top.kwseeker.easyrules.rule.VoucherLevelDiscountRule;

import java.util.Arrays;
import java.util.LinkedList;

public class DiscountApp {

    public static void main(String[] args) {
        Order order = new Order();
        LinkedList<Integer> voucherList = new LinkedList<>(Arrays.asList(-2, -3, -4, -5, -6));
        Order.Customer customer = new Order.Customer("Arvin", true, false, true, voucherList);
        order.setCustomer(customer);
        order.setTotalPrice(33);
        Order order1 = order.deepClone();

        Facts facts = new Facts();
        facts.put("order", order);

        Rules rules = new Rules();
        LoyalCustomerDiscountRule loyalCustomerDiscountRule = new LoyalCustomerDiscountRule();
        rules.register(loyalCustomerDiscountRule);
        RedEnvelopeDiscountRule redEnvelopeDiscountRule = new RedEnvelopeDiscountRule();
        rules.register(redEnvelopeDiscountRule);
        VipDiscountRule vipDiscountRule = new VipDiscountRule();
        rules.register(vipDiscountRule);
        //！！！一个规则集中一个规则（Class）只能加入一次
        //复合规则
        ActivationRuleGroup activationRuleGroup = new ActivationRuleGroup();
        //VoucherLevelDiscountRule ruleLevel1 = new VoucherLevelDiscountRule(20, -2);
        //VoucherLevelDiscountRule ruleLevel2 = new VoucherLevelDiscountRule(25, -3);
        VoucherLevelDiscountRule ruleLevel3 = new VoucherLevelDiscountRule(30, -4);
        //VoucherLevelDiscountRule ruleLevel4 = new VoucherLevelDiscountRule(35, -5);
        //VoucherLevelDiscountRule ruleLevel5 = new VoucherLevelDiscountRule(40, -6);
        //activationRuleGroup.addRule(ruleLevel5);
        //activationRuleGroup.addRule(ruleLevel4);
        activationRuleGroup.addRule(ruleLevel3);
        //activationRuleGroup.addRule(ruleLevel2);
        //activationRuleGroup.addRule(ruleLevel1);
        rules.register(activationRuleGroup);

        RulesEngine rulesEngine = new DefaultRulesEngine();

        rulesEngine.fire(rules, facts);
        System.out.println("after discount: " + JSONObject.toJSONString(order));
        System.out.println("calculate final price: " + order.finalCost());

        //删除一个规则
        //rules.unregister(redEnvelopeDiscountRule);
        //facts = new Facts();
        //facts.put("order", order1);
        //rulesEngine.fire(rules, facts);
        //System.out.println("after discount: " + JSONObject.toJSONString(order1));
        //System.out.println("calculate final price: " + order1.finalCost());
    }
}
