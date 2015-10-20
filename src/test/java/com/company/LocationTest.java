package com.company;

import com.company.Location;
import com.company.Null_Object_Exception;
import junit.framework.TestCase;
import junit.framework.TestResult;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by benhoelzel on 10/15/15.
 */
public class LocationTest  {
//public final void Set_Location(float New_Latitude, float New_Longitude) throws Null_Object_Exception
    /*
    Test Case ID: 9.01
    Purpose: Test good location. New_latitude = -80.0, New_longitude = -100.0
    Preconditions: None
    Postconditions: Location object to have new values assigend for Latitude and Longitude
    Expected Output: None expected
    */
    @Test
    public void testValidLatitudeLongitudeConstructor() {
        Location test = new Location(-80.0f,-100.0f);

    }
    /*
    Test Case ID: 9.--
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
    TTest Case ID: 9.--
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
    Test Case ID: 9.--
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
    Test Case ID: 9.--
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
    Test Case ID: 9.--
    Purpose: Test good New_latitude value, bad longitude value. i.e. New_latitude = -88.0000000000, New_longitude = -1280.0000000000
    Preconditions: None
    Postconditions: Location object to have new values assigend for Latitude and Longitude
    Expected Output: Null Object Exception
    */
    @Test(expected = Null_Object_Exception.class)//we are saying we expect the exception per the code
    public void testBadLongitudeForConstructor () {
        Location test = new Location(-80.0f, 1000.0f);

    }


    //later dude
        @Test(expected = Null_Object_Exception.class)//we are saying we expect the exception per the code
        public void testBadLatituggggdeForConstructor () {
            Location test = new Location(-80000.0f, -100.0f);

        }
//    //tearDown used to close the connection or clean up activities

    public void tearDown() {
    }
}






/*
Test Case ID: 9.--
Purpose: Test good New_Logtitude value. i.e. New_latitude = -1188.0000000000, New_longitude = -175.0000000000
Preconditions: None
Postconditions: Location object to have new values assigend for Latitude and Longitude
Expected Output: Null Object Exception
*/

/*
Test Case ID: 9.--
Purpose: Test with string value for input. i.e. "Ninety"...
Preconditions: None
Postconditions: None expected
Expected Output: Compile error
*/



//public Location (float New_Latitude, float New_Longitude) throws Null_Object_Exception
/*
Test Case ID: 9.--
Purpose: Test with empty paramater list
Preconditions: None
Postconditions: None expected
Expected Output: Null Object Exception
*/

/*
Test Case ID: 9.--
Purpose: Test with string value for input. i.e. "Ninety"...
Preconditions: None
Postconditions: None expected
Expected Output: Compile error
*/

/*????
Same test as setter?
*/

//public float Current_Longitude ()

/*
Test Case ID: 9.--
Purpose: Test when object has good Longititude value
Preconditions: None
Postconditions: None expected
Expected Output: Compile error
*/

/*
Test Case ID: 9.--
Purpose: Test when object contains Longitude = Null value
Preconditions: None
Postconditions: None expected
Expected Output: Compile error
*/

/*
Test Case ID: 9.--
Purpose: Test when object is null
Preconditions: None
Postconditions: None expected
Expected Output: Null Object Exception
*/

//public float Current_Latitude ()

/*
Test Case ID: 9.--
Purpose: Test when object has good Latitude value
Preconditions: None
Postconditions: None expected
Expected Output: Compile error
*/

/*
Test Case ID: 9.--
Purpose: Test when object contains Latitude = Null value
Preconditions: None
Postconditions: None expected
Expected Output: Compile error
*/

/*
Test Case ID: 9.--
Purpose: Test when object is null
Preconditions: None
Postconditions: None expected
Expected Output: Null Object Exception
*/













