/*******************************************************************************************************
*       UNIT - Toggle_Emergency_Command
*       Description of test execution
*       First execution step: constructor (Positive path) 
*       Then test Lowest Unit Functions (getters, setters)  (Positive/Negative) ie (Concept of tests)
*       Then continue constructor (negative path)  
*******************************************************************************************************/

package com.company;

import org.junit.Before;
import org.junit.Test;


public class Toggle_Emergency_CommandTest {


    // Testing Constructor Positive Path
	 /*
	Test Case ID: 11.03
	Purpose: �Test Toggle_Emergency_Command constructor with a valid Unit_ID"
	Preconditions: A unit with the ID 10 exists within the system.
	Expected Result: A new Toggle_Emergency_Command is constructed.
	*/

    // Testing Execute Function
	/*
	Test Case ID: 11.01
	Purpose: �Testing if Null_Unit_ID_Exception is thrown when a null ID is provided�
	Preconditions: Command exists with Unit_ID set to null
	Expected Result: Null_Unit_ID_Exception is thrown.
	*/ 
	
	/*
	Test Case ID: 11.02
	Purpose: �Testing if provided Unit_ID does not exist�
	Preconditions: Command exists with Unit_ID set to a unit ID that does not exist within the system "123"
	Expected Result: No emergencies are toggled and the system does not crash.
	*/

    // Testing Constructor Negative Path
	/*
	Test Case ID: 11.04
	Purpose: �Testing if Toggle_Emergency_Command is passed an integer as the Unit_ID, it does not crash�
	Preconditions: A unit with the ID 10 exists within the system. Toggle_Emergency_Command is passed the value 10.
	Expected Result: A new Toggle_Emergency_Command is not constructed and the system does not crash.
	*/
	
	/*
	Test Case ID: 11.05
	Purpose: �Testing if Toggle_Emergency_Command is passed a String which does not represent a Unit_ID it does not crash�
	Preconditions: The value passed to Unit_ID is the String "123abc###".
	Expected Result: A new Toggle_Emergency_Command is not constructed and the system does not crash.
	*/
}