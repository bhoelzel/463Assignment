/*******************************************************************************************************
 *       UNIT - Reponse_Unit_Manager Test Sequence
 *       Description of test execution
 *       First execution step: Testing Add_Reponse_Unit Positive Path.
 *       Then test Lowest Unit Functions: Response_Unit_Named & Response_Unit_Exists
 *******************************************************************************************************/
package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kazzdingo on 11/4/15.
 */
public class Response_Unit_ManagerTest {

    @Before
    public void setUp() throws Exception {

    }
    // Testing the smallest Unit (referencing test sequence)
    /*
    Test Case ID: 6.02
    Purpose: “Testing if the New_Unit has a duplicate ID that the program will not crash”
    Preconditions: New_Unit has the same ID as an existing unit
    Expected Result: Duplicate_Item_Exception is thrown.
    */
}

// Testing Add_Response_Unit
    /*
    Test Case ID: 6.01
    Purpose: “Testing if the New_Unit is NULL that the program will not crash”
    Preconditions: New_Unit is null
    Expected Result: Null_Object_Exception is thrown.
    */




    /*
    Test Case ID: 6.03
    Purpose: “Testing if the New_Unit.Unit_ID is an extreme value and its effect on the program”
    Preconditions: New_Unit.Unit_ID is Integer.MAX_VALUE || Long.MAX_VALUE
    Expected Result: Response_Unit is added to the Response_Unit_DB
    */

    /*
    Test Case ID: 6.04
    Purpose: “Testing if the New_Unit.Unit_ID is Unusual values, the String “á£ \uFFFF.深“ ”
    Preconditions: New_Unit.Unit_ID is the String “á£ \uFFFF.深“
    Expected Result: New Response_Unit with Unit_ID=”á£ \uFFFF.深“ is inserted into Response_Unit_DB.
    */

    /*
    Test Case ID: 6.05
    Purpose: “Testing if the New_Unit.Unit_ID is zero”
    Preconditions: New_Unit.Unit_ID is set to 0 and there is no existing object in db with Unit_ID=0
    Expected Result: New Response_Unit with Unit_ID=0 is inserted into Response_Unit_DB.
    */

    /*
    Test Case ID: 6.06
    Purpose: “Testing if the New_Unit.Unit_ID is negative”
    Preconditions: New_Unit.Unit_ID is set to -1 and there is no existing object in db with Unit_ID=-1
    Expected Result: New Response_Unit with Unit_ID=-1 is inserted into Response_Unit_DB.
    */

    /*
    Test Case ID: 6.07
    Purpose: “Testing if the New_Unit.Unit_ID is a float value”
    Preconditions: New_Unit.Unit_ID is set to 3.14 and there is no existing object in db with Unit_ID=3.14
    Expected Result: New Response_Unit with Unit_ID=3.14 is inserted into Response_Unit_DB.
    */

//Testing Response_Unit_Named
    /*
    Test Case ID: 6.08
    Purpose: “Testing if the Response_Unit_Named returns valid Response_Unit type"
    Preconditions: Unit_ID matches an exisiting/preinitilized Reponse_Unit.
    Expected Result: Valid Reponse_Unit is returned
    */
    /*
    Test Case ID: 6.09
    Purpose: “Testing if the Response_Unit_Named runs when Unit_ID does not match existing Reponse_Unit"
    Preconditions: Unit_ID does not matches an exisiting Reponse_Unit.
    Expected Result: No Reponse_Unit returned
    */

//Testing Response_Unit_Exists
    /*
    Test Case ID: 6.10
    Purpose: “Testing if the Response_Unit_Exists returns True when Reponse_Unit Exists"
    Preconditions: Unit_ID matches an exisiting/preinitilized Reponse_Unit.
    Expected Result: True Boolean is returned
    */
    /*
    Test Case ID: 6.11
    Purpose: “Testing if the Response_Unit_Exists returns False when Reponse_Unit does not Exists"
    Preconditions: Unit_ID does not match an exisiting/preinitilized Reponse_Unit.
    Expected Result: False Boolean is returned
    */
