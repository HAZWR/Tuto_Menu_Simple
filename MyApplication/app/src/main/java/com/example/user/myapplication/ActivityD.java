package com.example.user.myapplication;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
/**
 * Created by User on 27/01/2018.
 */
import android.util.Log;
import android.widget.*;
import android.view.View;
import android.content.Intent;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

public class ActivityD extends AppCompatActivity implements View.OnClickListener{
    Button butC;
    ImageButton bouton2;
    private ShowCaseTutoriel tutoCurrent;
    private ShowCaseScreen screenCurrent;
    private Target t1;
    private Target t2;
    private int compteur;
    private ShowcaseView scView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maind);
        butC = (Button) findViewById(R.id.butC);
        bouton2=(ImageButton) findViewById(R.id.imageButton);
        tutoCurrent = ShowCaseTutorielSingleton.getInstance().getCurrentTutoriel();
        screenCurrent = tutoCurrent.getScreenWithName("ActivityD");
        butC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchActivityC();
            }
        });
        bouton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivityImage();
            }
        });
        ShowCaseTarget swTarget = screenCurrent.getTarget(8);
        scView = swTarget.create(this)
                .setTarget(Target.NONE)
                .setStyle(R.style.Transparencia)
                .setOnClickListener(this)
                .build();

        t1= new ViewTarget(screenCurrent.getTarget(8).getIdentifiant(), this);
        t2=new ViewTarget(screenCurrent.getTarget(9).getIdentifiant(), this);
        Log.d("Target 1 activité D ?", Integer.toString(screenCurrent.getTarget(8).getIdentifiant()));
        Log.d("View 11 activité D?", Integer.toString(R.id.butC));
        Log.d("Target 2 activité D?", Integer.toString(screenCurrent.getTarget(9).getIdentifiant()));
        Log.d("View 12 activité D?", Integer.toString(R.id.imageButton));
        compteur = 0;

    }
    private void launchActivityC() {
       Intent intent = new Intent(this, ActivityC.class);
        startActivityForResult(intent, 0);
    }

    private void launchActivityImage() {
        Intent intent = new Intent(this, ActivityList.class);
        startActivityForResult(intent, 0);
    }
    @Override
    public void onClick(View view) {
        switch(compteur){
            case 0:
                //ShowcaseView view1 = screenCurrent.getTarget(0).create(ActivityA.this).build();
                scView.setShowcase(t1, true);
                scView.setContentTitle("Bouton C ");
                scView.setContentText("Passez à l'acitivité C");
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
                        intent = new Intent(getApplicationContext(), ActivityA.class);
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


}
