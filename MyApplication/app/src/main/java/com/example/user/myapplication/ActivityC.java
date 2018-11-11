package com.example.user.myapplication;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;
import android.view.View;
import android.content.Intent;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

public class ActivityC extends AppCompatActivity implements View.OnClickListener{
    Button butAC,butDC;
    ImageButton imageButtonC;
    private ShowCaseTutoriel tutoCurrent;
    private ShowCaseScreen screenCurrent;
    private Target t1,t2, t3;
    private ShowcaseView showcaseView;
    private int compteur;
    private ShowcaseView scView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainc);
        butAC = (Button) findViewById(R.id.butAC);
        butDC = (Button) findViewById(R.id.butDC);
        imageButtonC=(ImageButton) findViewById(R.id.imageButtonC);
        tutoCurrent = ShowCaseTutorielSingleton.getInstance().getCurrentTutoriel();
        screenCurrent = tutoCurrent.getScreenWithName("ActivityC");
        // screenCurrent.create(this).build();
        ShowCaseTarget swTarget = screenCurrent.getTarget(0);
        scView = swTarget.create(this)
                .setTarget(Target.NONE)
                .setStyle(R.style.Transparencia)
                .setOnClickListener(this)
                .build();

        t1= new ViewTarget(screenCurrent.getTarget(5).getIdentifiant(), this);
        t2=new ViewTarget(screenCurrent.getTarget(6).getIdentifiant(), this);
        t3=new ViewTarget(screenCurrent.getTarget(7).getIdentifiant(), this);
      /*  t1= new ViewTarget(tutoCurrent.getScreens().get(1).getTarget(0).getIdentifiant(), this);
        t2=new ViewTarget(tutoCurrent.getScreens().get(1).getTarget(1).getIdentifiant(), this);
        t3=new ViewTarget(tutoCurrent.getScreens().get(1).getTarget(2).getIdentifiant(), this);*/
        Log.d("Target 1 activité C ?", Integer.toString(screenCurrent.getTarget(5).getIdentifiant()));
        Log.d("View 11 activité C?", Integer.toString(R.id.butAC));
        Log.d("Target 2 activité C?", Integer.toString(screenCurrent.getTarget(6).getIdentifiant()));
        Log.d("View 12 activité C?", Integer.toString(R.id.butDC));
        Log.d("Target 3 activité C?", Integer.toString(screenCurrent.getTarget(7).getIdentifiant()));
        Log.d("View 13 activité C?", Integer.toString(R.id.imageButtonC));
        compteur = 0;

        butAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchActivityA();
            }
        });
        butDC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchActivityD();
            }
        });
        imageButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivityImage();
            }
        });

    }
    @Override
    public void onClick(View view) {
        switch(compteur){
            case 0:
                scView.setShowcase(t1, true);
                scView.setContentTitle("Bouton A ");
                scView.setContentText("Passez à l'activité A");
                break;

            case 2:
                scView.setShowcase(t2, true);
                scView.setContentTitle("Bouton D ");
                scView.setContentText("Passez à l'activité D");
                break;


            case 3:
                scView.setShowcase(t3, true);
                scView.setContentTitle("Bouton Home");
                scView.setContentText("Revenez au menu");
                break;


            case 4:
                String nameTuto=tutoCurrent.getName();
                Intent intent;
                switch(nameTuto){
                    case "Tuto1":
                        intent = new Intent(getApplicationContext(), ActivityD.class);
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
    private void launchActivityA() {

        Intent intent = new Intent(this, ActivityA.class);
        startActivity(intent);
    }

    private void launchActivityD() {

        Intent intent = new Intent(this, ActivityD.class);
        startActivityForResult(intent, 0);
    }

    private void launchActivityImage() {
        Intent intent = new Intent(this, ActivityList.class);
        startActivityForResult(intent, 0);
    }

}
