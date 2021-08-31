# 规则引擎 Rule-Engine

## 1 简介

### 实际案例

公司为了吸引用户搞活动。

１）按订单金额送相应的积分

２）修改各积分金额获取的订单金额阀值

３）过了两天，要求新加入了两个等级

４）过了两天，又要求加入送优惠券逻辑

５）......

如果按常规实现，每次都要改代码，然后重新部署上线，且随着规则不断变多，代码越来越难以理解和维护，且这种逻辑本身也很难抽象出数据模型。

### 什么是规则引擎？

规则引擎起源于基于规则的专家系统（基于规则的专家系统是专家系统中的一个分支，专家系统属于人工智能的范畴，模仿人类的推理方式，使用试探性的方法进行推理，并使用人类能理解的术语解释和证明他的推理结论）。

规则引擎将业务决策从应用程序代码中<u>分离</u>出来，存放在中心数据库或其他统一的地方，可以在运行时可以<u>动态地管理和修改</u>。使用预定义的语义模块编写业务决策的组件，它接受数据输入，解释业务规则，并根据业务规则做出业务决策。 

**特点**：

+ 决策逻辑和数据分离

+ 统一管理可动态修改（知识集中化、高可拓展性）

  对于知识集中化可以理解为不同业务的规则都可以放到同一个规则引擎中进行管理。

+ 接受输入，自动解释执行，输出结果

+ 声明式编程

### 使用场景

业务规则复杂，且随着业务发展可能有多次业务规则变更（如规则增加、删除、参数调整等等）的决策逻辑。

### 理论支持

**Rete算法**

定义了一堆规则后，但是执行时先执行哪个再执行哪个呢，涉及很多匹配、选择、执行的逻辑。Rete算法就是处理这种问题的。其核心思想是将分离的匹配项根据内容动态地构造匹配树，以达到显著降低计算量的效果。

**规则引擎组件通常包含下面几种API**

- 加载和卸载规则集的API
- 数据操作的API
- 引擎执行的API

**使用规则引擎基本遵循以下5个典型的步骤**：

1. 创建规则引擎对象；
2. 向引擎中加载规则集或更换规则集；
3. 向引擎提交需要被规则集处理的数据对象集合；
4. 命令引擎执行;
5. 导出引擎执行结果，从引擎中撤出处理过的数据。

### 使用方式

参考这里[別再說你不懂規則引擎了！](https://www.gushiciku.cn/pl/gYJB/zh-tw)，当规则变化之后基本只需要修改配置，然后更新下线上配置就可以了。



## 2 方案

好多大公司都有实现自己内部的规则引擎方案，或用现成的框架做二次开发。

### [Drools](https://www.drools.org/)

### [Aviator](https://code.google.com/archive/p/aviator/)

### RuleBook

### [EasyRules](https://github.com/j-easy/easy-rules)

### [Urule](http://www.bstek.com/resources/doc/)



## 3 案例

### EasyRules Demo

