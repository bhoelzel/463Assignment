package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Command_ManagerTest {
    Command_Manager testManager;
    String testUnitID1="id1";
    String testUnitID2="id2";
    String testUnitID3="id3";
    String testUnitID4="id4";
    String testMessage1="Test Msg";
    String testMessage2="Test Msg2";
    Send_Message_To_Operator_Command testCommand1;
    Send_Message_To_Operator_Command testCommand2;
    Set_Unit_Status_Command testCommand3;

    @Before
    //Constuctor Test
    /**
     * Test Case ID: 13.01
     * Purpose: This will test Command_Manager constructor
     * Preconditions: Command_Manager file compiles and Command_Manger can be used.
     * Expected Output: A new Command_Manger should be created and not be NULL.
     */
    @Test
    public void testCommand_Manager() throws Exception{
        testManager= new Command_Manager();
        assertNotNull(testManager);
    }

    //Positive Path Tests
    /**
     * Test Case ID: 13.02
     * Purpose: This will test QueueEmpty to make sure it will properly handle empty queue
     * Preconditions: CommandManager is initialized and empty
     * Expected Output: True
     */
    @Test
    public void testQueue_Empty() throws Exception {
        assertTrue(testManager.Queue_Empty());
    }
    /**
     * Test Case ID: 13.03
     * Purpose:  This will test Enqueue_Command to make sure commands can be added to Command_Manager.
     * Preconditions: Command_Manager is initialized. Test Uses Send_Message_To_Operator_Command and assumes it has been tested and works correctly.
     * Expected Output: Command_Manager Queue should work as expected.
     */
    @Test
    public void testEnqueue_Command() throws Exception {
        testCommand1= new Send_Message_To_Operator_Command(testUnitID1,testMessage1);
        testManager.Enqueue_Command(testCommand1);
        assertFalse(testManager.Queue_Empty());
    }

    /**
     * Test Case ID: 13.04
     * Purpose:  This will test Next_Command to make sure commands are polled. It will also test Commands are entered in Queue and prioritized correctly
     * Preconditions: Command_Manager is initialized. Test Uses Send_Message_To_Operator_Command and Set_Unit_Status_Command and assumes both have been tested and work correctly.
     * Expected Output: For this test, the Command_Manager will have 3 commands, 2 Send_Message_To_Operator_Command objects and one Set_Unit_Status_Command object. Although the
     *                  Set_Unit_Status_Command was added to the Command_Manger last it should be the Command at the top.
     */
    @Test
    public void testNext_Command() throws Exception {
        testCommand2= new Send_Message_To_Operator_Command(testUnitID2, testMessage2);
        testManager.Enqueue_Command(testCommand2);
        testCommand3= new Set_Unit_Status_Command(testUnitID3, Response_Unit.Status_Type.In_Station);
        testManager.Enqueue_Command(testCommand3);
        assertEquals(testCommand3,testManager.Next_Command());
    }

    /**
     * Test Case ID: 13.05
     * Purpose: This will test ExecuteNextCommand.
     * Preconditions: Command_Manager is initialized and has at least one command. Test Uses Send_Message_To_Operator_Command and assumes it has been tested and works correctly.
     * Expected Output: For this test Command_Manager has 2 Commands, both are Send_Message_To_Operator_Command objects. Execute_Next_Command should print testMessage from Command.
     */
    @Test
    public void testExecute_Next_Command() throws Exception {
        testManager.Execute_Next_Command();
    }


    //Negative Paths
    /**
     * Test Case ID: 13.02
     * Purpose:  This will test the negative path and try to add a Float to the Queue.
     * Preconditions: Command_Manager is initialized.
     * Expected Output: Command_Manager Queue should not add a float.
     */
    @Test
    public void testEnqueue_CommandwFloat() throws Exception {

    }

    /**
     * Test Case ID: 13.03
     * Purpose:  This will test the negative path and try to add a String to the Queue.
     * Preconditions: Command_Manager is initialized.
     * Expected Output: Command_Manager Queue should not add a String.
     */
    @Test
    public void testEnqueue_CommandwString() throws Exception {

    }

    /**
     * Test Case ID: 13.04
     * Purpose:  This will test the negative path and try to add an unknown object to the Queue.
     * Preconditions: Command_Manager is initialized.
     * Expected Output: Command_Manager Queue should not add a unknown object.
     */
    @Test
    public void testEnqueue_CommandwObject() throws Exception {

    }



    /**
     * Test Case ID: 13.07
     * Purpose: This will test QueueEmpty negative path with a empty queue
     * Preconditions: CommandManager is initialized empty
     * Expected Output: True
     */
    @Test
    public void testQueue_EmptywEmpty() throws Exception {


    }
}