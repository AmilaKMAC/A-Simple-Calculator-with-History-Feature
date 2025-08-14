# **A Simple Calculator with History Feature**

## **Overview**
`calc_history.py` is a command-line calculator that performs basic arithmetic operations and keeps a history of past calculations. It allows users to perform addition, subtraction, multiplication, division, exponentiation, and remainder operations. The program also includes a history feature to review previous calculations.

## **Features**
- **Basic Arithmetic Operations:** Supports addition (+), subtraction (-), multiplication (*), division (/), exponentiation (^), and remainder (%).
- **Calculation History:** Stores past calculations and allows users to view them.
- **User-friendly Input Handling:** Detects invalid inputs and prompts users to enter valid numbers.
- **Special Commands:**
  - `?` → View calculation history.
  - `#` → Terminate the program.
  - `$` → Reset the calculator.

## **How It Works**
1. The user selects an operation from the menu.
2. The program asks for two numerical inputs.
3. The selected operation is performed, and the result is displayed.
4. Each valid calculation is stored in the history.
5. The user can view past calculations by entering `?`.
6. The program continues running until the user enters `#` to terminate.
