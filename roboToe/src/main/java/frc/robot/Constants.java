package frc.robot;

public class Constants {
  //Motors
  public static final int[] motorPortsLeft = {4, 5, 6};
  public static final int[] motorPortsRight = {1, 2, 3};
  public static final int rollerMotor = 7;
  public static final int leftWristMotor = 8;
  public static final int rightWristMotor = 9;
  public static final int leftFourBarMotorPort = 10;
  public static final int rightFourBarMotorPort = 11;
  
  //Joysticks
  public static final int leftJoystick = 0;
  public static final int rightJoystick = 1;
  public static final int gamePad = 2;
  
  //Buttons
  public static final int gamepad = 16;
  
  //Gyros
  public static final int gyroPort = 0;
  
  //Drive Encoders
  public static final int[] driveEncoderPortLeft = {0, 1};
  public static final int[] driveEncoderPortRight = {2, 3};
  public static double ticksOfEncoder = 360;
  
  //Fourbar Encoders
  public static final int[] leftBarEncoderPort = {10, 11};
  public static final int[] rightBarEncoderPort = {12, 13};

  //FourBar PID
  public static final double[] fourBarPIDValues = {0.1, 0.1, 0.01, 0};
  public static final int setStartPoint = 5;
  public static final int setFloorGatherPoint = 6;
  public static final int setHatchLvlTwoPoint = 7;
  public static final int setRocketLvlTwoPoint = 8;
  public static final int setRocketLvlOnePoint = 9;
  public static final int setClimbPoint = 10;
  public static final int setBallLvlOnePoint = 11;
  public static final int setBallLvlTwoPoint = 12;
  
  //Wrist Encoders
  public static final int[] leftWristEncoder = {6, 7};
  public static final int[] rightWristEncoder = {8, 9};
  
  //Pneumatics
  public static final int[] booperPort = {0, 1};
  
  //Wrist Constants
  public static int wristButton = 3;
  public static int wristDownSetPoint = 70;
  public static int wristUpSetPoint = 0;
  
  //Drive PID
  public static double[] driveRotationPIDValues = { 0.1, 0, 0, 0 };

  //Auton Constants
  public static final double level2Length = 48;
  public static final double level1Length = 47.25;
  public static final double firstExtra = 12;

  public static final double midToMidAngle = -8.14;
  public static final double midToMidDistance = 76.77;

  public static final double midToSideAngle = -22.71;
  public static final double midToSideDistance = 121.41;

  public static final double sideToCloseMidAngle = 23.55;
  public static final double sideToCloseMidDistance = 82.91;

  public static final double sideToFarMidAngle = 35.83;
  public static final double sideToFarMidDistance = 93.74;

  public static final double crossAngle = 42.53;
  public static final double crossDistance = 151.99;

  public static final double sameSideAngle = -7.5;
  public static final double sameSidesDistance = 112.97;

  public static final double distanceToHatch = 36;

  public static final double setpointToFar = 84;
  public static final double setpointToMid = 62.25;
  public static final double setpointToClose = 40.5;

  
  //Sensor
  public static final int leftSensor = 3;
  public static final int rightSensor = 4;
  public static final int frontSensor = 5;
  public static final int backSensor = 6;
  
  //Wheel Constants
  public static double diameterOfWheels = 7.8025;
  public static double circumferanceOfWheels = diameterOfWheels*Math.PI;
  
  //Sensor Constants
  public static double leftSensorToRightSensor = 7;
  public static double leftSensorToFrontSensor = 3.5;
  public static double frontSensorToBackSensor = 7;
  public static double rightSensorToBackSensor = 3.5;
  public static double rightSensorToCenterSensor = 1;
  public static double leftSensorToCenterSensor = 1;
}