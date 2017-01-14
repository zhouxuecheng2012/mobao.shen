package com.mo.bao;

import java.math.BigDecimal;
/**
 * Created by hadoop on 2016/12/4.
 */
public class BigDecimalTest {

    public static void main(String args[]) {

        BigDecimal amount = new BigDecimal(55000.00);
        BigDecimal stagingRage = new BigDecimal(0.070000);

        Integer stageNumber = 12;

        BigDecimal fee  = amount.multiply(stagingRage)
                .setScale(10, BigDecimal.ROUND_HALF_UP);

        System.out.println("费用:"+fee);

        /** 每期本金 */
        BigDecimal perCapital = amount.divide(new BigDecimal(stageNumber), 2, BigDecimal.ROUND_HALF_UP);
        System.out.println("每期本金:"+perCapital);
        /** 每期手续费 */
        BigDecimal perFee = amount.divide(new BigDecimal(stageNumber), 2, BigDecimal.ROUND_HALF_UP);
        System.out.println("每期手续费:"+perFee);
        /** 逾期罚息费率 */
        BigDecimal overdueRate = new BigDecimal(0.000500);
        
    }

}
