package frc.robot;

public class Constants {

  //Motors
  public static final int[] motorPortsLeft = {4, 5, 6};
  public static final int[] motorPortsRight = {1, 2, 3};
  public static final int rollerMotor = 7
  public static final int leftWristMotor = 8;
  public static final int rightWristMotor = 9;
  public static final int leftFourBarMotorPort = 10;
  public static final int rightFourBarMotorPort = 11;
  public static final int leftVerticalElevatorMotor = 12;
  public static final int rightVerticalElevatorMotor = 13;
  public static final int leftHorizontalElevatorMotor = 14;
  public static final int rightHorizontalElevatorMotor = 15;
  
  //Joysticks
  public static final int leftJoystick = 0;
  public static final int rightJoystick = 1;
  public static final int gamePad = 2;
  
  //Buttons
  public static final int barDownButton = 4;
  public static final int barLowButton = 1;
  public static final int barHighButton = 3;
  public static final int gamepad = 16;
  
  //Gyros
  public static final int gyroPort = 0;

  // Sensor
  public static final int fastSlowStopSensor = 1;

  //Encoders
  public static final int[] driveEncoderPortLeft = {0, 1};
  public static final int[] driveEncoderPortRight = {2, 3};
  public static final int[] leftBarEncoderPort = {10, 11};
  public static final int[] rightBarEncoderPort = {12, 13};
  public static final int[] leftElevatorEncoder = {1, 2};
  public static final int[] rightElevatorEncoder = {3, 4};

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

  // PID
  public static final double[] leftElevatorEncoderPIDValues = {0, 0, 0, 0};
  public static final double[] rightElevatorEncoderPIDValues = {0, 0, 0, 0};
  // Constant Number
  public static final double defaultElevatorPosition = 0;
      // FIGURE OUT WHAT VALUE IS SUPPOSED TO BE
  public static final double distanceToTicks = (360 / (Math.PI*1.432));
  public static final double distanceYToTravel = distanceToTicks * 22;
  public static final double distanceYInch = distanceToTicks * 1;
  public static final double distanceYFiveInch = distanceToTicks * 5;
  
}
