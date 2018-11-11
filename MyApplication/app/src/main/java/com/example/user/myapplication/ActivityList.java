package com.example.user.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
/**
 * Created by User on 28/01/2018.
 */
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;

import java.util.ArrayList;
import java.util.List;


public class ActivityList extends AppCompatActivity {

    private ListView mListView;
    private List<ShowCaseTutoriel> listTutoriel = new ArrayList<ShowCaseTutoriel>();
    private List<String> listNameTutorial = new ArrayList<String>();
    ShowCaseTutoriel tuto1;
    ShowCaseTutoriel tutoSelected;
    ShowcaseView show1;
    ActivityA activ=new ActivityA();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_listview);
        mListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = null;
        tuto1 = new ShowCaseTutoriel.Builder()
                .setName("Tuto1")
                .addScreen(new ShowCaseScreen.Builder()
                        .setName("ActivityA")
                        .addTarget(
                                new ShowCaseTarget.Builder()
                                        .setId(R.id.bt_launch_activity).build())
                        .addTarget(new ShowCaseTarget.Builder()
                                .setId(R.id.imageButton).build()).build())
                .addScreen(new ShowCaseScreen.Builder()
                        .setName("ActivityB")
                        .addTarget(
                                new ShowCaseTarget.Builder()
                                        .setId(R.id.butAB).build())
                        .addTarget(
                                new ShowCaseTarget.Builder()
                                        .setId(R.id.butCB).build())
                        .addTarget(new ShowCaseTarget.Builder()
                                .setId(R.id.imageButtonB).build()).build())
                .addScreen(new ShowCaseScreen.Builder()
                        .setName("ActivityC")
                        .addTarget(
                                new ShowCaseTarget.Builder()
                                        .setId(R.id.butAC).build())
                        .addTarget(
                                new ShowCaseTarget.Builder()
                                        .setId(R.id.butDC).build())
                        .addTarget(new ShowCaseTarget.Builder()
                                .setId(R.id.imageButtonC).build()).build())
                .addScreen(new ShowCaseScreen.Builder()
                        .setName("ActivityD")
                        .addTarget(
                                new ShowCaseTarget.Builder()
                                        .setId(R.id.butC).build())
                        .addTarget(
                                new ShowCaseTarget.Builder()
                                        .setId(R.id.imageButton).build()).build()).build();

        listTutoriel.add(tuto1);
        for(int i=0;i<listTutoriel.size();i++) {
            listNameTutorial.add(listTutoriel.get(i).getName());
       adapter = new ArrayAdapter<String>(ActivityList.this,
                android.R.layout.simple_list_item_1,listNameTutorial);}
        if(mListView==null)
            Log.d("mListView null ?", "Oui");
        else
            Log.d("mListView null ?", "Non");

        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ShowCaseTutoriel tutoSelected;
                tutoSelected = listTutoriel.get(position);
                ShowCaseTutorielSingleton.getInstance().setCurrentTutoriel(tutoSelected);
                int positionScreen = ShowCaseTutorielSingleton.getInstance().getPositionScreen();
                String nameActivity = tutoSelected.getScreens().get(positionScreen).getName();
                Intent intent;
                switch(nameActivity){
                    case "ActivityA":
                        intent = new Intent(getApplicationContext(), ActivityA.class);
                        startActivity(intent);
                       // Toast.makeText(getBaseContext(),  "Tutoriel : "+tutoSelected.getName()+" selected and CurrentScreen : "+tutoSelected.getScreens().get(0).getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "ActivityB":
                        intent = new Intent(getApplicationContext(), ActivityB.class);
                        startActivity(intent);
                        break;
                    case "ActivityC":
                        intent = new Intent(getApplicationContext(), ActivityC.class);
                        startActivity(intent);
                        break;
                    case "ActivityD":
                        intent = new Intent(getApplicationContext(), ActivityD.class);
                        startActivity(intent);
                        break;
                    default:
                        Toast.makeText(getBaseContext(),"impossible de trouver l'interface en question", Toast.LENGTH_LONG).show();
                        break;
                }
              //  Toast.makeText(getBaseContext(),  "Tutoriel : "+tutoSelected.getName()+" selected and CurrentScreen : "+tutoSelected.getScreens().get(0).getName(), Toast.LENGTH_LONG).show();


            }

        });
    }
}
