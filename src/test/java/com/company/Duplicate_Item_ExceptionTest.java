/*******************************************************************************************************
 *       Duplicate_Item_Exception Test
 *       Description of test sequence:
 *       Positive path default message test
 *       Positive path string message test
 *******************************************************************************************************/
package com.company;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class Duplicate_Item_ExceptionTest {

    Duplicate_Item_Exception testItem;

    @Before
    public void setUp(){
        testItem = new Duplicate_Item_Exception();
    }
    /*
    Test Case ID: 1.01
    Purpose: Test default exception
    Preconditions: Object exist
    Expected Result: Throws no exception message
    */
    @Test
    public void testDefaultException(){
        testItem = new Duplicate_Item_Exception();
        assertThat(testItem.getMessage(), is(nullValue()) );
    }

    /*
    Test Case ID: 1.02
    Purpose: Test passing string message to object
    Preconditions: Object exist
    Expected Result: Throws inputted exception message
    */
    @Test
    public void testMessageException(){
        testItem = new Duplicate_Item_Exception("Exception in test");
        assertThat("Exception in test", is(equalTo(testItem.getMessage())));

    }

}


