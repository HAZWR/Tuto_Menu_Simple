package com.example.user.myapplication;

import com.github.amlcurran.showcaseview.ShowcaseView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 15/02/2018.
 */

public class ShowCaseTutoriel {
    private String name;
    private List<ShowCaseScreen> listScreens;

    public ShowCaseTutoriel(String name, List<ShowCaseScreen> listShowCaseScreen) {
        this.name = name;
        this.listScreens = listShowCaseScreen;
    }

    public static class Builder {
        private static String name;
        private  List<ShowCaseScreen> listScreen = new ArrayList<ShowCaseScreen>();

        public Builder(){
        }

        public ShowCaseTutoriel.Builder setName(String name) {
            this.name = name;
            return this;
        }

        public ShowCaseTutoriel.Builder addScreen(ShowCaseScreen screen) {
            this.listScreen.add(screen);
            return this;
        }

        public ShowCaseTutoriel build() {
            return new ShowCaseTutoriel(this.name, this.listScreen);
        }

        public class addScreen {
            public addScreen(ShowCaseScreen build) {
            }
        }

        public static String getName() {
            return name;
        }
    }

    public String getName() {
        return Builder.getName();
    }



    public List<ShowCaseScreen> getScreens() {
        return listScreens;
    }

    public ShowCaseScreen getScreenWithName(String nameScreen) {
        for (ShowCaseScreen screen : listScreens){
            if (nameScreen.equals(screen.getName())) {
                return screen;
            }
        }
        return null;
    }


}



