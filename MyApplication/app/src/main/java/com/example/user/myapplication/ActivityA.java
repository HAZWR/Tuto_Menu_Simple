package com.example.user.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.*;
import android.view.View;
import android.content.Intent;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;
import com.github.amlcurran.showcaseview.targets.ViewTarget;


public class ActivityA extends AppCompatActivity implements  View.OnClickListener{

    private Button bouton1;

    private ImageButton bouton2;
    private ShowCaseTutoriel tutoCurrent;
    private ShowCaseScreen screenCurrent;
    private Target t1;
    private Target t2;
    private int compteur;
    private ShowcaseView scView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maina);


        bouton1 = (Button) findViewById(R.id.bt_launch_activity);
        bouton2 = (ImageButton) findViewById(R.id.imageButton);

        tutoCurrent = ShowCaseTutorielSingleton.getInstance().getCurrentTutoriel();
        if(tutoCurrent==null)
            Log.d("TutoCurrent Null ?", "Yes");
        else
            Log.d("TutoCurrent Null ?", "No");
        screenCurrent = tutoCurrent.getScreenWithName("ActivityA");
        Log.d("Target 1 activité A ?", Integer.toString(screenCurrent.getTarget(0).getIdentifiant()));
        Log.d("View 11 activité A?", Integer.toString(R.id.bt_launch_activity));
        Log.d("Target 2 activité A?", Integer.toString(screenCurrent.getTarget(1).getIdentifiant()));
        Log.d("View 12 activité A?", Integer.toString(R.id.imageButton));
       // screenCurrent.create(this).build();
        ShowCaseTarget swTarget = screenCurrent.getTarget(0);
        scView = swTarget.create(this)
                .setTarget(Target.NONE)
                .setStyle(R.style.Transparencia)
                .setOnClickListener(this)
                .build();

        t1= new ViewTarget(tutoCurrent.getScreens().get(0).getTarget(0).getIdentifiant(), this);
        t2=new ViewTarget(tutoCurrent.getScreens().get(0).getTarget(1).getIdentifiant(), this);

        compteur = 0;

       /*
        showcaseView=new ShowcaseView.Builder(this)
                .setTarget(Target.NONE)
                .setOnClickListener(this)
                .setContentTitle("Tutoriel : Activity A")
                .setContentText("Explication des différents buttons")
                .setStyle(R.style.Transparencia)
                .build();
        showcaseView.setButtonText("Survol");
        */

        bouton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity();
            }
        });

        bouton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity1();
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch(compteur){
            case 0:
                //ShowcaseView view1 = screenCurrent.getTarget(0).create(ActivityA.this).build();
                scView.setShowcase(t1, true);
                scView.setContentTitle("Bouton B ");
                scView.setContentText("Passez à l'acitivité B");
                break;
            case 1:
                // ShowcaseView view2 = screenCurrent.getTarget(1).create(ActivityA.this).build();
                scView.setShowcase(t2, true);
                scView.setContentTitle("Bouton Home");
                scView.setContentText("Revenez au menu");
                break;
             case 3:
               // String nameActivity = ShowCaseTutorielSingleton.getInstance().getCurrentTutoriel().getScreens().get(positionScreen+1).getName();
               // ShowCaseTutorielSingleton.getInstance().setPositionScreen(positionScreen+1);
               // String nameActivity=tutoCurrent.getScreenWithName("ActivityB").getName();
                 String nomTuto=tutoCurrent.getName();
                 Intent intent;
                 switch(nomTuto){
                     case "Tuto1":
                         intent = new Intent(getApplicationContext(), ActivityB.class);
                         startActivity(intent);
                        // Toast.makeText(getBaseContext(),  "Tutoriel : "+nameActivity+" selected and CurrentScreen : "+ShowCaseTutorielSingleton.getInstance().getPositionScreen(), Toast.LENGTH_LONG).show();
                         break;
                     default:
                         break;
                 }

                break;

        }
        compteur++;
    }
    private void launchActivity() {

        Intent intent = new Intent(this, ActivityB.class);
        startActivityForResult(intent, 0);
    }

    private void launchActivity1() {
        Intent intent = new Intent(this, ActivityList.class);
        startActivityForResult(intent, 0);
    }
}