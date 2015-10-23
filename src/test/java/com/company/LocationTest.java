package com.company;

/*

1. testing exceptions
2. test constructor before setter
3. test getting bad values when fields are private

Pre-req should include any pre tested units and methods?

 */

import com.company.Location;
import com.company.Null_Object_Exception;
import junit.framework.TestCase;
import junit.framework.TestResult;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by benhoelzel on 10/15/15.
 */
public class LocationTest  {
    //Test parameters
    float good_latitude = -80.0f;
    float good_longitude = -100.0f;
    Location test_object;

    //Test constructor
    /*
    Test Case ID: 4.01
    Purpose: Test initialise with good location. New_latitude = -80.0, New_longitude = -100.0
    Preconditions: None
    Postconditions: Location object to have new values assigned for Latitude and Longitude
    Expected Output: None expected
    */
    @Before
    public void setUp(){
        test_object = new Location(good_latitude, good_longitude);
    }

    //Testing getter method
    /*
    Test Case ID: 4.02
    Purpose: Test when object has good Latitude value
    Preconditions: Test_Object has been initialised with default test values
    Postconditions: None expected
    Expected Output: None
    */
    @Test
    public void testLatitudeGetter(){
        assertThat(test_object.Current_Latitude(), is(equalTo(good_latitude)));
    }

    /*
    Test Case ID: 4.03
    Purpose: Test when object has good Longitude value
    Preconditions: Test_Object has been initialised with default test values
    Postconditions: None expected
    Expected Output: None
    */
    @Test
    public void testLongitudeGetter(){
        assertThat(test_object.Current_Longitude(), is(equalTo(good_longitude)));
    }

    /*
    Test Case ID: 4.04
    Purpose: Test when object = Null value
    Preconditions: test_object is set to null
    Postconditions: None expected
    Expected Output: NPE
    */
    @Test (expected = NullPointerException.class)// It will give NPE
    public void testLocationWithNullValue(){
        Location temp = test_object;
        test_object = null;
        System.out.println(test_object.Current_Latitude());
        //assertThat(test_object, is(nullValue()));
        test_object = temp;
    }

    //Testing the setter method
    /*
    Test Case ID: 4.05
    Purpose: Test change to good location. New_latitude = 80.0, New_longitude = 100.0
    Preconditions: Object has been initialised
    Postconditions: Location object to have new values assigned for Latitude and Longitude
    Expected Output: None expected
    */
    @Test
    public void testChangingLatitude(){
        test_object.Set_Location(80.0f,100.0f);
    }

    /*
    Test Case ID: 4.06
    Purpose: Test good location that has larger precision. New_latitude = 75.123456789, NewLongitude = 10.00000000000001
    Preconditions: Object has been initialised with good values
    Postconditions: Location object to have new values assigend for Latitude and Longitude
    Expected Output: None expected
    */
    @Test
    public void testValidLatitudeLongitudeLargePrecision() {
        test_object.Set_Location(75.123456789f, 10.00000000000001f);
    }

    /*
    TTest Case ID: 4.07
    Purpose: Test good int value location. New_latitude = -80, NewLongitude = 10
    Preconditions: Object has been initialised with good values
    Postconditions: Location object to have new values assigend for Latitude and Longitude
    Expected Output: None expected
    */
    @Test
    public void testValidLatitudeLongitudeWithInt() {
        test_object.Set_Location(-80, 10.0f);
        assertThat(test_object.Current_Latitude(), is(equalTo(-80.0f)));
    }
    /*
    Test Case ID: 4.08
    Purpose: Test out of bound location. i.e. New_latitude = -91, NewLongitude = 181
    Preconditions:  Object has been initialised with good values
    Postconditions: None expected
    Expected Output: Null Object Exception
    */
    @Test(expected = Null_Object_Exception.class)//we are saying we expect the exception per the code
    public void testOutOfBoundLatitudeLongitude() {
        test_object.Set_Location(good_latitude,good_longitude);
        test_object.Set_Location(-91.0f, 181.0f);
//        System.out.print(test.Current_Latitude());
//        assertThat(test.Current_Latitude(), is(equalTo(-80.0f)));
    }

    /*
    Test Case ID: 4.09
    Purpose: Test border locations. i.e. New_latitude = -90.0000000000, NewLongitude = 180.0000000000
    Preconditions: Object has been initialised with good values
    Postconditions: Location object to have new values assigend for Latitude and Longitude
    Expected Output: None
    */
    @Test
    public void testBoarderLatittudeLongitude() {

        test_object.Set_Location(good_latitude,good_longitude);
        test_object.Set_Location(-90.0f, 180.0f);
        assertThat(test_object.Current_Latitude(), is(equalTo(-90.0f)));
        assertThat(test_object.Current_Longitude(), is(equalTo(180.0f)));
    }

    /*
    Test Case ID: 4.10
    Purpose: Test good New_latitude value, bad longitude value. i.e. New_latitude = -88.0000000000, New_longitude = -1280.0000000000
    Preconditions: Object has been initialised with good values
    Postconditions: Location object to have new values assigend for Latitude and Longitude
    Expected Output: Null Object Exception
    */
    @Test(expected = Null_Object_Exception.class)//we are saying we expect the exception per the code
    public void testBadLongitude() {
        test_object.Set_Location(good_latitude, good_longitude);
        test_object.Set_Location(-80.0f, 1000.0f);
    }

    /*
    Test Case ID: 4.11
    Purpose: Test bad New_Longitude, good New_Longitude value. i.e. New_latitude = -1188.0000000000, New_longitude = -175.0000000000
    Preconditions: None
    Postconditions: Location object to have new values assigend for Latitude and Longitude
    Expected Output: Null Object Exception
    */
    @Test(expected = Null_Object_Exception.class)//we are saying we expect the exception per the code
    public void testBadLatitude() {
        test_object.Set_Location(good_latitude,good_longitude);
        test_object.Set_Location(-80000.0f, -100.0f);

    }

    //Further testing constructor
    /*
    Test Case ID: 4.12
    Purpose: Test good location that has larger precision. New_latitude = 75.123456789, NewLongitude = 10.00000000000001
    Preconditions: None
    Postconditions: Location object to have new values assigend for Latitude and Longitude
    Expected Output: None expected
    */
    @Test
    public void testValidLatitudeLongitudeLargePrecisionConstructor() {
        Location test = new Location(75.123456789f, 10.00000000000001f);
    }

    /*
    TTest Case ID: 4.13
    Purpose: Test good int value location. New_latitude = -80, NewLongitude = 10
    Preconditions: None
    Postconditions: Location object to have new values assigend for Latitude and Longitude
    Expected Output: None expected
    */
    @Test
    public void testValidLatitudeLongitudeWithIntConstructor() {
        Location test = new Location(-80, 10);
        System.out.print(test.Current_Latitude());
        assertThat(test.Current_Latitude(), is(equalTo(-80.0f)));
    }

    /*
    Test Case ID: 4.14
    Purpose: Test out of bound location. i.e. New_latitude = -91, NewLongitude = 181
    Preconditions: None
    Postconditions: None expected
    Expected Output: Null Object Exception
    */
    @Test(expected = Null_Object_Exception.class)//we are saying we expect the exception per the code
    public void testOutOfBoundLatitudeLongitudeConstructor() {
        Location test = new Location(-91.0f, 181.0f);
//        System.out.print(test.Current_Latitude());
//        assertThat(test.Current_Latitude(), is(equalTo(-80.0f)));
    }

    /*
    Test Case ID: 4.15
    Purpose: Test border locations. i.e. New_latitude = -90.0000000000, NewLongitude = 180.0000000000
    Preconditions: None
    Postconditions: Location object to have new values assigend for Latitude and Longitude
    Expected Output: None
    */
    @Test
    public void testBoarderLatittudeLongitudeConstructor() {
        Location test = new Location(-90.0f, 180.0f);
    }
    /*
    Test Case ID: 4.16
    Purpose: Test good New_latitude value, bad longitude value. i.e. New_latitude = -88.0000000000, New_longitude = -1280.0000000000
    Preconditions: None
    Postconditions: Location object to have new values assigend for Latitude and Longitude
    Expected Output: Null Object Exception
    */
    @Test(expected = Null_Object_Exception.class)//we are saying we expect the exception per the code
    public void testBadLongitudeForConstructor () {
        Location test = new Location(-80.0f, 1000.0f);

    }

    /*
    Test Case ID: 4.17
    Purpose: Test good New_Longitude value. i.e. New_latitude = -1188.0000000000, New_longitude = -175.0000000000
    Preconditions: None
    Postconditions: Location object to have new values assigend for Latitude and Longitude
    Expected Output: Null Object Exception
    */
    @Test(expected = Null_Object_Exception.class)//we are saying we expect the exception per the code
    public void testBadLatitudeForConstructor () {
        Location test = new Location(-1188.0000000000f, -175.00000000000f);

    }

    /*
    Test Case ID: 4.18
    Purpose: Test with empty paramater list
    Preconditions: None
    Postconditions: None expected
    Expected Output: Compiler Error
    */
//    @Test(expected = Null_Object_Exception.class)
//    public void testEmptyParamterList(){
//        Location test = new Location();
//    }

    /*
    Test Case ID: 4.19
    Purpose: Test with string value for input. i.e. "Ninety"...
    Preconditions: None
    Postconditions: None expected
    Expected Output: Compiler error
    */
//    @Test(expected = Null_Object_Exception.class)
//    public void testEmptyParamterList("Ninety","Eighty"){
//        Location test = new Location();
//    }

    //tearDown used to close the connection or clean up activities
    public void tearDown() {
        test_object = null;
    }
}





















