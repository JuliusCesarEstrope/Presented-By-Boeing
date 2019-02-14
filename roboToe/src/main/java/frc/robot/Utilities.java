package frc.robot;

public class Utilities {              

    public static double AngleFinder(double distance, double leftSensorToRightSensor, double leftSensorToFrontSensor, double frontSensorToBackSensor, double rightSensorToBackSensor, double rightSensorToCenter, double leftSensorToCenterSensor){
        set.lengthOfTapeFromFrontSensorToRightSensor to new lengthOfTapeFromFrontSensorToRightSensor;
        
        lengthOfTapeFromFrontSensorToRightSensor = Math.sqrt(((distance*distance)+(rightSensorToCenter*rightSensorToCenter))-(2*distance*rightSensorToCenter*(Math.cos(45))));
        Math.acos(((distance*distance)-(lengthOfTapeFromFrontSensorToRightSensor*lengthOfTapeFromFrontSensorToRightSensor)-(rightSensorToCenter*rightSensorToCenter))/(-2*lengthOfTapeFromFrontSensorToRight*rightSensorToCenter));
    
        lengthOfTapeFromFrontSensorToLeftSensor = Math.sqrt(((distance*distance)+(leftSensorToCenterSensor*leftSensorToCenterSensor))-(2*distance*leftSensorToCenterSensor*(Math.cos(45))));
        Math.acos(((distance*distance)-(lengthOfTapeFromFrontSensorToLeftSensor*lengthOfTapeFromFrontSensorToLeftSensor)-(leftSensorToCenterSensor*leftSensorToCenterSensor))/(-2*lengthOfTapeFromFrontSensorToRight*leftSensorToCenterSensor));

        Math.atan(distance/Constants.distanceBetweenSensors);    
    } 
  
}