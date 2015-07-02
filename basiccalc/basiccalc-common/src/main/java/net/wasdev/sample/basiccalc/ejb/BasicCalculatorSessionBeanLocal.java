package net.wasdev.sample.basiccalc.ejb;

/**
 * Local interface for the BasicCalculator stateless session bean.
 */
public interface BasicCalculatorSessionBeanLocal {
  /**
   * Perform the addition operation on the operands and return the result
   *
   * @return The result of adding operand1 and operand2
   * @param operand1 A number to perform this mathematical operation on
   * @param operand2 Another number to perform this mathematical operation on
   */
  public double makeSum (double operand1, double operand2);

  /**
   * Perform the subtraction operation on the operands and return the result
   *
   * @return The result of subtracting operand1 and operand2
   * @param operand1 A number to perform this mathematical operation on
   * @param operand2 Another number to perform this mathematical operation on
   */
  public double makeDifference (double operand1, double operand2);

  /**
   * Perform the multiplication operation on the operands and return the result
   *
   * @return The result of multiplying operand1 and operand2
   * @param operand1 A number to perform this mathematical operation on
   * @param operand2 Another number to perform this mathematical operation on
   */
  public double makeProduct (double operand1, double operand2);

  /**
   * Perform the division operation on the operands and return the result
   *
   * @return The result of dividing operand1 and operand2
   * @param operand1 A number to perform this mathematical operation on
   * @param operand2 Another number to perform this mathematical operation on
   */
  public double makeQuotient (double operand1, double operand2);

}
