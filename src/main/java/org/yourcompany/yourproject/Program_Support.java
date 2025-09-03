package org.yourcompany.yourproject;

import java.util.Scanner;

public class Program_Support
{
    private int Sum_Income;
    private int Sum_Expenses;
    Scanner scanner = new Scanner(System.in);
    public void Start_Support()
    {
        String input = "";

        while(!input.equals("end"))
        {
            input = Operation(input);
        }
    }

     private String Operation(String operation)
    {
        System.out.println("""
                              Выберите операцию и введите её номер:
                              1. Добавить новый доход
                              2. Добавить новый расход
                              3. Выбрать систему налогообложения
                              """);

        operation = scanner.nextLine();
        switch (operation) {
            case "1" ->
                 Calculate_Income();
            case "2" ->
                 Calculate_Expenses();
            case "3" ->
                 Enter_System();
            case "end" ->
                 System.err.println("Программа завершена");
            default->
                System.out.println("Неизвестная операция");
        }
        
        return operation;
    }

    private void Calculate_Income()
    {
       int income;
       System.out.println("Введите доход: ");
       income = scanner.nextInt();
       scanner.nextLine();
       Sum_Income = Sum_Income+income;
    }

    private void Calculate_Expenses()
    {
       int expenses;
       System.out.println("Введите расход: ");
       expenses = scanner.nextInt();
       scanner.nextLine();
       Sum_Expenses = Sum_Expenses+expenses;
    }

    private void Enter_System()
    {
    int USN_Income = Math.max(0, Sum_Income * 6 / 100);
    int taxableBase = Math.max(0, Sum_Income - Sum_Expenses);
    int USN_Income_Minus = taxableBase * 15 / 100;
    int economy = Math.abs(USN_Income - USN_Income_Minus);
    if (USN_Income > USN_Income_Minus) 
    {
        System.out.println("Мы советуем вам УСН доходы минус расходы");
        System.out.println("Ваш налог составит: " + USN_Income_Minus + " рублей");
        System.out.println("Налог на другой системе: " + USN_Income + " рублей");
        System.out.println("Экономия: " + economy + " рублей");
    } 
    else if (USN_Income < USN_Income_Minus) 
    {
        System.out.println("Мы советуем вам УСН доходы");
        System.out.println("Ваш налог составит: " + USN_Income + " рублей");
        System.out.println("Налог на другой системе: " + USN_Income_Minus + " рублей");
        System.out.println("Экономия: " + economy + " рублей");
    } 
    else 
    {
        System.out.println("Обе системы дают одинаковый налог: " + USN_Income + " рублей");
    }
    
    System.out.println("Программа завершена");

    }
}