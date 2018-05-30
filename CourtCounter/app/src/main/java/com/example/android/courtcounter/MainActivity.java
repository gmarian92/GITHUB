package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
int pointsA=0;
int pointsB=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void scoreAThree(View v) {
        pointsA+=3;
        displayForTeamA(pointsA);
    }

    public void scoreATwo(View v){
        pointsA+=2;
        displayForTeamA(pointsA);
    }
    public void scoreAOne(View v) {
        pointsA+=1;
        displayForTeamA(pointsA);
    }
    public void scoreBThree(View v) {
        pointsB+=3;
        displayForTeamB(pointsB);
    }

    public void scoreBTwo(View v){
        pointsB+=2;
        displayForTeamB(pointsB);
    }
    public void scoreBOne(View v) {
        pointsB+=1;
        displayForTeamB(pointsB);
    }
    public void reset (View v){
        pointsA=0;
        pointsB=0;
        displayForTeamA(pointsA);
        displayForTeamB(pointsB);
    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

}
