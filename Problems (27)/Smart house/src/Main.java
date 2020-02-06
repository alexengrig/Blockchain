class SmartHouseFacadeTestDrive {
    public static void main(String[] args) {
        StereoSystem stereoSystem = new StereoSystem();
        Bathroom bathroom = new Bathroom();
        Lights lights = new Lights();

        SmartHouseFacade smartHouseFacade = new SmartHouseFacade(stereoSystem, bathroom, lights);

        lights.setFavouriteСolorTemperature("Calming blue");
        stereoSystem.setFavouriteSong("Queen - Killer Queen");
        bathroom.setFavouriteTemperature("35℃");
        bathroom.setFavouriteLevel("60%");

        smartHouseFacade.cameHome();
        smartHouseFacade.leaveBathroomGoSleep();
    }
}

class SmartHouseFacade {
    StereoSystem stereoSystem;
    Bathroom bathroom;
    Lights lights;

    public SmartHouseFacade(StereoSystem stereoSystem, Bathroom bathroom, Lights lights) {
        this.stereoSystem = stereoSystem;
        this.bathroom = bathroom;
        this.lights = lights;
    }

    public void cameHome() {
        stereoSystem.on();
        bathroom.fill();
        lights.on();
    }

    public void leaveBathroomGoSleep() {
        bathroom.drain();
        stereoSystem.off();
        lights.off();
    }
}

class StereoSystem {
    private String description = "StereoSystem";
    private String favouriteSong;

    public void on() {
        System.out.println(description + " on");
        turnOnFavouriteSong();
    }

    public void off() {
        System.out.println(description + " off");
    }

    private void turnOnFavouriteSong() {
        System.out.println("Favourite song is playing! " + favouriteSong);
    }

    public void setFavouriteSong(String favouriteSong) {
        this.favouriteSong = favouriteSong;
    }
}

class Bathroom {
    private String description = "The tub";
    private String favouriteTemperature;
    private String favouriteLevel;

    public void fill() {
        System.out.println(description + " is being filled");
        System.out.println("Temperature: " + favouriteTemperature);
        System.out.println("Water level: " + favouriteLevel);
    }

    public void drain() {
        System.out.println(description + " is being drained");
    }

    public void setFavouriteTemperature(String favouriteTemperature) {
        this.favouriteTemperature = favouriteTemperature;
    }

    public void setFavouriteLevel(String favouriteLevel) {
        this.favouriteLevel = favouriteLevel;
    }
}

class Lights {
    private String description = "Lights";
    private String favouriteСolorTemperature;

    public void on() {
        System.out.println(description + " on");
        System.out.println("Color temperature is: " + favouriteСolorTemperature);
    }

    public void off() {
        System.out.println(description + " off");
    }

    public void setFavouriteСolorTemperature(String favouriteСolorTemperature) {
        this.favouriteСolorTemperature = favouriteСolorTemperature;
    }
}