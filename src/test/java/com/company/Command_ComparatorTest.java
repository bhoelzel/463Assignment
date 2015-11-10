/*******************************************************************************************************
 *       UNIT - Command_Comparator Test Sequence
 *       Description of test execution
 *       First execution step: Testing 'Compare' Positive Path.
 *       Then test: 'Compare' Boundary Testing
 *******************************************************************************************************/
package com.company;

import org.junit.Before;
import org.junit.Test;
import sun.misc.Compare;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by kazzdingo on 11/4/15.
 */
public class Command_ComparatorTest {

    Command Command_Test_One;
    Command Command_Test_Two;
    int Result_Priority, Prio1, Prio2;

    // Testing Compare Positive path
    /*
    Test Case ID: 12.1
    Purpose: “Testing if compare produces a valid int output if both Commands are initialized and give valid priority"
    Preconditions: Command1.Priority is initialized and Command2.Priority is initialized.
    Expected Result: compare should return a valid int value.
    */
    @Before
    @Test
    public void setUp() throws Exception {

        Command_Test_One = new Command(0, "TEST_ID1_Test") {
            @Override
            public void Execute() throws Null_Unit_ID_Exception {

            }
        };
        Command_Test_Two = new Command(9, "Unit_ID2_Test") {
            @Override
            public void Execute() throws Null_Unit_ID_Exception {

            }
        };
        Command_Test_One.Set_Priority(9);
        Command_Test_Two.Set_Priority(10);

        Command_Comparator test = new Command_Comparator();
        //test.compare(Command_Test_One, Command_Test_Two);
        assertThat(test.compare(Command_Test_One, Command_Test_Two), is(equalTo(-1)));

    }


    /*
    Test Case ID: 12.2
    Purpose: “Testing if Command1.Priority is NULL, in the event that command1.Priority failed to initialized.”
    Preconditions: Command1.Priority is initialized as NULL.
    Expected Result: compare should return a valid int value.
    */
    @Test
    public void test_Compare_Command_1_isNull() throws Exception {

        Command_Test_One = new Command(null, "TEST_ID1_Test") {
            @Override
            public void Execute() throws Null_Unit_ID_Exception {

            }
        };
        Command_Test_Two = new Command(9, "Unit_ID2_Test") {
            @Override
            public void Execute() throws Null_Unit_ID_Exception {

            }
        };
        Command_Test_One.Set_Priority(null);
        Command_Test_Two.Set_Priority(10);

        Command_Comparator test = new Command_Comparator();
        System.out.println (test.compare(Command_Test_One, Command_Test_Two));
        //assertThat(test.compare(Command_Test_One, Command_Test_Two), is(equalTo(-1)));

    }

    /*
    Test Case ID: 12.3
    Purpose: “Testing if Command2.Priority is NULL, in the event that command2.Priority failed to initialized.””
    Preconditions: Command2.Priority is initialized as NULL.
    Expected Result: compare should return a valid int value.
    */
    /*
    Test Case ID: 12.4
    Purpose: “Testing if Command1 is NULL, in the event that command1 failed to initialized.”
    Preconditions: Command1 is initialized as NULL.
    Expected Result: compare should not crash and reflect that the value is invalid.
    */
    /*
    Test Case ID: 12.5
    Purpose: “Testing if Command2 is NULL, in the event that command2 failed to initialized.”
    Preconditions: Command2 is initialized as NULL.
    Expected Result: compare should not crash and reflect that the value is invalid.
    */
}