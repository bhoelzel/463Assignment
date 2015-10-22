
package com.company;

import com.company.Duplicate_Item_Exception;
import com.sun.org.apache.bcel.internal.generic.DUP;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by benhoelzel on 10/16/15.
 */
public class Duplicate_Item_ExceptionTest {


    //public Duplicate_Item_Exception()
    /*
    Test Case ID: 8.01
    Purpose: Test default exception
    Preconditions: Object exist
    Postconditions: Object exist
    Expected Output: Throws no exception message
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
    Test Case ID: 8.02
    Purpose: Test passing string message to object
    Preconditions: Object exist
    Postconditions: None expected
    Expected Output: Throws inputted exception message
    */
    @Test
    public void testMessageException(){
        Duplicate_Item_Exception testItem = new Duplicate_Item_Exception("Exception in test");
        //System.out.print( testItem.getMessage() );
        assertThat("Exception in test", is(equalTo(testItem.getMessage())));

    }

}


