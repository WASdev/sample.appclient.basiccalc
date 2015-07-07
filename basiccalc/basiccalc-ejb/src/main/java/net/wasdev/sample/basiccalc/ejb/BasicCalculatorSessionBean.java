package net.wasdev.sample.basiccalc.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class BasicCalculatorSessionBean
 */
@Stateless
@Remote(BasicCalculatorSessionBeanRemote.class)
public class BasicCalculatorSessionBean implements BasicCalculatorSessionBeanRemote {

    /**
     * Default constructor.
     */
    public BasicCalculatorSessionBean() {
    }

    @Override
    public double makeSum(double operand1, double operand2) {
      return operand1 + operand2;
    }

    @Override
    public double makeDifference(double operand1, double operand2) {
      return operand1 - operand2;
    }

    @Override
    public double makeProduct(double operand1, double operand2) {
      return operand1 * operand2;
    }

    @Override
    public double makeQuotient(double operand1, double operand2) {
      return operand1 / operand2;
    }

}
