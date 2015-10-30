/*******************************************************************************************************
 *       Null_Object_ExceptionTest Test
 *       Description of test sequence:
 *       Positive path default message test
 *       Positive path string message tests
 *******************************************************************************************************/
package com.company;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class Null_Object_ExceptionTest {

    Null_Object_Exception testItem;

    @Before
    public void setUp(){
        testItem = new Null_Object_Exception();
    }
    /*
    Test Case ID: 2.01
    Purpose: Test default exception
    Preconditions: Object exist
    Expected Result: Throws null exception message
    */
    @Test
    public void testDefaultException(){
        assertThat(testItem.getMessage(), is(nullValue()) );
    }
    //public Null_Object_Exception(String msg)
    /*
    Test Case ID: 2.02
    Purpose: Test passing string message to object
    Preconditions: Object exist
    Expected Result: Throws inputed exception message
    */
    @Test
    public void testMessageException(){
        testItem = new Null_Object_Exception("Exception in test");
        assertThat("Exception in test", is(equalTo(testItem.getMessage())));
    }
    // public Null_Object_Exception (Float Latitude, Float Longitude)
     /*
    Test Case ID: 2.03
    Purpose: Test passing with bad Latitude value
    Preconditions: Object exist
    Expected Result: Throws the erroneous value message: "Location " + Latitude + ", " + Longitude + " is not valid"
    */
    @Test
    public void testBadLatitudeMasseage(){
        testItem = new Null_Object_Exception(1000.0f, 1000.0f);
        assertThat("Location " + 1000.0f + ", " + 1000.0f + " is not valid", is(equalTo(testItem.getMessage())));
    }

    /*
     Test Case ID: 2.04
     Purpose: Test passing with bad Longitude value
     Preconditions: Object exist
     Expected Expect: Throws the erroneous value message: "Location " + Latitude + ", " + Longitude + " is not valid"
    */
    @Test
    public void testBadLongitudeMasseage(){
        testItem = new Null_Object_Exception(1000.0f, 1000.0f);
        assertThat("Location " + 1000.0f + ", " + 1000.0f + " is not valid", is(equalTo(testItem.getMessage())));
        System.out.println(equalTo(testItem.getMessage()));
    }
}