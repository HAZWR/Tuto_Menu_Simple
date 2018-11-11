package com.example.user.myapplication;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;
import com.github.amlcurran.showcaseview.targets.ViewTarget;


/**
 * Created by User on 08/02/2018.
 */

public class Test extends AppCompatActivity implements View.OnClickListener{

    private ShowcaseView showcaseView;
    private int contador=0;
    private Target t1,t2,t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testlayout);
        t1=new ViewTarget(R.id.button,this);
        t2=new ViewTarget(R.id.button2,this);
        t3=new ViewTarget(R.id.button3,this);
        showcaseView=new ShowcaseView.Builder(this)
                .setTarget(Target.NONE)
                .setOnClickListener(this)
                .setContentTitle("Tutorial")
                .setContentText("Universidad de las America")
                .setStyle(R.style.Transparencia)
                .build();
        showcaseView.setButtonText("siguiente");

    }

    @Override
    public void onClick(View view) {
        switch (contador) {
            case 0:
                showcaseView.setShowcase(t1, true);
                showcaseView.setContentTitle("Vibrar");
                showcaseView.setContentText("Pulse es boton para vibrar");
                break;
            case 1:
                showcaseView.setShowcase(t2, true);
                showcaseView.setContentTitle("Toast");
                showcaseView.setContentText("Pulse es boton para mostar un toast en la pantalla");
                break;
            case 2:
                showcaseView.setShowcase(t3, true);
                showcaseView.setContentTitle("Transparencias");
                showcaseView.setContentText("Pulse es boton para mostar nuevamente el tutorial");
                showcaseView.setButtonText("cerrar");
                break;
            case 3:
                showcaseView.hide();
                break;

        }
        contador++;
    }
    public void mostrarTransparencia(View v){
        contador=0;
        showcaseView.show();
        showcaseView.setTarget(Target.NONE);
        showcaseView.setContentTitle("Tutorial");
        showcaseView.setContentText("Universidad de las Americas");
        showcaseView.setButtonText("siguiente");
    }

    public void toast(View v){
        Toast to=Toast.makeText(Test.this,"tostada", Toast.LENGTH_SHORT);
        to.show();
    }

    public void vibrar(View v){
        Vibrator vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(1000);
    }
}
