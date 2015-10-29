/*******************************************************************************************************
 *       Duplicate_Item_Exception Test
 *       Description of test sequence:
 *       Positive path default message test
 *       Positive path string message test
 *******************************************************************************************************/
package com.company;

import com.company.Duplicate_Item_Exception;
import com.sun.org.apache.bcel.internal.generic.DUP;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class Duplicate_Item_ExceptionTest {

    /*
    Test Case ID: 1.01
    Purpose: Test default exception
    Preconditions: Object exist
    Expected Result: Throws no exception message
    */
    @Test
    public void testDefaultException(){
        Duplicate_Item_Exception testItem = new Duplicate_Item_Exception();
//        System.out.print( testItem.fillInStackTrace()  );
//
//        testItem.printStackTrace() ;
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
        Duplicate_Item_Exception testItem = new Duplicate_Item_Exception("Exception in test");
        //System.out.print( testItem.getMessage() );
        assertThat("Exception in test", is(equalTo(testItem.getMessage())));

    }

}


