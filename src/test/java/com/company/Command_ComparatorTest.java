/*******************************************************************************************************
 *       UNIT - Command_Comparator Test Sequence
 *       Description of test execution
 *       First execution step: Testing 'Compare' Positive Path.
 *       Then test: 'Compare' Boundary Testing
 *******************************************************************************************************/
package com.company;

import org.junit.Before;
import sun.misc.Compare;

import static org.junit.Assert.*;

/**
 * Created by kazzdingo on 11/4/15.
 */
public class Command_ComparatorTest {

    Command Command_Test_One;
    Command Command_Test_Two;
    int Result_Priority, Prio1, Prio2;
    @Before
    public void setUp() throws Exception {

        Command_Test_One = new Toggle_Emergency_Command("TEST_ID1_Test");
        Command_Test_Two = new Toggle_Emergency_Command("Unit_ID2_Test");
        Command_Test_One.Set_Priority(9);
        Command_Test_Two.Set_Priority(10);

      // Result_Priority = new Command_Comparator(Command_Test_One,Command_Test_Two);
    }

}

// Testing Compare
    /*
    Test Case ID: 12.1
    Purpose: “Testing if Command1.Priority is NULL, in the event that command1.Priority failed to initilize.”
    Preconditions: Command1.Priority is initilized as NULL.
    Expected Result: compare should return a valid int value.
    */
    /*
    Test Case ID: 12.2
    Purpose: “Testing if Command2.Priority is NULL, in the event that command2.Priority failed to initilize.””
    Preconditions: Command2.Priority is initilized as NULL.
    Expected Result: compare should return a valid int value.
    */
    /*
    Test Case ID: 12.3
    Purpose: “Testing if Command1 is NULL, in the event that command1 failed to initilize.”
    Preconditions: Command1 is initilized as NULL.
    Expected Result: compare should not crash and reflect that the value is invalid.
    */
    /*
    Test Case ID: 12.4
    Purpose: “Testing if Command2 is NULL, in the event that command2 failed to initilize.”
    Preconditions: Command2 is initilized as NULL.
    Expected Result: compare should not crash and reflect that the value is invalid.
    */
