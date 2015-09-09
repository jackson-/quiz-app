package com.quiz.devin.quiz;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.TextView;

import models.Problem;
import models.ProblemGroup;

public class ProblemActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem);
        Intent intent = getIntent();
        ProblemGroup problem_group = (ProblemGroup)intent.getParcelableExtra("ProblemGroup");
        int current_question = problem_group.getCurrentProblemId();
        Problem problem = problem_group.getProblem(current_question);
        TextView question_view = (TextView) findViewById(R.id.question_text);
        RadioButton choice_1_view = (RadioButton) findViewById(R.id.choice_1_button);
        RadioButton choice_2_view = (RadioButton) findViewById(R.id.choice_2_button);
        RadioButton choice_3_view = (RadioButton) findViewById(R.id.choice_3_button);
        RadioButton choice_4_view = (RadioButton) findViewById(R.id.choice_4_button);
        question_view.setText(problem.getmQuestion());
        choice_1_view.setText(problem.getmChoice1());
        choice_2_view.setText(problem.getmChoice2());
        choice_3_view.setText(problem.getmChoice3());
        choice_4_view.setText(problem.getmChoice4());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_problem, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
