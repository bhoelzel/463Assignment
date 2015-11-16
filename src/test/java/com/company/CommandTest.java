/*******************************************************************************************************
 *       UNIT - Command
 *       Description of test execution
 *       First execution step: constructor (Positive path)
 *       Then test Lowest Unit Functions (getters, setters)
 *       Then continue constructor (negative path)
 *******************************************************************************************************/
package com.company;


import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;


public class CommandTest {

    private Command goodCommand;
    private Command badCommand;
    double testDouble = 1.0;
    long testLong = 1;
    float testFloat = 1.0f;
    String testString = "Test";
    int testInt = 1;
    int testIntXLarge = 2147483647;
    int testIntXSmall = -2147483648;
    int testPriorityHigh=10;
    int testPriorityLow=1;

    @Before
    //Positive Path Constructor Test
    /**
     *  Test Case ID: 7.01
     *  Purpose: Type Test of the priority attribute with Integer.
     *  Preconditions: Command compiles.
     *  Expected Output: A Command object is created and works with all functions.
     * @throws Exception
     */
    @Test
    public void testCommand() throws Exception {
        goodCommand = new Command(testInt, testString) {
            @Override
            public void Execute() throws Null_Unit_ID_Exception {
                System.out.println("It works");
            }
        };
        assertNotNull(goodCommand);
    }

    //Positive Path Tests
    /**
     *   Test Case ID: 7.02
     *   Purpose: Test of the Set_Priority Function.
     *   Preconditions: Command must be initialized.
     *   Expected Output: A Commands priority should be changed.
     */
    @Test
    public void testSet_Priority(){
        goodCommand.Set_Priority(testInt);
        assertEquals(testInt,goodCommand.Priority());
    }

    /**
     *   Test Case ID: 7.03
     *   Purpose: Test of the Set_Unit_ID.
     *   Preconditions: Command must be initialized.
     *   Expected Output: A Commands Unit_ID should be changed.
     */
    @Test
    public void testSet_Unit_ID() throws Exception {
        goodCommand.Set_Unit_ID(testString);
        assertEquals(testString,goodCommand.Unit_ID);
    }

    /**
     *   Test Case ID: 7.04
     *   Purpose: Test of the Unit_ID getter.
     *   Preconditions: Command must be initialized.
     *   Expected Output: Commands Unit_ID should be returned.
     */
    @Test
    public void testUnit_ID() throws Exception {
        assertEquals( testString,goodCommand.Unit_ID);
    }

    /**
     *   Test Case ID: 7.05
     *   Purpose: Test of the Priority getter.
     *   Preconditions: Command must be initialized.
     *   Expected Output: Commands Priority should be returned.
     */
    @Test
    public void testPriority() throws Exception {

        assertEquals(testPriorityLow,goodCommand.Priority());
    }

    /**
     *  Test Case ID: 7.06
     *  Purpose: Test IsHigherPriorityThen with a command of higher priority.
     *  Preconditions: 2 Commands are initialized. One with higher priority than other.
     *  Expected Output: True
     *
     */
    @Test
    public void testIs_Higher_Priority_Then() throws Exception {
        badCommand= new Command(testInt,testString) {
            @Override
            public void Execute() throws Null_Unit_ID_Exception {

            }
        };
        goodCommand.Set_Priority(testPriorityHigh);
        badCommand.Set_Priority(testPriorityLow);
        boolean priority = goodCommand.Is_Higher_Priority_Then(badCommand);
        assertTrue(priority);
    }

    /**
     *  Test Case ID: 7.07
     *  Purpose: Test of Execute.
     *  Preconditions: Command is initialized with an implemented Execute function.
     *  Expected Output: Test Execute function will print"It works" to terminal
     *
     */
    @Test
    public void testExecute() throws Exception {
        goodCommand.Execute();
    }

    //Negative Path Tests
    /**
     *  Test Case ID: 7.08
     *  Purpose: Type Test of the priority attribute with Float.
     *  Preconditions: Command file compiles and constructor can be called.
     *  Expected Output: A Command object should not be created and should gracefully fail.
     *  NOTE: Compiler would not allow. TEST PASSED
     */
    @Test
    public void testCommandwFloat() throws Exception {
        /*badCommand= new Command(testFloat, testString) {
            @Override
            public void Execute() throws Null_Unit_ID_Exception {

            }
        };
        assertNotNull(badCommand);*/
    }

    /**
     *  Test Case ID: 7.09
     *  Purpose: Type Test of the priority attribute with Long.
     *  Preconditions: Command file compiles and constructor can be called.
     *  Expected Output: A Command object should not be created and should gracefully fail.
     *  NOTE: Compiler would not allow. TEST PASSED
     */
    @Test
    public void testCommandwLong() throws Exception {
        /*badCommand= new Command(testLong,testString) {
            @Override
            public void Execute() throws Null_Unit_ID_Exception {

            }
        };
        assertNotNull(badCommand);*/
    }

    /**
     *  Test Case ID: 7.10
     *  Purpose: Type Test of the priority attribute with Double.
     *  Preconditions: Command file compiles and constructor can be called.
     *  Expected Output: A Command object should not be created and should gracefully fail.
     *  NOTE: Compiler would not allow. TEST PASSED
     */
    @Test
    public void testCommandwDouble() throws Exception {
       /* badCommand= new Command(testDouble, testString) {
            @Override
            public void Execute() throws Null_Unit_ID_Exception {

            }
        };
        assertNotNull(badCommand);*/
    }

    /**
     *  Test Case ID: 7.11
     *  Purpose: Type Test of the priority attribute with String.
     *  Preconditions: Command file compiles and constructor can be called.
     *  Expected Output: A Command object should not be created and should gracefully fail.
     *  NOTE: Compiler would not allow. TEST PASSED
     */
    @Test
    public void testCommandwString() throws Exception {
       /* badCommand= new Command(testString, testString) {
            @Override
            public void Execute() throws Null_Unit_ID_Exception {

            }
        };
        assertNotNull(badCommand);*/
    }

    /**
     *  Test Case ID: 7.12
     *  Purpose: Integer Test of the priority attribute with 2^32. This will test the initialization of the Command with one plus the max Integer.
     *  Preconditions: Command must be initialized.
     *  Expected Output: A Command Object should not be created and should gracefully fail.
     *  NOTE: TEST FAILED. Command created with Integer overflow
     */
    @Test
    public void testCommandwXlargeInt() throws Exception {
        badCommand = new Command(testIntXLarge + 10, testString) {
            @Override
            public void Execute() throws Null_Unit_ID_Exception {

            }
        };
        System.out.print(testIntXLarge);
        System.out.print(badCommand.Priority());
        assertNotNull(badCommand);
    }

    /**
     *  Test Case ID: 7.13
     *  Purpose: Integer Test of the priority attribute with -2^31-1. This will test the initialization of the Command with one minus the min Integer.
     *  Preconditions: Command must be initialized.
     *  Expected Output: A Command Object should not be created and should gracefully fail.
     *  NOTE: TEST FAILED. Command created with Integer overflow
     */
    @Test
    public void testCommandwXSmallInt() throws Exception {
        badCommand = new Command(testIntXSmall - 10, testString) {
            @Override
            public void Execute() throws Null_Unit_ID_Exception {

            }
        };
        System.out.print(badCommand.Priority());
        assertNotNull(badCommand);
    }

    /**
     *  Test Case ID: 7.14
     *  Purpose: Integer Test of the priority attribute with 2^32. This will test the SetCommand function with one plus the max Integer.
     *  Preconditions: Command must be initialized.
     *  Expected Output: A Command Object should not be created and should gracefully fail.
     *  NOTE: TEST FAILED. Priority created with Integer overflow
     */
    @Test
    public void testSet_PrioritywBigPositive() throws Exception {
        goodCommand.Set_Priority(testIntXLarge + 1);
        System.out.print(goodCommand.Priority());
    }

    /**
     *   Test Case ID: 7.15
     *   Purpose: Integer Test of the priority attribute with -2^31-1. This will test the SetCommand function with one minus the min Integer.
     *   Preconditions: Command must be initialized.
     *   Expected Output: A Command Object should not be created and should gracefully fail.
     *  NOTE: TEST FAILED. Command created with Integer overflow
     */
    @Test
    public void testSet_PrioritywNegative() throws Exception {
        goodCommand.Set_Priority(testIntXSmall - 1);
        System.out.print(goodCommand.Priority());
    }

    /**
     *  Test Case ID: 7.16
     *  Purpose: Type Test of the Unit_ID attribute with Integer.
     *  Preconditions: Command must be initialized.
     *  Expected Output: A Command Object should not be created and should gracefuly fail.
     *  NOTE: Compiler would not allow. TEST PASSED
     */
    @Test
    public void testSet_Unit_IDwInteger() throws Exception {
        //goodCommand.Set_Unit_ID(testInt);

    }

    /**
     *  Test Case ID: 7.17
     *  Purpose: Type Test of the Unit_ID attribute with Long.
     *  Preconditions: Command must be initialized.
     *  Expected Output: A Command Object should not be created and should gracefuly fail.
     *  NOTE: Compiler would not allow. TEST PASSED
     */
    @Test
    public void testSet_Unit_IDwLong() throws Exception {
        // goodCommand.Set_Unit_ID(testLong);
    }

    /**
     *  Test Case ID: 7.18
     *  Purpose: Type Test of the Unit_ID attribute with Double.
     *  Preconditions: Command must be initialized.
     *  Expected Output: A Command Object should not be created and should gracefuly fail.
     *  NOTE: Compiler would not allow. TEST PASSED
     */
    @Test
    public void testSet_Unit_IDwDouble() throws Exception {
        //goodCommand.Set_Unit_ID(testDouble);
    }

    /**
     *  Test Case ID: 7.19
     *  Purpose: Type Test of the Unit_ID attribute with Float.
     *  Preconditions: Command must be initialized.
     *  Expected Output: A Command Object should not be created and should gracefuly fail.
     *  NOTE: Compiler would not allow. TEST PASSED
     */
    @Test
    public void testSet_Unit_IDwFloat() throws Exception {
        //goodCommand.Set_Unit_ID(testFloat);
    }

    /**
     *  Test Case ID: 7.20
     *  Purpose: Test IsHigherPriorityThen negative path with a command of lower priority.
     *  Preconditions: 2 Commands are initialized. One with higher priority than other.
     *  Expected Output: False
     * @throws Exception
     */
    @Test
    public void testIs_Higher_Priority_ThenAgain() throws Exception {
        badCommand= new Command(testInt,testString) {
            @Override
            public void Execute() throws Null_Unit_ID_Exception {

            }
        };
        goodCommand.Set_Priority(testPriorityLow);
        badCommand.Set_Priority(testPriorityHigh);
        boolean priority = goodCommand.Is_Higher_Priority_Then(badCommand);
        assertFalse(priority);
    }

}