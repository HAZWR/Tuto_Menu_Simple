package com.example.user.myapplication;

import android.app.Activity;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

/**
 * Created by User on 14/03/2018.
 */

public class ShowCaseTarget {
    private final int identifiant;

    public ShowCaseTarget(int identifiant) {
        this.identifiant = identifiant;
    }


    public static class Builder {
        private int identifiant;
        public ShowCaseTarget.Builder setId(int id){
            this.identifiant=id;
            return this ;
        }

        public  ShowCaseTarget build() {
            return new ShowCaseTarget(identifiant);
        }
    }
    public int getIdentifiant() {
        return identifiant;
    }
    public ShowcaseView.Builder create(Activity activity){
        return new ShowcaseView.Builder(activity);
    }
     public String toString(){
        return "target "+this.getIdentifiant();
    }

}
