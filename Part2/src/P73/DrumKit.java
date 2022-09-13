package P73;
/**
 *
 * @author  Stepan M
 * @version 2022.09.14
 * «адание типа "магинтик с кодом" - готовые куски когда собрать в работающую программу.
 */
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



