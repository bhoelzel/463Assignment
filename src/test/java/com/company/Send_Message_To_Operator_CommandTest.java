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


public class Send_Message_To_Operator_CommandTest {

}
	// Testing Constructor Positive Path
	/*
	Test Case ID: 9.01
	Purpose: “Test Send_Message_To_Operator_Command constructor with valid Unit_ID and valid Message"
	Preconditions: A unit with the ID 10 exists within the system.
	Expected Result: A new Send_Message_To_Operator_Command is constructed.
	*/

	// Testing Execute Function
	/*
	Test Case ID: 9.02
	Purpose: “Testing if Null_Unit_ID_Exeption is thrown when a null ID is provided”
	Preconditions: Command exists with Unit_ID set to null
	Expected Result: Null_Unit_ID_Exception is thrown.
	*/ 	
	
	/*
	Test Case ID: 9.03
	Purpose: “Testing if a provided Unit_ID does not exist”
	Preconditions: Command exists with Unit_ID set to a unit ID that does not exist within the system "123"
	Expected Result: Corresponding Message is not sent to the operator and the system does not crash.
	*/ 
	
	// Testing Constructor Negative Path
	/*
	Test Case ID: 9.04
	Purpose: “Testing if Send_Message_To_Operator_Command is passed an integer as the Unit_ID, it does not crash”
	Preconditions: A unit with the ID 10 exists within the system. Send_Message_To_Operator is passed the value 10.
	Expected Result: A new Send_Message_To_Operator_Command is not constructed and the system does not crash.
	*/
	
	/*
	Test Case ID: 9.05
	Purpose: “Testing if Send_Message_To_Operator_Command is passed a String which does not represent a Unit_ID it does not crash”
	Preconditions: The value passed to Unit_ID is the String "123abc###".
	Expected Result: A new Send_Message_To_Operator_Command is not constructed and the system does not crash.
	*/ 
	
	/*
	Test Case ID: 9.06
	Purpose: “Testing if Send_Message_To_Operator_Command is passed the String to "これはテストです" Message's value the system does not crash and succesfully creates the command"
	Preconditions: The value passed to Message is the value "これはテストです".
	Expected Result: A new Send_Message_To_Operator_Command is constructed.
	*/ 