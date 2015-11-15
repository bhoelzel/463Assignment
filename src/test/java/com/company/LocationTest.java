/*******************************************************************************************************
 *       Location Test
 *       Description of test sequence:
 *       Positive path constructor test
 *       Positive getter tests
 *       Positive / negative setter tests
 *       Positive / negative constructor tests
 *******************************************************************************************************/

//TODO: add the negative getters, they fail complie. Can I do out of sequence test? What about test sequence in Junit

package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class LocationTest  {
    //Test parameters used in tests
    static float good_latitude = -80.0f;
    static float good_longitude = -100.0f;
    Location test_object;

    //Positive path constructor test
    /*
    Test Case ID: 4.01
    Purpose: Test initialise with good location.
    Preconditions: None
    Expected Result: Location object to have new values assigned for Latitude and Longitude
    */
    @Before
    @Test
    public void setUp(){
        test_object = new Location(good_latitude, good_longitude);
    }

    //Positive path getter tests
    /*
    Test Case ID: 4.02
    Purpose: Test getter when object has good Latitude value
    Preconditions: Test_Object has been initialised with default test values
    Expected result: Return the proper latitude value
    */
    @Test
    public void testLatitudeGetter(){
        assertThat(test_object.Current_Latitude(), is(equalTo(good_latitude)));
    }

    /*
    Test Case ID: 4.03
    Purpose: Test when object has good Longitude value
    Preconditions: Test_Object has been initialised with default test values
    Expected result: Return the proper longitude value
    */
    @Test
    public void testLongitudeGetter(){
        assertThat(test_object.Current_Longitude(), is(equalTo(good_longitude)));
    }

    /*
    Test Case ID: 4.04
    Purpose: Test when object = Null value
    Preconditions: test_object is set to null
    Expected Result: Null Pointer Exception
    */
    @Test (expected = NullPointerException.class)
    public void testLocationWithNullValue(){
        Location temp = test_object;
        test_object = null;
        test_object.Current_Latitude();
        test_object = temp;
        temp = null;
    }

    //Positive / negative path setter tests
    /*
    Test Case ID: 4.05
    Purpose: Test change to good location.
    Preconditions: Object has been initialised
    Expected Result: Location object to have new values assigned for Latitude and Longitude
    */
    @Test
    public void testChangingLatitude(){
        float test_latitude = 80.0f;
        float test_longitude = 100.0f;
        test_object.Set_Location(test_latitude,test_longitude);
        assertThat(test_object.Current_Latitude(), is(equalTo(test_latitude)));
        assertThat(test_object.Current_Longitude(), is(equalTo(test_longitude)));
    }

    /*
    Test Case ID: 4.06
    Purpose: Test good location that has larger precision.
    Preconditions: Object has been initialised with good values
    Expected Result: Location object to have new values assigned for Latitude and Longitude
    */
    @Test
    public void testValidLatitudeLongitudeLargePrecision() {
        float test_latitude = 75.123456789f;
        float test_longitude = 10.00000000000001f;
        test_object.Set_Location(test_latitude,test_longitude);
        assertThat(test_object.Current_Latitude(), is(equalTo(test_latitude)));
        assertThat(test_object.Current_Longitude(), is(equalTo(test_longitude)));
    }

    /*
    TTest Case ID: 4.07
    Purpose: Test good integer value location. New_latitude = -80, NewLongitude = 10
    Preconditions: Object has been initialised with good values
    Expected Result: Location object to have new float values assigned for Latitude and Longitude
    */
    @Test
    public void testValidLatitudeLongitudeWithInt() {
        int test_latitude = -80;
        int test_longitude = 10;
        //Java allows widening primitive conversion, it should be safe per Java
        test_object.Set_Location(test_latitude, test_longitude);
        //Narrow primitive conversion will lose precision, but we have none as we converted from integer and the danger is from float to double
        assertThat(test_object.Current_Latitude(), is(equalTo((float)test_latitude)));
        assertThat(test_object.Current_Longitude(), is(equalTo((float)test_longitude)));
    }

    /*
    TTest Case ID: 4.08
    Purpose: Test good double location.
    Preconditions: Object has been initialised with good values
    Expected Result: Location object to have new values assigned for Latitude and Longitude
    */
    @Test
    public void testValidLatitudeLongitudeWithDouble() {
        double test_latitude = -80.0000011;
        double test_longitude = 10.0000011;
        //Java allows narrowing primitive conversion, it may not be safe per Java!
        test_object.Set_Location((float)test_latitude, (float)test_longitude);
        assertThat((double)test_object.Current_Latitude(), is(equalTo(test_latitude)));
        assertThat((double)test_object.Current_Longitude(), is(equalTo(test_longitude)));
    }


    /*
    Test Case ID: 4.09
    Purpose: Test out of bound location. i.e. New_latitude = -91, NewLongitude = 181
    Preconditions:  Object has been initialised with good values
    Expected Result: Null Object Exception
    */
    @Test(expected = Null_Object_Exception.class)
    public void testOutOfBoundLatitudeLongitude() {
        float test_latitude = -91.0f;
        float test_longitude = 181.0f;
        test_object.Set_Location(test_latitude , test_longitude );
        assertThat(test_object.Current_Latitude(), is(equalTo(test_latitude)));
        assertThat(test_object.Current_Longitude(), is(equalTo(test_longitude)));
    }

    /*
    Test Case ID: 4.10
    Purpose: Test border locations.
    Preconditions: Object has been initialised with good values
    Expected Output: Location object to have new values assigned for Latitude and Longitude
    */
    @Test
    public void testBoarderLatitudeLongitude() {
        float test_latitude = -90.0f;
        float test_longitude = 180.0f;
        test_object.Set_Location(test_latitude, test_longitude);
        assertThat(test_object.Current_Latitude(), is(equalTo(test_latitude)));
        assertThat(test_object.Current_Longitude(), is(equalTo(test_longitude)));
    }

    /*
    Test Case ID: 4.11
    Purpose: Test good New_latitude value, bad longitude value.
    Preconditions: Object has been initialised with good values
    Expected Result: Null Object Exception
    */
    @Test(expected = Null_Object_Exception.class)
    public void testBadLongitude() {
        float test_latitude = -80.0f;
        float test_longitude = 1000.0f;
        test_object.Set_Location(test_latitude,test_longitude);
        assertThat(test_object.Current_Latitude(), is(equalTo(test_latitude)));
        assertThat(test_object.Current_Longitude(), is(equalTo(test_longitude)));
    }

    /*
    Test Case ID: 4.12
    Purpose: Test bad New_Longitude, good New_Longitude value.
    Preconditions: None
    Expected Result: Null Object Exception
    */
    @Test(expected = Null_Object_Exception.class)
    public void testBadLatitude() {
        float test_latitude = -80000.0f;
        float test_longitude = -100.0f;
        test_object.Set_Location(test_latitude,test_longitude);
        assertThat(test_object.Current_Latitude(), is(equalTo(test_latitude)));
        assertThat(test_object.Current_Longitude(), is(equalTo(test_longitude)));
    }

    //Positive / negative path constructor tests
    /*
    Test Case ID: 4.13
    Purpose: Test good location that has larger precision.
    Preconditions: None
    Expected Output: Location object created with new values assigend for Latitude and Longitude
    */
    @Test
    public void testValidLatitudeLongitudeLargePrecisionConstructor() {
        float test_latitude = 75.123456789f;
        float test_longitude = 10.00000000000001f;
        Location test = new Location(test_latitude,test_longitude);
        assertThat(test.Current_Latitude(), is(equalTo(test_latitude)));
        assertThat(test.Current_Longitude(), is(equalTo(test_longitude)));
    }

    /*
    TTest Case ID: 4.14
    Purpose: Test good int value location.
    Preconditions: None
    Expected Result: Location object created with new values assigend for Latitude and Longitude
    */
    @Test
    public void testValidLatitudeLongitudeWithIntConstructor() {
        int test_latitude = -80;
        int test_longitude = 10;
        //Java allows widening primitive conversion, it should be safe per Java
        Location test = new Location(test_latitude, test_longitude);
        //Narrow primitive conversion will lose precision, but we have none as we converted from integer and the danger is from float to double
        assertThat(test.Current_Latitude(), is(equalTo((float)test_latitude)));
        assertThat(test.Current_Longitude(), is(equalTo((float)test_longitude)));
    }

    /*
    TTest Case ID: 4.15
    Purpose: Test good double location during construction.
    Preconditions: Object has been initialised with good values
    Expected Result: Location object to have new values assigned for Latitude and Longitude
    */
    @Test
    public void testValidLatitudeLongitudeWithDoubleConstructor() {
        double test_latitude = -12.0000011;
        double test_longitude = 10.0000011;
        //Java allows narrowing primitive conversion, it may not be safe per Java!
        Location test = new Location((float)test_latitude, (float)test_longitude);
        assertThat((double)test.Current_Latitude(), is(equalTo(test_latitude)));
        assertThat((double)test.Current_Longitude(), is(equalTo(test_longitude)));
    }


    /*
    Test Case ID: 4.16
    Purpose: Test out of bound location.
    Preconditions: None
    Expected Result: Null Object Exception
    */
    @Test(expected = Null_Object_Exception.class)
    public void testOutOfBoundLatitudeLongitudeConstructor() {
        float test_latitude = -91.0f;
        float test_longitude = 181.0f;
        Location test = new Location(test_latitude,test_longitude);
        assertThat(test.Current_Latitude(), is(equalTo(test_latitude)));
        assertThat(test.Current_Longitude(), is(equalTo(test_longitude)));
    }

    /*
    Test Case ID: 4.17
    Purpose: Test border locations.
    Preconditions: None
    Expected Result: Location object created with new values assigend for Latitude and Longitude
    */
    @Test
    public void testBoarderLatittudeLongitudeConstructor() {
        float test_latitude = -90.0f;
        float test_longitude = 180.0f;
        Location test = new Location(test_latitude,test_longitude);
        assertThat(test.Current_Latitude(), is(equalTo(test_latitude)));
        assertThat(test.Current_Longitude(), is(equalTo(test_longitude)));
    }

    /*
    Test Case ID: 4.18
    Purpose: Test good New_latitude value, bad longitude value.
    Preconditions: None
    Expected Result: Null Object Exception
    */
    @Test(expected = Null_Object_Exception.class)
    public void testBadLongitudeForConstructor () {
        float test_latitude = -80.0f;
        float test_longitude = 1000.0f;
        Location test = new Location(test_latitude,test_longitude);
        assertThat(test.Current_Latitude(), is(equalTo(test_latitude)));
        assertThat(test.Current_Longitude(), is(equalTo(test_longitude)));
    }

    /*
    Test Case ID: 4.19
    Purpose: Test good New_Longitude value.
    Preconditions: None
    Expected Result: Null Object Exception
    */
    @Test(expected = Null_Object_Exception.class)
    public void testBadLatitudeForConstructor () {
        float test_latitude = -1188.0000000000f;
        float test_longitude = -175.00000000000f;
        Location test = new Location(test_latitude,test_longitude);
        assertThat(test.Current_Latitude(), is(equalTo(test_latitude)));
        assertThat(test.Current_Longitude(), is(equalTo(test_longitude)));
    }

    /*
    Test Case ID: 4.20
    Purpose: Test with empty paramater list
    Preconditions: None
    Expected Result: Compiler Error
    */
//    @Test(expected = Null_Object_Exception.class)
//    public void testEmptyParamterList(){
//        Location test = new Location();
//    }

    /*
    Test Case ID: 4.21
    Purpose: Test with string value for input. i.e. "Ninety"...
    Preconditions: None
    Expected Result: Compiler error
    */
//    @Test(expected = Null_Object_Exception.class)
//    public void testEmptyParamterList("Ninety","Eighty"){
//        Location test = new Location();
//    }

    //tearDown used to close the connection or clean up activities
    @After
    public void tearDown() throws Exception {
        test_object = null;

    }




}





















