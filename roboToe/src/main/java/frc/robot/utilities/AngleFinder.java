package frc.robot.utilities;

public class AngleFinder {            

    static double angleOfTapeFromFrontSensorToRightSensor;
    static double lengthOfTapeFromFrontSensorToRightSensor;
    static double lengthOfTapeFromFrontSensorToLeftSensor;
    static double angleOfTapeFromFrontSensorToLeftSensor;

    public static double AngleFinderFromFrontSensorToRightSensor(double distance, double rightSensorToCenterSensor){
        
        lengthOfTapeFromFrontSensorToRightSensor = Math.sqrt(((distance*distance)+(rightSensorToCenterSensor*rightSensorToCenterSensor))-(2*distance*rightSensorToCenterSensor*(Math.cos(45))));
        angleOfTapeFromFrontSensorToRightSensor = Math.acos(((distance*distance)-(lengthOfTapeFromFrontSensorToRightSensor*lengthOfTapeFromFrontSensorToRightSensor)-(rightSensorToCenterSensor*rightSensorToCenterSensor))/(-2*lengthOfTapeFromFrontSensorToRightSensor*rightSensorToCenterSensor));
    
        return  angleOfTapeFromFrontSensorToRightSensor;
    } 

    public static double AngleFinderFromFrontSensorToLeftSensor(double distance, double leftSensorToCenterSensor){
        
        lengthOfTapeFromFrontSensorToLeftSensor = Math.sqrt(((distance*distance)+(leftSensorToCenterSensor*leftSensorToCenterSensor))-(2*distance*leftSensorToCenterSensor*(Math.cos(45))));
        angleOfTapeFromFrontSensorToLeftSensor = Math.acos(((distance*distance)-(lengthOfTapeFromFrontSensorToLeftSensor*lengthOfTapeFromFrontSensorToLeftSensor)-(leftSensorToCenterSensor*leftSensorToCenterSensor))/(-2*lengthOfTapeFromFrontSensorToLeftSensor*leftSensorToCenterSensor));
    
        return  angleOfTapeFromFrontSensorToLeftSensor;
    } 
   
}