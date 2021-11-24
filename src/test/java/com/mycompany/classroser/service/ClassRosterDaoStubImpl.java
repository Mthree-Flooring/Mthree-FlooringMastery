/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classroser.service;

import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dto.Order;
import java.util.ArrayList;
import java.util.List;
import com.sg.flooringmastery.dao.FlooringMasteryDao;

/**
 *
 * @author raymondtam
 */
public class ClassRosterDaoStubImpl implements FlooringMasteryDao {
    public Order onlyStudent;
    
    public ClassRosterDaoStubImpl() {
        onlyStudent = new Order("0001");
        onlyStudent.setFirstName("Ada");
        onlyStudent.setLastName("Lovelace");
        onlyStudent.setCohort("Java-May-1845");
    }
    
    
    public ClassRosterDaoStubImpl(Order testStudent){
         this.onlyStudent = testStudent;
     }

    
    
    @Override
     public Order addStudent(String studentId, Order student)
                  throws FlooringMasteryPersistenceException {
        if (studentId.equals(onlyStudent.getStudentId())) {
            return onlyStudent;
        } else {
            return null;
        }
    }

    @Override
    public List<Order> getAllStudents()
                 throws FlooringMasteryPersistenceException {
        List<Order> studentList = new ArrayList<>();
        studentList.add(onlyStudent);
        return studentList;
    }

    @Override
    public Order getStudent(String studentId)
                throws FlooringMasteryPersistenceException {
        if (studentId.equals(onlyStudent.getStudentId())) {
            return onlyStudent;
        } else {
            return null;
        }       
    }

    @Override
    public Order removeStudent(String studentId)
                throws FlooringMasteryPersistenceException {
        if (studentId.equals(onlyStudent.getStudentId())) {
            return onlyStudent;
        } else {
            return null;
        }
    } 
    
}
