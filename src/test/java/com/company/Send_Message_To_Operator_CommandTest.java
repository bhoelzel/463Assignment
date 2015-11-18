/*******************************************************************************************************
*       UNIT - Send_Message_To_Operator_Command
*       Description of test execution
*       First execution step: constructor (Positive path) 
*       Then test Lowest Unit Functions (getters, setters)  (Positive/Negative) ie (Concept of tests)
*       Then continue constructor (negative path)  
*******************************************************************************************************/
package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;

public class Send_Message_To_Operator_CommandTest {

    Send_Message_To_Operator_Command test_object;
    Response_Unit response_unit_object;


    @Before
    public void setUp() throws Exception{
        if (Response_Unit_Manager.Response_Unit_Exists("1") == false) {
            response_unit_object = new Response_Unit("1", new Location(90, 90));
            Response_Unit_Manager.Add_Response_Unit(response_unit_object);
        }
    }
    // Testing Constructor Positive Path
	/*
	Test Case ID: 9.01
	Purpose: “Test Send_Message_To_Operator_Command constructor with valid Unit_ID and valid Message"
	Preconditions: A unit with the ID 10 exists within the system.
	Expected Result: A new Send_Message_To_Operator_Command is constructed.
	*/
    @Test
    public void testConstructor(){
        test_object = new Send_Message_To_Operator_Command("1", "Test");

    }

    // Testing Execute Function
    /*
	Test Case ID: 9.02
	Purpose: �Testing if Execute successfully completes�
	Preconditions: Command exists with Unit_ID set to a unit ID exists and a valid message"
	Expected Result: Execute completes without error.
	*/
    @Test
    public void testSuccessfulExecute() throws Exception{
        test_object = new Send_Message_To_Operator_Command("1", "Test");
        File test_file = new File("test_file.txt");
        FileOutputStream test_file_output = new FileOutputStream(test_file, false);
        FileInputStream test_file_input = new FileInputStream(test_file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(test_file_input));
        System.setOut(new PrintStream(test_file_output));
        test_object.Execute();
        Assert.assertEquals(reader.readLine(), "Message from 1 reads Test");
        test_file_input.close();
        test_file_output.close();
    }

	/*
	Test Case ID: 9.03
	Purpose: “Testing if Null_Unit_ID_Exception is thrown when a null ID is provided”
	Preconditions: Command exists with Unit_ID set to null
	Expected Result: Null_Unit_ID_Exception is thrown.
	*/
    @Test
    public void testNullUnitIDException() {
        test_object = new Send_Message_To_Operator_Command(null, "Test");
        try {
            test_object.Execute();
            Assert.fail("Excepted Null_Unit_ID_Exception");
        } catch (Null_Unit_ID_Exception e) {
            // Passed
        }
    }

    // Testing Constructor Negative Path
	/*
	Test Case ID: 9.04
	Purpose: “Testing if Send_Message_To_Operator_Command is passed an abnormal Unit_ID it does not crash”
	Preconditions: The value passed to Unit_ID is the String "123abc###".
	Expected Result: A new Send_Message_To_Operator_Command is not constructed and the system does not crash.
	*/
    @Test
    public void testUnusualUnitID() throws Exception{
        test_object = new Send_Message_To_Operator_Command("123abc###", "Test");
        try {
            test_object.Execute();
            Assert.fail("Excepted Null_Unit_ID_Exception");
        } catch (Null_Unit_ID_Exception e) {
            // Passed
        }
    }

	/*
	Test Case ID: 9.05
	Purpose: “Testing if Send_Message_To_Operator_Command is passed the String "これはテストです" to Message's value the system does not crash and succesfully creates the command"
	Preconditions: The value passed to Message is the value "これはテストです".
	Expected Result: A new Send_Message_To_Operator_Command is constructed.
	*/
    @Test
    public void testUnusualMessage() throws Exception {
        test_object = new Send_Message_To_Operator_Command("1", "これはテストです");
        File test_file = new File("test_file.txt");
        FileOutputStream test_file_output = new FileOutputStream(test_file, false);
        FileInputStream test_file_input = new FileInputStream(test_file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(test_file_input));
        System.setOut(new PrintStream(test_file_output));
        test_object.Execute();
        Assert.assertEquals(reader.readLine(), "Message from 1 reads これはテストです");
        test_file_input.close();
        test_file_output.close();
    }

    /*
	Test Case ID: 9.06
	Purpose: “Testing if Send_Message_To_Operator_Command is passed an integer as the Unit_ID, it does not crash”
	Preconditions: A unit with the ID 10 exists within the system. Send_Message_To_Operator is passed the value 10.
	Expected Result: A new Send_Message_To_Operator_Command is not constructed and the system does not crash.
	*/
    /* Note: Test failed to compile, This scenario cannot occur.  Test PASSED
    @Test
    public void testIntegerUnitID() throws Exception {
        test_object = new Send_Message_To_Operator_Command(10, "Test");
        response_unit_object = new Response_Unit("10", new Location(90, 90));
        Response_Unit_Manager.Add_Response_Unit(response_unit_object);
        test_object.Execute();
    }
	*/
}