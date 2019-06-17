package com.pattern.Behavioral.template;

/**
 *
 * @formatter:off
 * 场景：
 *    客户到银行办理业务： 1：取号排队 2：办理具体现金 理财业务 3：给银行工作人员评分
 *
 * 核心：
 * 		处理某个流程的代码都已经具备，但是某个节点的代码暂时不能确定。因此，我们采用工程方法模式，将这个节点的代码 转移给子类完成。
 *   处理步骤父类中定义好，具体实现延迟到子类中定义。
 *
 * 案例：java当中的线程采用的就是模板方法
 *@formatter:on
 * @author jhons
 * @since 2019/5/31 11:27
 */
public class TemplateClient {

    public static void main(String[] args) {

        // 调用方式一
        // BankTemplateMethod bankTemplateMethod = new TakeMoney();
        // bankTemplateMethod.process();
        // 采用匿名内部类
        BankTemplateMethod bankTemplateMethod = new BankTemplateMethod() {
            @Override
            protected void transact() {
                System.out.println("我要购买理财");
            }
        };
        bankTemplateMethod.process();
    }
}

class TakeMoney extends BankTemplateMethod {

    @Override
    public void transact() {
        System.out.println("我要取钱");
    }
}
