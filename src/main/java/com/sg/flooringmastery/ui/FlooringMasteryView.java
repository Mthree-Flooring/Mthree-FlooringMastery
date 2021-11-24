package com.sg.flooringmastery.ui;

import com.sg.flooringmastery.dto.Order;
import java.math.BigDecimal;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author raymondtam
 */
public class FlooringMasteryView {

    private UserIO io;
    
    public FlooringMasteryView(UserIO io) {
    this.io = io;
}
    public void displayDisplayStudentBanner () {
    io.print("=== Display Student ===");
    
}
    
    public void displayErrorMessage(String errorMsg) {
    io.print("=== ERROR ===");
    io.print(errorMsg);
}

public String getStudentIdChoice() {
    return io.readString("Please enter the Student ID.");
}

public void displayStudent(Order student) {
    if (student != null) {
        io.print(student.getStudentId());
        io.print(student.getFirstName() + " " + student.getLastName());
        io.print(student.getCohort());
        io.print("");
    } else {
        io.print("No such student.");
    }
    io.readString("Please hit enter to continue.");
}

public void displayRemoveStudentBanner () {
    io.print("=== Remove Student ===");
}

public void displayRemoveResult(Order studentRecord) {
    if(studentRecord != null){
      io.print("Student successfully removed.");
    }else{
      io.print("No such student.");
    }
    io.readString("Please hit enter to continue.");
}
    
    public Order getNewStudentInfo() {
    String studentId = io.readString("Please enter Student ID");
    String firstName = io.readString("Please enter First Name");
    String lastName = io.readString("Please enter Last Name");
    String cohort = io.readString("Please enter Cohort");
    Order currentStudent = new Order(studentId);
    currentStudent.setFirstName(firstName);
    currentStudent.setLastName(lastName);
    currentStudent.setCohort(cohort);
    return currentStudent;
}
    
  public void displayExitBanner() {
    io.print("Good Bye!!!");
}

public void displayUnknownCommandBanner() {
    io.print("Unknown Command!!!");
}
    public void displayCreateStudentBanner() {
    io.print("=== Create Student ===");
}
    
    public void displayCreateSuccessBanner() {
    io.readString(
            "Student successfully created.  Please hit enter to continue");
}
    
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Students");
        io.print("2. Create New Student");
        io.print("3. View a Student");
        io.print("4. Remove a Student");
        io.print("5. Exit");

        return io.readInt("Please select from the above choices.", 1, 5);
    }
    
   
    
    public void displayStudentList(List<Order> studentList) {
    for (Order currentStudent : studentList) {
        String studentInfo = String.format("#%s : %s %s",
              currentStudent.getStudentId(),
              currentStudent.getFirstName(),
              currentStudent.getLastName());
        io.print(studentInfo);
    }
    io.readString("Please hit enter to continue.");
}

    public void displayDisplayAllBanner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void displayCurrentMoneyValue(BigDecimal CurrentMoney){
        io.print("Current Balance: "+ CurrentMoney);
    }

    public void displayRemoveSuccessBanner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
