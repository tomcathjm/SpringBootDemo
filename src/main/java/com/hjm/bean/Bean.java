package com.hjm.bean;

public class Bean {

    String username;
    Double salary;

    public Bean(String username, Double salary) {
        this.username = username;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "username='" + username + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }
}
