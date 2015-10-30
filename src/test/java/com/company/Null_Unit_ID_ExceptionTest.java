/*******************************************************************************************************
 *       Null_Unit_ID_ExceptionTest Test
 *       Description of test sequence:
 *       Positive path default message test
 *       Positive path string message test
 *******************************************************************************************************/
package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class Null_Unit_ID_ExceptionTest {

    Null_Unit_ID_Exception testItem;

    @Before
    public void setUp(){
        testItem = new Null_Unit_ID_Exception();
    }
    /*
    Test Case ID: 3.01
    Purpose: Test default exception
    Preconditions: Object exist
    Expected Result: Throws null message
    */
    @Test
    public void testDefaultException(){
        testItem = new Null_Unit_ID_Exception();
        assertThat(testItem.getMessage(), is(nullValue()) );
    }

    /*
    Test Case ID: 3.02
    Purpose: Test passing string message to object
    Preconditions: Object exist
    Expected Result: Throws inputed exception message
    */
    @Test
    public void testMessageException(){
        testItem = new Null_Unit_ID_Exception("Exception in test");
        assertThat("Exception in test", is(equalTo(testItem.getMessage())));

    }

}