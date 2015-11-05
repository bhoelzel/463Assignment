/*******************************************************************************************************
 *       UNIT - Reponse_Unit_ Test Sequence
 *       Description of test execution
 *       First execution step: Testing Reponse_Unit Constructor Positive Path.
 *       Then test Lowest Unit Functions: Getters
 *       Then test: 'Response_Unit' Boundary tests, Negative Paths
 *******************************************************************************************************/
package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kazzdingo on 11/4/15.
 */
public class Response_UnitTest {

    Response_Unit Test_Unit;
    Location Test_Location = new Location(80.00f,80f);
    @Before
    @Test
    public void setUp() throws Exception {

        Test_Unit = new Response_Unit("9000", Test_Location);

    }

    //Test Getters positive
    //Test Getters negative
    //Test Setters Positive path
    //Test setters Negative path
}


// Testing Response_Unit
    /*
    Test Case ID: 5.01
    Purpose: “Testing if Response_Unit param Unit_ID is NULL that the exception is thrown”
    Preconditions: Unit_ID is null
    Expected Result: Exception is thrown and program exits normally
    */
    /*
    Test Case ID: 5.02
    Purpose: “Testing if Response_Unit param Unit_ID is an Unusual value, the String “á£ \uFFFF.深“ ”
    Preconditions: Unit_ID is the String “á£ \uFFFF.深“
    Expected Result: Unit_ID=”á£ \uFFFF.深“ is updated with status.
    */
    /*
    Test Case ID: 5.03
    Purpose: “Testing if Response_Unit param Starting_Location is NULL that the exception is thrown”
    Preconditions: Starting_Location is null
    Expected Result: Exception is thrown and program exits normally
    */
    /*
    Test Case ID: 5.04
    Purpose: “Testing if Response_Unit param Starting_Location is an Unusual value (invalid enum type), the String “á£ \uFFFF.深“ ”
    Preconditions: Starting_Location is the String “á£ \uFFFF.深“
    Expected Result: Starting_Location is invalid enum type and is rejected.
    */
    /*
    Test Case ID: 5.05
    Purpose: “Testing the positive path to validate that Response_Unit works"
    Preconditions: Valid params Starting_Location and Unit_ID are passed.
    Expected Result: Emergency_Exists is set to false, Status is set, Response_Unit_ID is set, and Current_Location is set.
    */

//Testing Emergency_Exists
    /*
    Test Case ID: 5.06
    Purpose: “Testing the positive path to validate that Emergency_Exists Returns a valid Boolean datatype"
    Preconditions: Emergency_Exists has had data assigned.
    Expected Result: Emergency_Exists returns the data assigned to the variable. Valid Boolean Data output.
    */

//Testing Current_Location
    /*
    Test Case ID: 5.07
    Purpose: “Testing the positive path to validate that Current_Location Returns a valid Location datatype"
    Preconditions: Current_Location has had data assigned.
    Expected Result: Current_Location returns the data assigned to the variable. Valid Location Data type output.
    */

//Testing Status_Type
    /*
    Test Case ID: 5.08
    Purpose: “Testing the positive path to validate that Status Returns a valid Status_Type datatype"
    Preconditions: Status has had data assigned.
    Expected Result: Status returns the data assigned to the variable. Valid Status_Type Data output.
    */

//Testing Unit_ID
    /*
     Test Case ID: 5.09
     Purpose: “Testing the positive path to validate that Unit_ID Returns a valid String datatype"
     Preconditions: Response_Unit_ID has had data assigned.
     Expected Result: Unit_ID returns the data assigned to the variable. Valid String Data output.
     */

//Testing Set_Emergency
    /*
     Test Case ID: 5.10
     Purpose: "Testing Set_Location to make sure we can not set it to a non 'Location' data type"
     Precondition: Set New_Location as a 'String' or 'int' or 'boolean'
     Expected Result: Set_Location should fail to initilize.
     */

//Testing Set_Location
    /*
     Test Case ID: 5.11
     Purpose: "Testing Set_Status to make sure we can not set it to a non 'Status_Type' value"
     Precondition: Set New_Setting as a 'String' or 'int' or 'Boolean'
     Expected Result: Set_Status should fail to initilize.
     */

