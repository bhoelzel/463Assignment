/*******************************************************************************************************
*       UNIT - Toggle_Emergency_Command
*       Description of test execution
*       First execution step: constructor (Positive path) 
*       Then test Lowest Unit Functions (getters, setters)  (Positive/Negative) ie (Concept of tests)
*       Then continue constructor (negative path)  
*******************************************************************************************************/

package com.company;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class Toggle_Emergency_CommandTest {

    Toggle_Emergency_Command test_object;
    Response_Unit response_unit_object;


    @Before
    public void setUp() throws Exception{
        if (Response_Unit_Manager.Response_Unit_Exists("4") == false) {
            response_unit_object = new Response_Unit("4", new Location(90, 90));
            Response_Unit_Manager.Add_Response_Unit(response_unit_object);
        }
    }

    // Testing Constructor Positive Path
	 /*
	Test Case ID: 11.01
	Purpose: �Test Toggle_Emergency_Command constructor with a valid Unit_ID"
	Preconditions: A unit with the ID 10 exists within the system.
	Expected Result: A new Toggle_Emergency_Command is constructed.
	*/
    @Test
    public void testConstructor() {
        test_object = new Toggle_Emergency_Command("4");
    }

    // Testing Execute Function
    	/*
	Test Case ID: 11.02
	Purpose: �Testing if Execute successfully completes�
	Preconditions: Command exists with Unit_ID set to a unit ID exists and emergency is toggled.
	Expected Result: Execute completes without error.
	*/
    @Test
    public void testSuccessfulExecute() throws Exception{
        test_object = new Toggle_Emergency_Command("4");
        boolean response_unit_emergency_status = Response_Unit_Manager.Response_Unit_Named("4").Emergency_Exists();
        test_object.Execute();
        Assert.assertEquals(Response_Unit_Manager.Response_Unit_Named("4").Emergency_Exists(), !response_unit_emergency_status);
    }

	/*
	Test Case ID: 11.03
	Purpose: �Testing if Null_Unit_ID_Exception is thrown when a null ID is provided�
	Preconditions: Command exists with Unit_ID set to null
	Expected Result: Null_Unit_ID_Exception is thrown.
	*/
    @Test
    public void testNullUnitIDException() throws Exception {
        test_object = new Toggle_Emergency_Command(null);
        try {
            test_object.Execute();
            Assert.fail("Excepted Null_Unit_ID_Exception");
        } catch (Null_Unit_ID_Exception e) {
            // Passed
        }
    }
	
	/*
	Test Case ID: 11.04
	Purpose: �Testing if provided Unit_ID does not exist�
	Preconditions: Command exists with Unit_ID set to a unit ID that does not exist within the system "123"
	Expected Result: No emergencies are toggled and the system does not crash.
	*/
    @Test
    public void testNonExistentUnitIDException() {
        test_object = new Toggle_Emergency_Command("123");
        try {
            test_object.Execute();
            Assert.fail("Excepted Null_Unit_ID_Exception");
        } catch (Null_Unit_ID_Exception e) {
            // Passed
        }
    }

    // Testing Constructor Negative Path
    /*
    Test Case ID: 11.05
    Purpose: “Testing Toggle_Emergency_Command is passed an abnormal Unit_ID it does not crash”
    Preconditions: The value passed to Unit_ID is the String "123abc###".
    Expected Result: A new Toggle_Emergency_Command is executed and the system does not crash.
    */
    @Test
    public void testAbnormalUnitID() throws Exception{
        test_object = new Toggle_Emergency_Command("123abc###");
        boolean response_unit_emergency_status = Response_Unit_Manager.Response_Unit_Named("4").Emergency_Exists();
        if (Response_Unit_Manager.Response_Unit_Exists("123abc###") == false) {
            response_unit_object = new Response_Unit("123abc###", new Location(90, 90));
            Response_Unit_Manager.Add_Response_Unit(response_unit_object);
        }
        test_object.Execute();
        Assert.assertEquals(Response_Unit_Manager.Response_Unit_Named("123abc###").Emergency_Exists(), !response_unit_emergency_status);
    }

	/*
	Test Case ID: 11.06
	Purpose: �Testing if Toggle_Emergency_Command is passed an integer as the Unit_ID, it does not crash�
	Preconditions: A unit with the ID 10 exists within the system. Toggle_Emergency_Command is passed the value 10.
	Expected Result: A new Toggle_Emergency_Command is not constructed and the system does not crash.
	*/
    /* Note: Test failed to compile, This scenario cannot occur.  Test PASSED
    @Test
    public void testIntegerUnitID() throws Exception {
        test_object = new Toggle_Emergency_Command(10);
        response_unit_object = new Response_Unit("10", new Location(90, 90));
        Response_Unit_Manager.Add_Response_Unit(response_unit_object);
        test_object.Execute();
    }
    */

}