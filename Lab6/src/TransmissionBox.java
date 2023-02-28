/**
 * This class represents the transmission box of an automatic car. The transmission box
 * has a current speed, a current gear and 4 speed thresholds for the 5 gears in order.
 */

public class TransmissionBox {
    private int currentSpeed; // current speed of the transmission box
    private int currentGear; // current gear
    // Speed thresholds representing going from 1 to 2, or 2 to 3 (or back), etc.
    private final int thresholdOne;
    private final int thresholdTwo;
    private final int thresholdThree;
    private final int thresholdFour;


    /**
     * Construct a TransmissionBox object and initializes it to the current speed and 4
     * speed thresholds.
     * @param currentSpeed the current speed
     * @param thresholdOne the first threshold, representing going from 1 to 2 or back.
     * @param thresholdTwo the second threshold, representing going from 2 to 3 or back.
     * @param thresholdThree the third threshold, representing going from 3 to 4 or back.
     * @param thresholdFour the fourth threshold, representing going from 4 to 5 or back.
     */

    public TransmissionBox(int currentSpeed, int thresholdOne,
                           int thresholdTwo, int thresholdThree,
                           int thresholdFour) throws IllegalArgumentException {

        // TODO: You write the code for the constructor
        if (currentSpeed < 0) {
            throw new IllegalArgumentException();
        }
        if (thresholdOne < 0) {
            throw new IllegalArgumentException();
        }
        if (thresholdTwo <= thresholdOne) {
            throw new IllegalArgumentException();
        }
        if (thresholdThree <= thresholdTwo) {
            throw new IllegalArgumentException();
        }
        if (thresholdFour <= thresholdThree) {
            throw new IllegalArgumentException();
        }
        this.currentSpeed = currentSpeed;
        this.thresholdOne = thresholdOne;
        this.thresholdTwo = thresholdTwo;
        this.thresholdThree = thresholdThree;
        this.thresholdFour = thresholdFour;

        if (currentSpeed < thresholdOne) {
            this.currentGear = 1;
        }
        else if (currentSpeed < thresholdTwo) {
            this.currentGear = 2;
        }
        else if (currentSpeed < thresholdThree) {
            this.currentGear = 3;
        }
        else if (currentSpeed < thresholdFour) {
            this.currentGear = 4;
        }
        else {
            this.currentGear = 5;
        }
    }


    /**
     * Returns a TransmissionBox object with speed increased by 2 and the appropriate gear.
     * @return a TransmissionBox object with speed increased by 2 and the appropriate gear.
     */

    public TransmissionBox speedIncrease() {
        // TODO: Write the code for a speed increase by 2
        return new TransmissionBox(currentSpeed + 2,
            thresholdOne, thresholdTwo, thresholdThree, thresholdFour);

    }



    /**
     * Returns a TransmissionBox object with speed decreased by 2 and the appropriate gear.
     * @return a TransmissionBox object with speed decreased by 2 and the appropriate gear.
     */

    public TransmissionBox speedDecrease() {
        // TODO: Write the code for a speed decrease by 2
        return new TransmissionBox(currentSpeed - 2,
                thresholdOne, thresholdTwo, thresholdThree, thresholdFour);
    }



    /**
     * Returns the current speed of a TransmissionBox.
     * @return currentSpeed.
     */

    public int getSpeed() { return this.currentSpeed;}

    /**
     * Returns the current gear of a TransmissionBox.
     * @return currentGear.
     */

    public int getCurrentGear() { return this.currentGear;}



    /**
     * Returns a string with the current speed and current gear of the TransmissionBox.
     * @return str.
     */

    @Override
    public String toString() {
        // TODO: Write the toString() method
        return "Speed: " + this.getSpeed()
                + "Gear: " + this.getCurrentGear();

    }




}