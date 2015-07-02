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

public class BasicCalculatorClientResult {
  public String result = "";
  public String operation = "";
  public String operand1 = "";
  public String operand2 = "";

  public void setResult(double d) {
    result = (new Double(d)).toString();
  }

  public String getResult() {
    return result;
  }

  public void setOperation(String s) {
    if (s.equals("add")) {
      operation = "+";
    } else if (s.equals("subtract")) {
      operation = "-";
    } else if (s.equals("multiply")) {
      operation = "*";
    } else if (s.equals("divide")) {
      operation = "/";
    }
  }

  public String getOperation() {
    return operation;
  }

  public void setOperand1(double d) {
    operand1  = (new Double(d)).toString();
  }

  public String getOperand1() {
    return operand1;
  }

  public void setOperand2(double d) {
    operand2 = (new Double(d)).toString();
  }

  public String getOperand2() {
    return operand2;
  }

}
