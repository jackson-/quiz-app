package com.quiz.devin.quiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import models.Problem;
import models.ProblemGroup;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner) findViewById(R.id.choice_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.choice_num_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        Button add_button = (Button) findViewById(R.id.add_button);
        View.OnClickListener add_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView question_view = (TextView) findViewById(R.id.question_text);
                String question_text = question_view.getText().toString();
                TextView choice_1_view = (TextView) findViewById(R.id.choice_1_text);
                String choice_1_text = choice_1_view.getText().toString();
                TextView choice_2_view = (TextView) findViewById(R.id.choice_2_text);
                String choice_2_text = choice_2_view.getText().toString();
                TextView choice_3_view = (TextView) findViewById(R.id.choice_3_text);
                String choice_3_text = choice_3_view.getText().toString();
                TextView choice_4_view = (TextView) findViewById(R.id.choice_4_text);
                String choice_4_text = choice_4_view.getText().toString();
                Spinner answer_group = (Spinner) findViewById(R.id.choice_spinner);
                String answer_text = answer_group.getSelectedItem().toString();
                ParseObject problem = new ParseObject("problem");
                problem.put("question", question_text);
                problem.put("choice_1", choice_1_text);
                problem.put("choice_2", choice_2_text);
                problem.put("choice_3", choice_3_text);
                problem.put("choice_4", choice_4_text);
                int answer_int = Integer.parseInt(answer_text);
                problem.put("answer", answer_int);
                problem.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Congrats your problem has been saved!")
                                .setTitle("Success")
                                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });

            }
        };
        add_button.setOnClickListener(add_listener);
        Button start_button = (Button) findViewById(R.id.start_test_button);
        View.OnClickListener start_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParseQuery<ParseObject> query = ParseQuery.getQuery("problem");
                query.setLimit(1000);
                query.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> problems, ParseException e) {
                        if( problems.size() > 0 ){
                            List<Problem> problem_list = new ArrayList<Problem>();
                            for (ParseObject problem : problems) {
                                Problem new_problem = new Problem(problem.get("question").toString(),
                                        problem.get("choice_1").toString(),
                                        problem.get("choice_2").toString(),
                                        problem.get("choice_3").toString(),
                                        problem.get("choice_4").toString(),
                                        Integer.parseInt(problem.get("answer").toString())
                                );
                                problem_list.add(new_problem);
                                Log.d("TAG OVER HERE", problem_list.toString());
                            }
                            ProblemGroup problem_group = new ProblemGroup(problem_list);
                            Intent intent = new Intent(MainActivity.this, ProblemActivity.class);
                            intent.putExtra("ProblemGroup", (Parcelable) problem_group);
                            startActivity(intent);
                        }
                    }
                });
            }
        };
        start_button.setOnClickListener(start_listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
