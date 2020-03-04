package location;

public enum Direction {
N("North"),S("South"),E("East"),W("West"),
    U("Up"),D("Down");

    private String directionDescription;

    public String getDirectionDescription() {
        return directionDescription;
    }

    Direction(String directionDescription) {
        this.directionDescription = directionDescription;



    }
}

