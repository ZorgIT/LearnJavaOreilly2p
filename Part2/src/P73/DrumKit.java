package P73;

class DrumKit {
    boolean topHat = false;
    boolean snare = false;

    void playSnare() {
        System.out.println("бах бах ба-бах");
    }

    void playTopHat() {
        System.out.println("динь динь ди-динь");
    }
}

class DrumKitTestDrive {
    public static void main (String [] args ) {
        DrumKit d = new DrumKit();
        d.snare=true;
        d.topHat=true;

        if (d.snare == true) {
            d.playSnare();
        }

        if (d.topHat == true) {
            d.playTopHat();
        }

    }
}



