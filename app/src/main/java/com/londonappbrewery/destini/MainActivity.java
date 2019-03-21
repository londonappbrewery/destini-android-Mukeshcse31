package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    int currentStory = 0;
    TextView story;
    Button top;
    Button bottom;
    QA[] qA = new QA[]{
            new QA(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
            new QA(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
            new QA(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2),
            new QA(R.string.T4_End, 0, 0),
            new QA(R.string.T5_End, 0, 0),
            new QA(R.string.T6_End, 0, 0)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//set the next path for all the current stories
        qA[0].setNext1(3);
        qA[0].setNext2(2);
        qA[1].setNext1(3);
        qA[1].setNext2(4);
        qA[2].setNext1(6);
        qA[2].setNext2(5);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        story = (TextView) findViewById(R.id.storyTextView);
        top = (Button) findViewById(R.id.buttonTop);
        bottom = (Button) findViewById(R.id.buttonBottom);

        //Recovery or re-draw
        /*if (savedInstanceState != null) {
            currentStory = (int) savedInstanceState.get("currentStory");
        }*/

        nextStory(1);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextStory(qA[currentStory].getNext1());
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextStory(qA[currentStory].getNext2());
            }
        });

    }

    public void nextStory(int applyStory) {
        currentStory = applyStory - 1;
        story.setText(qA[currentStory].getQues());
        if (qA[currentStory].getAns1() == 0) { // reaches the end
            /*top.setText("end");
            bottom.setText("end");
            */

            //takes space on the screen
            top.setVisibility(View.INVISIBLE);
            bottom.setVisibility(View.INVISIBLE);

            //takes no space on the screen
            top.setVisibility(View.GONE);
            bottom.setVisibility(View.GONE);


        } else {
            top.setText(qA[currentStory].getAns1());
            bottom.setText(qA[currentStory].getAns2());
        }
    }
/*

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("currentStory", currentStory);
    }
*/
}
