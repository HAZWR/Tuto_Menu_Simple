package com.example.user.myapplication;

import android.app.Activity;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 15/02/2018.
 */

public class ShowCaseScreen {

    String name;
    List<ShowCaseTarget> targets=new ArrayList<ShowCaseTarget>();


    public ShowCaseScreen(String name) {
        this.name = name;
        this.targets = new ArrayList<ShowCaseTarget>();
    }


   public static class Builder {
        private  String name;
        private static List<ShowCaseTarget> targets = new ArrayList<ShowCaseTarget>();
       public Builder(){
       }

        public ShowCaseScreen.Builder setName(String name) {
            this.name = name;
            return this;
        }

        public  ShowCaseScreen.Builder addTarget(ShowCaseTarget target1) {
            this.targets.add(target1);
            return this;
        }

        public  ShowCaseScreen build(){
           return new ShowCaseScreen(name);
        }
       public static ShowCaseTarget getTarget(int i){
           return targets.get(i);
       }
    }

    /*public ShowcaseView.Builder create(Activity activity) {
        int compteur =0;
        ShowcaseView.Builder builder = new ShowcaseView.Builder(activity);
        for (ShowCaseTarget target : targets) {
            builder.setTarget(new ViewTarget(target.getIdentifiant(), activity));
        }
        return builder;*/



    public String getName() {
        return name;
    }

    public ShowCaseTarget getTarget(int i){
        return Builder.getTarget(i);
    }

}
