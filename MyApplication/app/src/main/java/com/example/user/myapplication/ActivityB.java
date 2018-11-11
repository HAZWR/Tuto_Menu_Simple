package com.example.user.myapplication;

/**
 * Created by User on 27/01/2018.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;
import android.view.View;
import android.content.Intent;
import android.app.Activity;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

public class ActivityB extends Activity implements View.OnClickListener{

    private Button butAB, butCB;

    private ImageButton buttonMenuB;
    private ShowCaseTutoriel tutoCurrent;
    private ShowCaseScreen screenCurrent;
    private Target t1,t2, t3;

    private int compteur;
    private ShowcaseView scView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainb);

        butAB = (Button) findViewById(R.id.butAB);
        butCB = (Button) findViewById(R.id.butCB);
        buttonMenuB=(ImageButton) findViewById(R.id.imageButtonB);

        tutoCurrent = ShowCaseTutorielSingleton.getInstance().getCurrentTutoriel();
        screenCurrent = tutoCurrent.getScreenWithName("ActivityB");
        // screenCurrent.create(this).build();
        ShowCaseTarget swTarget = screenCurrent.getTarget(2);
        scView = swTarget.create(this)
                .setTarget(Target.NONE)
                .setStyle(R.style.Transparencia)
                .setOnClickListener(this)
                .build();

        t1= new ViewTarget(screenCurrent.getTarget(2).getIdentifiant(), this);
        t2=new ViewTarget(screenCurrent.getTarget(3).getIdentifiant(), this);
        t3=new ViewTarget(screenCurrent.getTarget(4).getIdentifiant(), this);
        Log.d("Target 1 activité B ?", Integer.toString(screenCurrent.getTarget(2).getIdentifiant()));
        Log.d("View 11 activité B?", Integer.toString(R.id.butAB));
        Log.d("Target 2 activité B?", Integer.toString(screenCurrent.getTarget(3).getIdentifiant()));
        Log.d("View 12 activité B?", Integer.toString(R.id.butCB));
        Log.d("Target 3 activité B?", Integer.toString(screenCurrent.getTarget(4).getIdentifiant()));
        Log.d("View 13 activité B?", Integer.toString(R.id.imageButtonB));
        compteur = 0;



        buttonMenuB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivityImage();
            }
        });

        butAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivityA();
            }
        });

        butCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivityC();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(compteur){
            case 0:
                scView.setShowcase(t1, true);
                scView.setContentTitle("Bouton A ");
                scView.setContentText("Passez à l'activité précédente A");
                break;

            case 2:
                scView.setShowcase(t2, true);
                scView.setContentTitle("Bouton C ");
                scView.setContentText("Passez à l'activité C");
                break;


            case 3:
                scView.setShowcase(t3, true);
                scView.setContentTitle("Bouton Home");
                scView.setContentText("Revenez au menu");
                break;


            case 4:
               // String nameActivity=tutoCurrent.getScreenWithName("ActivityC").getName();
                String nameTuto=tutoCurrent.getName();
                Intent intent;
                switch(nameTuto){
                    case "Tuto1":
                        intent = new Intent(getApplicationContext(), ActivityC.class);
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
        startActivityForResult(intent, 0);
    }
    private void launchActivityC() {

        Intent intent = new Intent(this, ActivityC.class);
        startActivityForResult(intent, 0);
    }

    private void launchActivityImage(){
        Intent intent = new Intent(this, ActivityList.class);
        startActivityForResult(intent, 0);
    }


}
