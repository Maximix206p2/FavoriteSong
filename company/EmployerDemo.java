package com.company;

import java.lang.annotation.*;

public class EmployerDemo {
    public static void main(String[] args) {
        EmployeeProcessor.process();
        EmployeeRepProcessor.process();
    }
}

@Company
class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void getDetails(){
        System.out.println("Employee Id: " + id);
        System.out.println("Employee Name: " + name);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class Manager extends Employee{
    public Manager(int id, String name) {
        super(id, name);
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited //работает на все дочерние классы
@interface Company{
    String city() default "Vitebsk";
    String name() default "Step";
}

class EmployeeProcessor{
    public static void process(){
        Employee employee = new Manager(1, "John Doe");
        System.out.println(employee.toString());

        Annotation annotation = employee.getClass().getAnnotation(Company.class);
        Company company = (Company) annotation;
        System.out.println(company.city()+" "+company.name());
    }
}

@CompanyRep
@CompanyRep(name="Epam", city="Minsk")
class EmployeeRep extends Employee{
    public EmployeeRep(int id, String name) {
        super(id, name);
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(Companies.class)
@interface CompanyRep{
    String city() default "Vitebsk";
    String name() default "Step";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Companies{
    CompanyRep[] value() default {};
}
class EmployeeRepProcessor{
    public static void process(){
        Employee employee = new EmployeeRep(1, "John Doe");
        employee.getDetails();
        CompanyRep[] companies = EmployeeRep.class
                .getAnnotationsByType(CompanyRep.class);
        for (CompanyRep repeatableCompany : companies) {
            System.out.println("Name: " + repeatableCompany.name());
            System.out.println("City: " + repeatableCompany.city());
        }
    }
}

