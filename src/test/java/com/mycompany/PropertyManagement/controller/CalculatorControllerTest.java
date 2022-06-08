package com.mycompany.PropertyManagement.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculatorControllerTest {
    @InjectMocks
    private CalculatorController calculatorController;

    @Test
    @DisplayName("Test Addition Success Scenario")
    void testAddFunction_Success(){
       Double result = calculatorController.add(3.5,3.5,3.5);
       //Expected is 7.0
        //Always perform assertion
        Assertions.assertEquals(7.0,result);
    }

    @Test
    @DisplayName("Test Addition Success Scenario")
    void testAddFunction_Failure(){
        Double result = calculatorController.add(3.0,3.5,3.5);
        //Deliberately give wrong Expected is 7.0
        //Always perform assertion
        Assertions.assertNotEquals(7.0,result);
    }
}
