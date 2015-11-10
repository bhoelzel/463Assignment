/*******************************************************************************************************
*       UNIT - Send_Message_To_Operator_Command
*       Description of test execution
*       First execution step: constructor (Positive path) 
*       Then test Lowest Unit Functions (getters, setters)  (Positive/Negative) ie (Concept of tests)
*       Then continue constructor (negative path)  
*******************************************************************************************************/
package com.company;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import static org.hamcrest.MatcherAssert.assertThat;

public class Send_Message_To_Operator_CommandTest {

    Send_Message_To_Operator_Command test_object;
    Response_Unit_Manager response_unit_manager_object;
    Response_Unit response_unit_object;
    Location location_object;


    @Before
    public void setUp(){
        test_object = new Send_Message_To_Operator_Command("1", "Test");
        response_unit_manager_object = new Response_Unit_Manager();
    }
    // Testing Constructor Positive Path
	/*
	Test Case ID: 9.01
	Purpose: “Test Send_Message_To_Operator_Command constructor with valid Unit_ID and valid Message"
	Preconditions: A unit with the ID 10 exists within the system.
	Expected Result: A new Send_Message_To_Operator_Command is constructed.
	*/
    @Test
    public void testConstructor() {
        test_object = new Send_Message_To_Operator_Command("1", "Test");
    }

    // Testing Execute Function
	/*
	Test Case ID: 9.02
	Purpose: “Testing if Null_Unit_ID_Exception is thrown when a null ID is provided”
	Preconditions: Command exists with Unit_ID set to null
	Expected Result: Null_Unit_ID_Exception is thrown.
	*/
    @Test
    public void testNullUnitIDException() {
        test_object = new Send_Message_To_Operator_Command("2", "Test");
        try {
            test_object.Execute();
            Assert.fail("Excepted Null_Unit_ID_Exception");
        } catch (Null_Unit_ID_Exception e) {
            // Passed
        }
    }

    /*
	Test Case ID: 9.04
	Purpose: “Testing if Send_Message_To_Operator_Command is passed an abnormal Unit_ID it does not crash”
	Preconditions: The value passed to Unit_ID is the String "123abc###".
	Expected Result: A new Send_Message_To_Operator_Command is executed and the system does not crash.
	*/
    @Test
    public void testAbnormalUnitID() throws Exception{
        test_object = new Send_Message_To_Operator_Command("123abc###", "Test");
        response_unit_object = new Response_Unit("123abc###", new Location(90, 90));
        response_unit_manager_object.Add_Response_Unit(response_unit_object);
        test_object.Execute();
    }


    // Testing Constructor Negative Path
    //Test Failed to Compile so this scenario cannot occur. Test Passed.
	/*
	Test Case ID: 9.03
	Purpose: “Testing if Send_Message_To_Operator_Command is passed an integer as the Unit_ID, it does not crash”
	Preconditions: A unit with the ID 10 exists within the system. Send_Message_To_Operator is passed the value 10.
	Expected Result: A new Send_Message_To_Operator_Command is not constructed and the system does not crash.
	*/
    /*
    @Test
    public void testIntegerUnitID() throws Exception {
        test_object = new Send_Message_To_Operator_Command(10, "Test");
        response_unit_object = new Response_Unit("10", new Location(90, 90));
        response_unit_manager_object.Add_Response_Unit(response_unit_object);
        test_object.Execute();
    }
	*/

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


}