/*******************************************************************************
 * Copyright (c) 2015 IBM Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package net.wasdev.sample.basiccalc.client;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import net.wasdev.sample.basiccalc.ejb.BasicCalculatorSessionBeanRemote;

public class BasicCalculatorClient {

	public static void main(String[] args) throws Exception {
    BasicCalculatorClient basiccalc = new BasicCalculatorClient();
    basiccalc.doCalculation(args);
	}

  /**
   * Handles all of the user-interaction for the BasicCalculatorClient.
   * This method takes an array of strings in the order {<Operation>,<Operand1>,<Operand2>}.
   * The calculation result is returned in a BasicCalculatorClientResult object to be displayed to the user.
   * @throws Exception
   */
  public void doCalculation(String[] args) throws Exception {
    String operation;
    double operand1;
    double operand2;

    // Get the number format for the default local.
    NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());

    // Validate the arguments.
    // Arguments are in the form:  Operation, Operand1, Operand2.
    if (args.length != 3) {
      printUsageSyntax();
      return;
    }

    operation = args[0];
    try {
      // Retrieve operands respective of the locale
      operand1 = numberFormat.parse(args[1]).doubleValue();
      operand2 = numberFormat.parse(args[2]).doubleValue();
    } catch(ParseException pe) {
      printUsageSyntax("Parse exception on number input. Please enter a valid number.");
      return;
    } catch(NumberFormatException nfe) {
      printUsageSyntax("Invalid number entered. Please enter a valid number.");
      return;
    }

    BasicCalculatorSessionBeanRemote basicCalc = getBasicCalculatorRemoteEJB();
    BasicCalculatorClientResult calcResult = calculate(basicCalc,operation,(double)operand1,(double)operand2);
    printMessage("Result: " + numberFormat.format( new Double (calcResult.getOperand1())) + calcResult.getOperation() + numberFormat.format(new Double(calcResult.getOperand2())) + " = " + numberFormat.format(new Double (calcResult.getResult())) );
  }

  private void printUsageSyntax() {
      printUsageSyntax(null);
  }

  private void printUsageSyntax(String message) {
      if(message == null) {
          message = "Incorrect syntax.";
      }
      printMessage(message);
      printMessage("  Correct syntax: <Launch Arguments> <Operation> Operand1 Operand2");
      printMessage("     <Operation>: add | subtract | multiply | divide");
      printMessage("  Example: client basiccalc basiccalc.ear -- add 2 3");
  }

  private void printMessage(String message) {
      System.out.println(message);
  }

  private BasicCalculatorSessionBeanRemote getBasicCalculatorRemoteEJB() throws NamingException {
    Context context = new InitialContext();
    Object obj = context.lookup("java:global/basiccalc-ear/basiccalc-ejb/BasicCalculatorSessionBeanRemote");
    return (BasicCalculatorSessionBeanRemote)obj;
  }

  private BasicCalculatorClientResult calculate(BasicCalculatorSessionBeanRemote basicCalc, String operation, double operand1, double operand2) throws Exception {
    double result = 0;

    if (operation.equals("add")) {
      result = basicCalc.makeSum(operand1, operand2);
    } else if (operation.equals("subtract")) {
      result = basicCalc.makeDifference(operand1, operand2);
    } else if (operation.equals("multiply")) {
      result = basicCalc.makeProduct(operand1, operand2);
    } else if (operation.equals("divide")) {
      result = basicCalc.makeQuotient(operand1, operand2);
    } else {
      throw new Exception("Invalid operation: " + operation);
    }

    BasicCalculatorClientResult calcResult = new BasicCalculatorClientResult();
    calcResult.setResult(result);
    calcResult.setOperation(operation);
    calcResult.setOperand1(operand1);
    calcResult.setOperand2(operand2);
    return calcResult;
  }

}
