package top.kwseeker.easyrules;

import org.junit.Test;
import top.kwseeker.easyrules.rule.VoucherLevelDiscountRule;

import java.util.TreeSet;

public class TreeSetTest {

    /**
     * 测试时发现同Class类型的多个规则无法加入到 ActivationRuleGroup，只保存有第一个加入的
     * Rule Class 都会生成一个代理类：RuleProxy.asRule(rule)
     */
    @Test
    public void testTreeSetAdd() {
        VoucherLevelDiscountRule rule1 = new VoucherLevelDiscountRule(40, -6);
        VoucherLevelDiscountRule rule2 = new VoucherLevelDiscountRule(35, -5);
        TreeSet<VoucherLevelDiscountRule> treeSet = new TreeSet<>();

        treeSet.add(rule1);
        treeSet.add(rule2);
    }
}
