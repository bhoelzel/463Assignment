/*******************************************************************************************************
 *       UNIT - Reponse_Unit_Manager Test Sequence
 *       Description of test execution
 *       First execution step: Testing Add_Reponse_Unit Positive Path.
 *       Then test Lowest Unit Functions: Response_Unit_Named & Response_Unit_Exists
 *******************************************************************************************************/
package com.company;

import org.junit.Before;
import org.junit.Test;
//import sun.org.mozilla.javascript.internal.EcmaError;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Response_Unit_ManagerTest {
    String test_id = "1001";
    Response_Unit test_response_unit;
    Response_Unit_Manager test_subject;

    //Positive path constructor test including adding Response_Unit
    /*
    Test Case ID: 6.01
    Purpose: Test initialise Response_Unit_Manager.
    Preconditions: A valid Location object has been initialized
                   A valid Response_Unit has been initialized
    Expected Result: Response_Unit_Manager has been initialized with a Response_Unit added
    */
    @Test
    @Before
    public void setUp() throws Exception {
        //Test
        test_subject = new Response_Unit_Manager();
        //Testing of Location has been completed prior
        Location test_location = new Location(-80.0f, -100.0f);
        //Testing of Response_Unit has been completed prior
        test_response_unit = new Response_Unit(test_id, test_location);
        test_subject.Add_Response_Unit(test_response_unit);
    }

    //Positive path getter tests
    /*
    Test Case ID: 6.02
    Purpose: Test object exist in Response_Unit_Manager
    Preconditions: Test_Object has been initialized with Response_Unit having ID of "1001"
    Expected result: Return true
    */
    @Test
    public void TestUnitIdExist(){
        assertTrue(test_subject.Response_Unit_Exists(test_id));
    }

    /*
    Test Case ID: 6.03
    Purpose: Test Response_Unit getter
    Preconditions: Test_Object has been initialized with Response_Unit having ID of "1001"
    Expected result: The returned Response_Unit is the same as the test_response_unit built in setUp()
    */
    @Test
    public void TestResponseUnitGetter(){
        Response_Unit retrived_unit;
        retrived_unit = test_subject.Response_Unit_Named(test_id);
        assertThat(retrived_unit, is(equalTo(test_response_unit)));
    }

    //Negative path getter tests
    /*
    Test Case ID: 6.04
    Purpose: “Testing if the Response_Unit_Exists returns False when Response_Unit does not Exists"
    Preconditions: Unit_ID does not match an existing/pre-initialized Response_Unit.
    Expected Result: False Boolean is returned
    */
    @Test
    public void TestResponseIdExistWithBadId(){
        assertFalse(test_subject.Response_Unit_Exists("999"));
    }

    /*
    Test Case ID: 6.05
    Purpose: “Testing if the Response_Unit_Named runs when Unit_ID does not match existing Response_Unit"
    Preconditions: Unit_ID does not matches an existing Response_Unit.
    Expected Result: null returned
    */
    @Test
    public void TestResponseUnitGetterWithBadId(){
        Response_Unit retrived_unit;
        retrived_unit = test_subject.Response_Unit_Named("999");
        assertThat( retrived_unit, is( equalTo(null)));
     }

    //Negative path setter test
    /*
    Test Case ID: 6.06
    Purpose: "Adding a null object to the Response_Unit_Manager”
    Preconditions: New_Unit is null
    Expected Result: Null_Object_Exception is thrown.
    */
    @Test (expected = Null_Object_Exception.class)//Duplicate_Item_Exception not expected.
    public void TestResponseSetWithNullResponseUnit() throws Null_Object_Exception, Duplicate_Item_Exception {
        Response_Unit a_unit = null;
        test_subject.Add_Response_Unit( a_unit );
    }


    /*
    Test Case ID: 6.07
    Purpose: “Testing if the New_Unit has a duplicate ID that the program will not crash”
    Preconditions: New_Unit has the same ID as an existing unit
    Expected Result: Duplicate_Item_Exception is thrown.
    */
    @Test (expected = Duplicate_Item_Exception.class)//Duplicate_Item_Exception not expected.
    public void TestResponseSetWithDuplicateResponseUnit() throws Null_Object_Exception, Duplicate_Item_Exception {
        //test_response_unit already exist in the
        Response_Unit a_new_unit = test_response_unit;
        test_subject.Add_Response_Unit( a_new_unit );
    }

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

}










