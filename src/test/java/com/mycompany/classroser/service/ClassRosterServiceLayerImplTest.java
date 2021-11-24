/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.classroser.service;

import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dto.Order;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
//import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sg.flooringmastery.dao.FlooringMasteryAuditDao;
import com.sg.flooringmastery.dao.FlooringMasteryDao;
import com.mycompany.flooringmastery.service.FlooringMasteryServiceLayer;

/**
 *
 * @author raymondtam
 */
public class ClassRosterServiceLayerImplTest {

    private FlooringMasteryServiceLayer service;

    public ClassRosterServiceLayerImplTest() {
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("applicationContext.xml");
    service = 
        ctx.getBean("serviceLayer", FlooringMasteryServiceLayer.class);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
//
//    @Test
//    public void testCreateValidStudent() {
//        // ARRANGE
//        Student student = new Student("0002");
//        student.setFirstName("Charles");
//        student.setLastName("Babbage");
//        student.setCohort(".NET-May-1845");
//        // ACT
//        try {
//            service.createStudent(student);
//        } catch (ClassRosterDuplicateIdException
//                | ClassRosterDataValidationException
//                | FlooringMasteryPersistenceException e) {
//            // ASSERT
//            fail("Student was valid. No exception should have been thrown.");
//        }
//    }
//
//    @Test
//    public void testCreateDuplicateIdStudent() {
//        // ARRANGE
//        Student student = new Student("0001");
//        student.setFirstName("Charles");
//        student.setLastName("Babbage");
//        student.setCohort(".NET-May-1845");
//
//        // ACT
//        try {
//            service.createStudent(student);
//            fail("Expected DupeId Exception was not thrown.");
//        } catch (ClassRosterDataValidationException
//                | FlooringMasteryPersistenceException e) {
//            // ASSERT
//            fail("Incorrect exception was thrown.");
//        } catch (ClassRosterDuplicateIdException e) {
//            return;
//        }
//    }
//
//    @Test
//    public void testCreateStudentInvalidData() throws Exception {
//        // ARRANGE
//        Student student = new Student("0002");
//        student.setFirstName("");
//        student.setLastName("Babbage");
//        student.setCohort(".NET-May-1845");
//
//        // ACT
//        try {
//            service.createStudent(student);
//            fail("Expected ValidationException was not thrown.");
//        } catch (ClassRosterDuplicateIdException
//                | FlooringMasteryPersistenceException e) {
//            // ASSERT
//            fail("Incorrect exception was thrown.");
//        } catch (ClassRosterDataValidationException e) {
//            return;
//        }
//    }
//
//    @Test
//    public void testGetAllStudents() throws Exception {
//        // ARRANGE
//        Student testClone = new Student("0001");
//        testClone.setFirstName("Ada");
//        testClone.setLastName("Lovelace");
//        testClone.setCohort("Java-May-1845");
//
//        // ACT & ASSERT
//        assertEquals(1, service.getAllStudents().size(),
//                "Should only have one student.");
//        assertTrue(service.getAllStudents().contains(testClone),
//                "The one student should be Ada.");
//    }
//
//    @Test
//    public void testGetStudent() throws Exception {
//
//        Student testClone = new Student("0001");
//        testClone.setFirstName("Ada");
//        testClone.setLastName("Lovelace");
//        testClone.setCohort("Java-May-1845");
//
//  
//        Student shouldBeAda = service.getStudent("0001");
//        assertNotNull(shouldBeAda, "Getting 0001 should be not null.");
//        assertEquals(testClone, shouldBeAda,
//                "Student stored under 0001 should be Ada.");
//
//        Student shouldBeNull = service.getStudent("0042");
//        assertNull(shouldBeNull, "Getting 0042 should be null.");
//
//    }
//
//    @Test
//    public void testRemoveStudent() throws Exception {
//
//        Student testClone = new Student("0001");
//        testClone.setFirstName("Ada");
//        testClone.setLastName("Lovelace");
//        testClone.setCohort("Java-May-1845");
//
//        
//        Student shouldBeAda = service.removeStudent("0001");
//        assertNotNull(shouldBeAda, "Removing 0001 should be not null.");
//        assertEquals(testClone, shouldBeAda, "Student removed from 0001 should be Ada.");
//
//        Student shouldBeNull = service.removeStudent("0042");
//        assertNull(shouldBeNull, "Removing 0042 should be null.");
//
//    }
    
    
}
