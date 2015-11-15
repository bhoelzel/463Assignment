/*******************************************************************************************************
*       UNIT - Set_Unit_Location_Command
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


public class Set_Unit_Location_CommandTest {


    Set_Unit_Location_Command test_object;
    Response_Unit_Manager response_unit_manager_object;
    Response_Unit response_unit_object;
    Location location_object;


    @Before
    public void setUp(){
        location_object = new Location(90, 90);
        response_unit_manager_object = new Response_Unit_Manager();
    }

    // Testing Constructor Positive Path
	/*
	Test Case ID: 10.01
	Purpose: �Test Set_Unit_Location_Command constructor with a valid Unit_ID and a valid Location"
	Preconditions: A unit with the ID 10 exists within the system.
	Expected Result: A new Set_Unit_Location_Command is constructed.
	*/
    @Test
    public void testConstructor() {
        location_object = new Location(90, 90);
        test_object = new Set_Unit_Location_Command("1", location_object);
    }

    // Testing Execute Function
    /*
	Test Case ID: 10.02
	Purpose: �Testing if Execute successfully updates unit location�
	Preconditions: Command exists with Unit_ID set to a unit ID exists and a valid location"
	Expected Result: Response_Unit has its location updated.
	*/
    @Test
    public void testSuccessfulExecute() throws Exception{
        location_object = new Location(10, 10);
        response_unit_object = new Response_Unit("2", new Location(90, 90));
        response_unit_manager_object.Add_Response_Unit(response_unit_object);
        test_object = new Set_Unit_Location_Command("2", location_object);
        test_object.Execute();
        Assert.assertEquals(response_unit_manager_object.Response_Unit_Named("2").Current_Location().Current_Latitude(), location_object.Current_Latitude(), 0.0);
        Assert.assertEquals(response_unit_manager_object.Response_Unit_Named("2").Current_Location().Current_Longitude(), location_object.Current_Longitude(), 0.0);
    }
	/*
	Test Case ID: 10.03
	Purpose: �Testing if Null_Unit_ID_Exception is thrown when a null ID is provided�
	Preconditions: Command exists with Unit_ID set to null
	Expected Result: Null_Unit_ID_Exception is thrown.
	*/
    @Test
    public void testNullUnitIDException() {
        test_object = new Set_Unit_Location_Command(null, location_object);
        try {
            test_object.Execute();
            Assert.fail("Excepted Null_Unit_ID_Exception");
        } catch (Null_Unit_ID_Exception e) {
            // Passed
        }
    }
	
	/*
	Test Case ID: 10.04
	Purpose: �Testing if provided Unit_ID does not exist within the system.�
	Preconditions: Command exists with Unit_ID set to a unit ID that does not exist within the system "123"
	Expected Result: No units have their location changed and the system does not crash.
	*/
    @Test
    public void testNonExistentUnitIDException() {
        test_object = new Set_Unit_Location_Command("3", location_object);
        try {
            test_object.Execute();
            Assert.fail("Excepted Null_Unit_ID_Exception");
        } catch (Null_Unit_ID_Exception e) {
            // Passed
        }
    }



    // Testing Constructor Negative Path
    /*
	Test Case ID: 10.05
	Purpose: “Testing if Set_Unit_Location_Command is passed an abnormal Unit_ID it does not crash”
	Preconditions: The value passed to Unit_ID is the String "123abc###".
	Expected Result: A new Set_Unit_Location_Command is executed and the system does not crash.
	*/
    @Test
    public void testAbnormalUnitID() throws Exception{
        test_object = new Set_Unit_Location_Command("123abc###", location_object);
        response_unit_object = new Response_Unit("123abc###", new Location(90, 90));
        response_unit_manager_object.Add_Response_Unit(response_unit_object);
        test_object.Execute();
    }

    //Test Failed to Compile so this scenario cannot occur. Test Passed.
	/*
	Test Case ID: 10.06
	Purpose: �Testing if Set_Unit_Location_Command is passed an integer as the Unit_ID it does not crash�
	Preconditions: A unit with the ID 10 exists within the system. Set_Unit_Location is passed the value 10.
	Expected Result: A new Set_Unit_Location_Command is constructed and the system does not crash.
	*/
    /*
    @Test
    public void testIntegerUnitID() throws Exception {
        test_object = new Set_Unit_Location_Command(10, "Test");
        response_unit_object = new Response_Unit("10", new Location(90, 90));
        response_unit_manager_object.Add_Response_Unit(response_unit_object);
        test_object.Execute();
    }
    */
	
	/*
	Test Case ID: 10.07
	Purpose: �Testing if Set_Unit_Location_Command is passed an invalid location it does not crash�
	Preconditions: The value passed to Update_Location is invalid location with a longitude of -1000 and latitude of -1000.
	Expected Result: A new Set_Unit_Location_Command is not constructed and the system does not crash.
	*/
    @Test
    public void testInvalidLocation() throws Exception{
        try {
            location_object = new Location(-1000, -1000);
        } catch (Null_Object_Exception ex) {

        }
        response_unit_object = new Response_Unit("4", new Location(90, 90));
        response_unit_manager_object.Add_Response_Unit(response_unit_object);
        test_object = new Set_Unit_Location_Command("4", location_object);
        test_object.Execute();
        Assert.assertNotEquals(response_unit_manager_object.Response_Unit_Named("4").Current_Location().Current_Latitude(), location_object.Current_Latitude(), 0.0);
        Assert.assertNotEquals(response_unit_manager_object.Response_Unit_Named("4").Current_Location().Current_Longitude(), location_object.Current_Longitude(), 0.0);
    }

    @After
    public void tearDown() {
        response_unit_manager_object = null;
    }
}