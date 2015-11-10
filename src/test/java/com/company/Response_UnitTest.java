/*******************************************************************************************************
 *       UNIT - Reponse_Unit_ Test Sequence
 *       Description of test execution
 *       First execution step: Testing Reponse_Unit Constructor Positive Path.
 *       Then test Lowest Unit Functions: Getters/getters Positive Path
 *       Then test: Setters Positive/Negative
 *       Then test: 'Response_Unit' Boundary tests, Negative Paths
 *******************************************************************************************************/
package com.company;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by Bijan Hamidi on 11/4/15.
 *
 */
public class Response_UnitTest {

    Response_Unit Test_Unit;
    String Good_Unit_ID = "9000";
    Location Good_Test_Location = new Location(80.00f, 80f);

    //Testing Constructor positive
    /*
    Test Case ID: 5.01
    Purpose: “Testing the positive path to validate that Response_Unit works"
    Preconditions: Valid params Starting_Location and Unit_ID are passed.
    Expected Result: Emergency_Exists is set to false, Status is set, Response_Unit_ID is set, and Current_Location is set.
    */
    @Before
    @Test
    public void setUp() throws Exception {
        Test_Unit = new Response_Unit(Good_Unit_ID, Good_Test_Location);
    }

    //Test Getters/Setters positive
    //Testing Emergency_Exists
    /*
    Test Case ID: 5.06
    Purpose: “Testing the positive path to validate that Emergency_Exists Returns a valid Boolean datatype"
    Preconditions: Emergency_Exists has had data assigned.
    Expected Result: Emergency_Exists returns the data assigned to the variable. Valid Boolean Data output.
    */
    @Test
    public void test_Emergency_ExistsGetter() {
        assertFalse(Test_Unit.Emergency_Exists());
    }

    //Testing Current_Location
    /*
    Test Case ID: 5.07
    Purpose: “Testing the positive path to validate that Current_Location Returns a valid Location datatype"
    Preconditions: Current_Location has had data assigned.
    Expected Result: Current_Location returns the data assigned to the variable. Valid Location Data type output.
    */
    @Test
    public void test_Current_LocationGetter() {
        assertThat(Test_Unit.Current_Location(), is(equalTo(Good_Test_Location)));
    }

    //Testing Status_Type
    /*
    Test Case ID: 5.08
    Purpose: “Testing the positive path to validate that Status Returns a valid Status_Type datatype"
    Preconditions: Status has had data assigned.
    Expected Result: Status returns the data assigned to the variable. Valid Status_Type Data output.
    */
    @Test
    public void testCurrent_Status_TypeGetter() {
        assertThat(Test_Unit.Status(), is(equalTo(Response_Unit.Status_Type.Not_In_Service)));
    }

    //Testing Unit_ID
    /*
     Test Case ID: 5.09
     Purpose: “Testing the positive path to validate that Unit_ID Returns a valid String datatype"
     Preconditions: Response_Unit_ID has had data assigned.
     Expected Result: Unit_ID returns the data assigned to the variable. Valid String Data output.
     */
    @Test
    public void test_Unit_IDGetter() {
        assertThat(Test_Unit.Unit_ID(), is(equalTo(Good_Unit_ID)));
    }

    //Test Setters Positive/Negative Path
    //Testing Set_Emergency Setter Positive
    /*
     Test Case ID: 5.10
     Purpose: "Testing Set_Emergency to make sure we can set it to a 'Boolean' data type"
     Precondition: Set a Boolean to an existing Response_Unit from the default false to true value.
     Expected Result: The new Emergency_Exists value should be updated to True.
     */
    @Test
    public void test_Set_EmergencySetterPositive() {
        Test_Unit.Set_Emergency(Boolean.TRUE);
        assertTrue(Test_Unit.Emergency_Exists());
    }

    //Testing Set_Emergency Setter Negative
    /*
     Test Case ID: 5.11
     Purpose: "Testing Set_Emergency to make sure we can not set it to a non 'Boolean' data type"
     Precondition: Set New_Location as a 'String' or 'int'
     Expected Result: Set_Emergency should fail to initilize.
     */
    /* NOTE: Test failed to compile so this scenario can not occur.  Test PASSED
    @Test
    public void test_Set_EmergencySetterNegative(){
        Test_Unit.Set_Emergency("9000");
        assertTrue(Test_Unit.Emergency_Exists());
    }
    */

    //Testing Set_Location Positive
    /*
     Test Case ID: 5.12
     Purpose: "Testing Set_Location to make sure we can set it to a 'Location' data type"
     Precondition: Set New_Location as a valid Location Data Type'
     Expected Result: Test_Unit Current Location should match the new Location assigned to it.
     */
    @Test
    public void test_Set_LocationSetterPositive() {
        Location Good_Test_Location_Two = new Location(90.00f, 90f);
        Test_Unit.Set_Location(Good_Test_Location_Two);
        assertThat(Test_Unit.Current_Location(), is(equalTo(Good_Test_Location_Two)));
    }

     /*
     Test Case ID: 5.13
     Purpose: "Testing Set_Location to make sure we can not set it to a non 'Location' data type"
     Precondition: Set New_Location as a 'String' or 'int' or 'boolean'
     Expected Result: Set_Location should fail to initilize.
     */
    /* NOTE: Test failed to compile so this scenario can not occur.  Test PASSED
     @Test
     public void test_Set_LocationSetterNegative(){
         Location Good_Test_Location_Two = new Location("name","name2");
         Test_Unit.Set_Location(Good_Test_Location_Two);
         assertThat(Test_Unit.Current_Location(), is(equalTo(Good_Test_Location_Two)));
     }
     */

    //Testing Set_Status Setter Positive
    /*
     Test Case ID: 5.14
     Purpose: "Testing Set_Status to make sure we can not set it to a non 'Status_Type' value"
     Precondition: Set New_Setting as a 'String' or 'int' or 'Boolean'
     Expected Result: Set_Status should fail to initilize.
     */
    @Test
    public void test_Set_StatusSetterPositive() {
        Test_Unit.Set_Status(Response_Unit.Status_Type.Enroute);
        assertThat(Test_Unit.Status(), is(equalTo(Response_Unit.Status_Type.Enroute)));
    }

    //Testing Set_Status Setter Negative
     /*
     Test Case ID: 5.15
     Purpose: "Testing Set_Status to make sure we can not set it to a non 'Status_Type' value"
     Precondition: Set New_Setting as a 'String' or 'int' or 'Boolean'
     Expected Result: Set_Status should fail to initilize.
     */
    /* NOTE: Test failed to compile so this scenario can not occur.  Test PASSED
    @Test
    public void test_Set_StatusSetterNegative(){
        Test_Unit.Set_Status(Response_Unit.Status_Type.Missing);
        assertThat(Test_Unit.Status(), is(equalTo(Response_Unit.Status_Type.Enroute)));
    }
    */


    // Testing Response_Unit
    /*
    Test Case ID: 5.16
    Purpose: “Testing if Response_Unit param Unit_ID is NULL that the exception is thrown”
    Preconditions: Unit_ID is null
    Expected Result: Exception is thrown and program exits normally
    */
    @Test(expected = Null_Object_Exception.class)
    public void test_Response_Unit_Param_UnitID_isNull() throws Exception {
        Response_Unit Response_Unit_Bad = new Response_Unit(null, Good_Test_Location);
        assertThat(Response_Unit_Bad.Unit_ID(), is(equalTo(null)));
    }

    /*
    Test Case ID: 5.17
    Purpose: “Testing if Response_Unit param Unit_ID is an Unusual value, the String “á£ \uFFFF.深“ ”
    Preconditions: Unit_ID is the String “á£ \uFFFF.深“
    Expected Result: Unit_ID=”á£ \uFFFF.深“ is updated with status.
    */
    @Test
    public void test_Response_Unit_Param_UnitID_isUnusual() throws Exception {
        Response_Unit Response_Unit_Bad = new Response_Unit("á£ \\uFFFF.深", Good_Test_Location);
        assertThat(Response_Unit_Bad.Unit_ID(), is(equalTo("á£ \\uFFFF.深")));
    }

    /*
    Test Case ID: 5.18
    Purpose: “Testing if Response_Unit param Starting_Location is NULL that the exception is thrown”
    Preconditions: Starting_Location is null
    Expected Result: Exception is thrown and program exits normally
    */
    @Test(expected = Null_Object_Exception.class)
    public void test_Response_Unit_Param_StartingLocation_isNull() throws Exception {
        Response_Unit Response_Unit_Bad = new Response_Unit(Good_Unit_ID, null);
        assertThat(Response_Unit_Bad.Current_Location(), is(equalTo(null)));
    }

    /*
    Test Case ID: 5.19
    Purpose: “Testing if Response_Unit param Starting_Location is an Unusual value (invalid enum type), the String “á£ \uFFFF.深“ ”
    Preconditions: Starting_Location is the String “á£ \uFFFF.深“
    Expected Result: Starting_Location is invalid enum type and is rejected.
    */
    /* Note: Test failed to compile, This scenario cannot occur.  Test PASSED
    @Test(expected = Null_Object_Exception.class)
    public void test_Response_Unit_Param_StartingLocation_isUnusual() throws Exception {
        Response_Unit Response_Unit_Bad = new Response_Unit(Good_Unit_ID, "á£ \\uFFFF.深");
        assertThat(Response_Unit_Bad.Current_Location(), is(equalTo("á£ \\uFFFF.深")));
    }
    */

}




