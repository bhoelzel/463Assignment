/*******************************************************************************************************
*       UNIT - Set_Unit_Location_Command
*       Description of test execution
*       First execution step: constructor (Positive path) 
*       Then test Lowest Unit Functions (getters, setters)  (Positive/Negative) ie (Concept of tests)
*       Then continue constructor (negative path)  
*******************************************************************************************************/

package com.company;

import org.junit.Before;
import org.junit.Test;


public class Set_Unit_Location_CommandTest {


    // Testing Constructor Positive Path
	/*
	Test Case ID: 10.01
	Purpose: �Test Set_Unit_Location_Command constructor with a valid Unit_ID and a valid Location"
	Preconditions: A unit with the ID 10 exists within the system.
	Expected Result: A new Set_Unit_Location_Command is constructed.
	*/

    // Testing Execute Function
	/*
	Test Case ID: 10.02
	Purpose: �Testing if Null_Unit_ID_Exeption is thrown when a null ID is provided�
	Preconditions: Command exists with Unit_ID set to null
	Expected Result: Null_Unit_ID_Exception is thrown.
	*/ 
	
	/*
	Test Case ID: 10.03
	Purpose: �Testing if provided Unit_ID does not exist�
	Preconditions: Command exists with Unit_ID set to a unit ID that does not exist within the system "123"
	Expected Result: No units have their location changed and the system does not crash..
	*/

    // Testing Constructor Negative Path
	/*
	Test Case ID: 10.04
	Purpose: �Testing if Set_Unit_Location_Command is passed an integer as the Unit_ID it does not crash�
	Preconditions: A unit with the ID 10 exists within the system. Set_Unit_Location is passed the value 10.
	Expected Result: A new Set_Unit_Location_Command is constructed and the system does not crash..
	*/
	
	/*
	Test Case ID: 10.05
	Purpose: �Testing if Set_Unit_Location_Command is passed a String which does not represent a Unit_ID it does not crash�
	Preconditions: The value passed to Unit_ID is the String "123abc###".
	Expected Result: A new Set_Unit_Location_Command is not constructed and the system does not crash..
	*/ 
	
	/*
	Test Case ID: 10.06
	Purpose: �Testing if Set_Unit_Location_Command is passed an invalid location it does not crash�
	Preconditions: The value passed to Update_Location is invalid location with a longitude of -1000 and latitude of -1000.
	Expected Result: A new Set_Unit_Location_Command is not constructed and the system does not crash..
	*/
}