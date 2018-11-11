package com.example.user.myapplication;

import java.util.List;

/**
 * Created by User on 15/02/2018.
 */

public class ShowCaseTutorielSingleton {
    private ShowCaseTutorielSingleton(){}
    private static ShowCaseTutorielSingleton INSTANCE=null;
    private ShowCaseTutoriel tuto = null;
    private int positionScreen=0;

    public static ShowCaseTutorielSingleton getInstance(){
        if(INSTANCE==null)
        {
            INSTANCE=new ShowCaseTutorielSingleton();
        }
        return INSTANCE;
    }

    public ShowCaseTutorielSingleton getShowCaseTutorielSingleton(){
        return this.INSTANCE;
    }

    public ShowCaseTutoriel getCurrentTutoriel(){
        return this.tuto;
    }

    public void setCurrentTutoriel(ShowCaseTutoriel tuto){
        this.tuto = tuto;
    }

    public int getPositionScreen() {
        return positionScreen;
    }

    public void setPositionScreen(int positionScreen) {
        this.positionScreen = positionScreen;
    }
}
