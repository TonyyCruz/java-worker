package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {
  public static void main(String[] args) throws ParseException {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    Department department;
    Worker worker;

    System.out.print("Enter department name: ");
    department = new Department(sc.next());

    System.out.println("Enter worker data.");
    System.out.print("Name: ");
    String name = sc.next();

    System.out.print("Level: ");
    String level = sc.next();

    System.out.print("Base salary: ");
    Double salary = sc.nextDouble();

    worker = new Worker(name, WorkerLevel.valueOf(level), salary, department);

    System.out.print("How many contracts to this worker: ");
    Integer contracts = sc.nextInt();

    for (int i = 1; i <= contracts; i += 1) {
      System.out.printf("Enter contract #%d data:%n", i);

      System.out.print("Date (DD/MM/YYYY): ");
      // DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      Date date = format.parse(sc.next());


      System.out.print("Value per hour: ");
      Double valuePerHour = sc.nextDouble();

      System.out.print("Duration (hours): ");
      Integer hours = sc.nextInt();

      worker.addContract(new HourContract(date, valuePerHour, hours));
    }

    System.out.print("Enter month and year to calculate income (MM/YYYY): ");
    String dateString = sc.next();
    int month = Integer.parseInt(dateString.substring(0, 2));
    int year = Integer.parseInt(dateString.substring(3));

    System.out.println("Name: " + worker.getName());
    System.out.println("Department: " + worker.getDepartment().getName());
    System.out.println(
        "Income for " + dateString + ": " + String.format("%.2f", worker.income(year, month)));

    sc.close();
  }
}
