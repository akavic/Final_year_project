package com.example.bobby_000.dcu_orientation;

import android.app.Instrumentation;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.test.ServiceTestCase;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static android.content.res.Resources.getSystem;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest {

    private static final String Test_String = "IS A LINK DETECTED academic skills";



    @Test
    public void testaddingitemstoxml()
    {
        //testing to see if the values are read in and if array is not null
        List<XmlPull> values = new ArrayList<>();
        XmlPull value1 = new XmlPull();
        value1.setTitle("THIS IS FIRST OBJECT");
        value1.setMain_content("VALUE OF FIRST OBJECT");
        XmlPull value2 =new XmlPull();
        value2.setTitle("THIS IS SECOND OBJECT");
        value2.setMain_content("VALUE OF SECOND OBJECT");
        values.add(value1);
        values.add(value2);

        assertNotNull(values);
        assertEquals("THIS IS SECOND OBJECT",value2.getTitle());
    }
    /*
    @Test
    public void testAddingLink()
    {
        //test to see if you can add links
        TextView view = new TextView(getTestContext());
        view.setText(Test_String);
        LinksPattern.addLinks(view);
    }*/
    @Test
    public void testcontextReadinFile()
    {

        XMLPullParserHandler val = new XMLPullParserHandler();
        //test to see if the app context reads in the file
        AssetManager mngr =App.getContext().getAssets();

        try {
            ArrayList<XmlPull>  xmlVal = (ArrayList<XmlPull>) val.parse(mngr.open("file.xml"));
            assertNotNull(xmlVal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testisresourceaccessed(){
        //test to see if the resources is being accessed by APP
         String mystring = App.getContext().getResources().getString(R.string.answer_1);
       // int mystring=R.string.answer_1;
        //assertEquals("Two",mystring);
        assertNotNull(mystring);
    }

    @Test
    public void testdataisfilled1() throws Exception {
        // test data is filled with week1
        // ran logs to see if data is being read
        Pattern assignment_writting2= Pattern.compile(".*\\borientationWeek1\\b.*");
      //  assertNotNull(ExtractValues.fill(assignment_writting2));

    }


    @Test
    public void testwk1focusthisweek() throws Exception {
        // (Failed)no args consturctor not reading in the file probably due to the something to do with context

        /*".*\\borientationWeek1\\b.*"
        ".*\\borientationWeek2\\b.*"
        ".*\\borientationWeek3\\b.*"
        ".*\\borientationWeek4\\b.*"
        ".*\\borientationWeek5\\b.*"
         */
        ExtractValues values = new ExtractValues();
        assertNotNull("VALUES",values.getFocus_this_week(".*\\borientationWeek1\\b.*"));
    }
    @Test
    public void testquestionandanswer()
    {
        // testing the question class
        Question [] questions ={new Question(R.string.question_1, R.id.option_2,R.string.answer_1),
                new Question(R.string.question_2, R.id.option_2,R.string.answer_2),
                new Question(R.string.question_3, R.id.option_3,R.string.answer_3),};

        Question question =new Question(R.string.question_3, R.id.option_3,R.string.answer_3);

        assertEquals(R.string.question_3,question.getTextResId());
        assertNotNull(questions);
    }




}