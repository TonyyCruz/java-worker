package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import entities.enums.WorkerLevel;

public class Worker {
  private String name;
  private WorkerLevel level;
  private Double salary;

  private Department department;
  private List<HourContract> contracts = new ArrayList<HourContract>();

  public Worker() {}

  public Worker(String name, WorkerLevel level, Double salary, Department department) {
    this.name = name;
    this.level = level;
    this.salary = salary;
    this.department = department;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public WorkerLevel getLevel() {
    return level;
  }

  public void setLevel(WorkerLevel level) {
    this.level = level;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public List<HourContract> getContracts() {
    return contracts;
  }

  @Override
  public String toString() {
    return "Worker [name=" + name + ", level=" + level + ", salary=" + salary + "]";
  }

  public void addContract(HourContract contract) {
    this.contracts.add(contract);
  }

  public void removeContract(HourContract contract) {
    this.contracts.remove(contract);
  }

  public Double income(Integer year, Integer month) {
    Double totalPayment = salary;
    Calendar cal = Calendar.getInstance();
    for (HourContract x : contracts) {
      cal.setTime(x.getDate());
      Integer y = cal.get(Calendar.YEAR);
      Integer m = 1 + cal.get(Calendar.MONTH);

      if (y == year && m == month) {
        totalPayment += x.totalValue();
      }
    }

    return totalPayment;
  }
}
