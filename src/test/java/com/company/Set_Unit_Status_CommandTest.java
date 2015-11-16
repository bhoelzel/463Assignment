/*******************************************************************************************************
*       UNIT - Set_Unit_Status_Command
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


public class Set_Unit_Status_CommandTest {

    Set_Unit_Status_Command test_object;
    Response_Unit response_unit_object;


    @Before
    public void setUp() throws Exception{
        if (Response_Unit_Manager.Response_Unit_Exists("3") == false) {
            response_unit_object = new Response_Unit("3", new Location(90, 90));
            Response_Unit_Manager.Add_Response_Unit(response_unit_object);
        }
    }
    // Testing Constructor Positive Path
	/*
	Test Case ID: 8.01
	Purpose: �Test Set_Unit_Status_Command constructor with valid Unit_ID and valid Status_Type"
	Preconditions: A unit with the ID 10 exists within the system.
	Expected Result: A new Set_Unit_Status_Command is constructed.
	*/
    @Test
    public void testConstructor() {
        test_object = new Set_Unit_Status_Command("3", Response_Unit.Status_Type.In_Station);
    }

    // Testing Execute Function
	/*
	Test Case ID: 8.02
	Purpose: �Testing if Execute successfully completes�
	Preconditions: Command exists with Unit_ID set to a unit ID exists and a valid Status_Type"
	Expected Result: Execute completes without error.
	*/
    @Test
    public void testSuccessfulExecute() throws Exception{
        Response_Unit.Status_Type status_object = Response_Unit.Status_Type.Not_In_Service;
        test_object = new Set_Unit_Status_Command("3", status_object);
        test_object.Execute();
        Assert.assertSame(Response_Unit_Manager.Response_Unit_Named("3").Status(), status_object);
    }

    /*
	Test Case ID: 8.03
	Purpose: �Testing if Null_Unit_ID_Exeption is thrown when a null ID is provided�
	Preconditions: Command exists with Unit_ID set to null
	Expected Result: Null_Unit_ID_Exception is thrown.
	*/
    @Test
    public void testNullUnitIDException() throws Exception {
        test_object = new Set_Unit_Status_Command(null, Response_Unit.Status_Type.On_Scene);
        try {
            test_object.Execute();
            Assert.fail("Excepted Null_Unit_ID_Exception");
        } catch (Null_Unit_ID_Exception e) {
            // Passed
        }
    }
	
	/*
	Test Case ID: 8.04
	Purpose: �Testing if provided Unit_ID does not exist�
	Preconditions: Command exists with Unit_ID set to a unit ID that does not exist within the system "123"
	Expected Result: No units have their status changed and the system does not crash.
	*/
    @Test
    public void testNonExistentUnitIDException() {
        test_object = new Set_Unit_Status_Command("123", Response_Unit.Status_Type.On_Scene);
        try {
            test_object.Execute();
            Assert.fail("Excepted Null_Unit_ID_Exception");
        } catch (Null_Unit_ID_Exception e) {
            // Passed
        }
    }

    // Testing Constructor Negative Path
    //Test Failed to Compile so this scenario cannot occur. Test Passed.
	/*
	Test Case ID: 8.05
	Purpose: �Testing if Set_Unit_Status_Command is passed an integer as the Unit_ID, it does not crash�
	Preconditions: A unit with the ID 10 exists within the system. Set_Unit_Status_Command is passed the value 10.
	Expected Result: A new Set_Unit_Status_Command is not constructed and the system does not crash.
	*/
    /*
    @Test
    public void testIntegerUnitID() throws Exception {
        test_object = new Set_Unit_Status_Command(10, Response_Unit.Status_Type.On_Scene);
        response_unit_object = new Response_Unit("10", new Location(90, 90));
        Response_Unit_Manager.Add_Response_Unit(response_unit_object);
        test_object.Execute();
    }
    */

    /*
    Test Case ID: 8.06
    Purpose: “Testing if Set_Unit_Status_Command is passed an abnormal Unit_ID it does not crash”
    Preconditions: The value passed to Unit_ID is the String "123abc###".
    Expected Result: A new Set_Unit_Status_Command is executed and the system does not crash.
    */
    @Test
    public void testAbnormalUnitID() throws Exception{
        test_object = new Set_Unit_Status_Command("123abc###", Response_Unit.Status_Type.On_Scene);
        if (Response_Unit_Manager.Response_Unit_Exists("123abc###") == false) {
            response_unit_object = new Response_Unit("123abc###", new Location(90, 90));
            Response_Unit_Manager.Add_Response_Unit(response_unit_object);
        }
        test_object.Execute();
        Assert.assertEquals(Response_Unit_Manager.Response_Unit_Named("123abc###").Status(), Response_Unit.Status_Type.On_Scene);
    }

    //Test Failed to Compile so this scenario cannot occur. Test Passed.
	/*
	Test Case ID: 8.07
	Purpose: �Testing if Set_Unit_Status_Command is passed an invalid Status_Type�
	Preconditions: The value passed to Status_Type is the value 5.
	Expected Result: A new Set_Unit_Status_Command is not constructed and the system does not crash.
	*/
    /*
    @Test
    public void testSuccessfulExecute() throws Exception{
        Response_Unit.Status_Type status_object = 5;
        test_object = new Set_Unit_Location_Command("3", status_object);
        test_object.Execute();
        Assert.assertNotSame(response_unit_manager_object.Response_Unit_Named("3").Status(), status_object);
    }
    */

}