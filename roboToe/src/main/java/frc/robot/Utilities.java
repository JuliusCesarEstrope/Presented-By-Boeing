package frc.robot;

public class Utilities {

    static double angleOfTapeFromFrontSensorToRightSensor;
    static double lengthOfTapeFromFrontSensorToRightSensor;
    static double lengthOfTapeFromFrontSensorToLeftSensor;
    static double angleOfTapeFromFrontSensorToLeftSensor;

    public static double AngleFinderFromFrontSensorToRightSensor(double distance, double rightSensorToFrontSensor) {

        lengthOfTapeFromFrontSensorToRightSensor = Math
                .sqrt(((distance * distance) + (rightSensorToFrontSensor * rightSensorToFrontSensor))
                        - (2 * distance * rightSensorToFrontSensor * (Math.cos(45))));
        angleOfTapeFromFrontSensorToRightSensor = Math.acos(((distance * distance)
                - (lengthOfTapeFromFrontSensorToRightSensor * lengthOfTapeFromFrontSensorToRightSensor)
                - (rightSensorToFrontSensor * rightSensorToFrontSensor))
                / (-2 * lengthOfTapeFromFrontSensorToRightSensor * rightSensorToFrontSensor));

        return angleOfTapeFromFrontSensorToRightSensor;
    }

    public static double AngleFinderFromFrontSensorToLeftSensor(double distance, double leftSensorToFrontSensor) {

        lengthOfTapeFromFrontSensorToLeftSensor = Math
                .sqrt(((distance * distance) + (leftSensorToFrontSensor * leftSensorToFrontSensor))
                        - (2 * distance * leftSensorToFrontSensor * (Math.cos(45))));
        angleOfTapeFromFrontSensorToLeftSensor = Math.acos(((distance * distance)
                - (lengthOfTapeFromFrontSensorToLeftSensor * lengthOfTapeFromFrontSensorToLeftSensor)
                - (leftSensorToFrontSensor * leftSensorToFrontSensor))
                / (-2 * lengthOfTapeFromFrontSensorToLeftSensor * leftSensorToFrontSensor));

        return angleOfTapeFromFrontSensorToLeftSensor;
    }

}