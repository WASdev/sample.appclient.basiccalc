package net.wasdev.sample.basiccalc.ejb;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class BasicCalculatorSessionBean
 */
@Stateless(mappedName = "BasicCalculator")
@Local(BasicCalculatorSessionBeanLocal.class)
@Remote(BasicCalculatorSessionBeanRemote.class)
@LocalBean
public class BasicCalculatorSessionBean implements BasicCalculatorSessionBeanRemote, BasicCalculatorSessionBeanLocal {

    /**
     * Default constructor.
     */
    public BasicCalculatorSessionBean() {
        // TODO Auto-generated constructor stub
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
