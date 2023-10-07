package springMVC;

import jakarta.validation.constraints.*;
import springMVC.validation.Email;

import java.util.HashMap;
import java.util.Map;

public class Employee {
    @Size(min = 2, message = "Имя должно содержать минимум 2 символа")
    private String name;
    @NotBlank(message = "Обязательно к заполнению")
    private String surName;
    @Min(value = 500,message = "Должно быть не меньше 500")
    @Max(value = 1500, message = "Не должно превышать 1500")
    private int salary;

    private String department;
    @NotBlank(message = "Должно быть заполнено")
    @Pattern(regexp = "\\d{3}-\\d{2}-\\d{2}",message = "Должно иметь следующуюю форму: 555-33-55")
    private String phoneNumber;
    @Email
    private String email;

    private String car;

    private String[] languages;

    private Map<String, String> departmentsList;

    private Map<String, String> carList;

    private Map<String ,String> languagesList;

    public Employee() {
        departmentsList = new HashMap<>();
        departmentsList.put("IT", "Information Technologies");
        departmentsList.put("HR", "Human resources");
        departmentsList.put("SALES", "Sales");

        carList = new HashMap<>();
        carList.put("Mercedes-Benz", "Mercedes-Benz");
        carList.put("Audi", "Audi");
        carList.put("BMW", "BMW");

        languagesList = new HashMap<>();
        languagesList.put("French","Fr");
        languagesList.put("English","En");
        languagesList.put("Deutsch","De");

    }



    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public Map<String, String> getCarList() {
        return carList;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public Map<String, String> getLanguagesList() {
        return languagesList;
    }

    public void setLanguagesList(Map<String, String> languagesList) {
        this.languagesList = languagesList;
    }

    public void setCarList(Map<String, String> carList) {
        this.carList = carList;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Map<String, String> getDepartmentsList() {
        return departmentsList;
    }

    public void setDepartmentsList(Map<String, String> departmentsList) {
        this.departmentsList = departmentsList;
    }
}
