package frc.robot;

public class Constants {

  // Joysticks
  public static final int leftJoystick = 0;
  public static final int rightJoystick = 1;
  public static final int gamePad = 2;

  /** BEGIN CAN DEVICES **/
  // Motors
  public static final int[] motorPortsLeft = { 4, 5, 6 };
  public static final int[] motorPortsRight = { 1, 2, 3 };
  public static final int rollerMotor = 7;
  public static final int leftWristMotorPort = 9;
  public static final int rightWristMotorPort = 8;
  public static final int leftFourBarMotorPort = 10;
  public static final int rightFourBarMotorPort = 11;
  public static final int verticalElevatorMotor = 12;
  public static final int horizontalElevatorMotor = 14;
  /** END CAN DEVICES **/

  /** BEGIN SOLENOIDS **/
  public static final int[] booperPorts = { 0, 1 };
  /** END SOLENOIDS **/

  /** BEGIN ANALOG INPUTS **/
  // Gyros
  public static final int gyroPort = 0;
  /** END ANALOG INPUTS **/

  /** BEGIN DIGITAL INPUTS **/
  // Horizontal Elevator Sensor
  public static final int fastSlowStopSensor = 1;

  // Drive Tape Sensors
  public static final int leftSensor = 3;
  public static final int rightSensor = 4;
  public static final int frontSensor = 5;
  public static final int backSensor = 6;

  // Note to everyone: Encoders used on a TalonSRX are done differently
  // Drive Encoders
  public static final int[] driveEncoderPortLeft = { 0, 1 };
  public static final int[] driveEncoderPortRight = { 2, 3 };
  public static double ticksOfEncoder = 4096;
  
  //Fourbar Encoders
  public static final int[] leftBarEncoderPort = {10, 11};
  public static final int[] rightBarEncoderPort = {12, 13};
  
  /** END DIGITAL INPUTS**/

  /** BEGIN PID CONSTANTS**/
  //Drive PID

  public static double[] driveRotationPIDValues = { 0.5, 0, 0, 0 };
  public static double[] rightEncoderPIDValues = {0.32,0,0.2,0};
  public static double[] leftEncoderPIDValues = {0.32,0,0.2,0};


  //FourBar PID
  public static final double[] fourBarPIDValues = {0.1, 0.1, 0.01, 0};

  //Elevator PID
  public static final double[] elevatorEncoderPIDValues = {0, 0, 0, 0};
  /** END PID CONSTANTS**/

  /** BEGIN OTHER CONSTANTS**/
  //Drive Wheel Constants
  public static double diameterOfWheels = 7.8025;
  public static double circumferenceOfWheels = diameterOfWheels * Math.PI;

   //Encoder tick to Inches
   public static double ticksToInches = (ticksOfEncoder/360) * circumferenceOfWheels;
   
  //FourBar Constants
  public static final double setStartPoint = (36*((4096/360)*(11.22))); //initialize: set angle to 11.22
  public static final double setFloorGatherPoint = (36*((4096/360)*(50.83)));
  //public static final double setHatchLvlTwoPoint = (36*((4096/360)*(149.43))); //maybe not use?? how is this different from rocketlvltwo, should this be cargo
  public static final double setRocketLvlTwoPoint =(36*((4096/360)*(149.43)));
  public static final double setRocketLvlOnePoint =(36*((4096/360)*(31.68)));
  public static final double setClimbPoint = (36*((4096/360)*(11.22)));
  public static final double setBallLvlOnePoint = (36*((4096/360)*(31.68)));
  public static final double setBallLvlTwoPoint = (36*((4096/360)*(149.43)));

  //Wrist stuff
  public static final int[] leftWristEncoderPort = {6, 7};
  public static final int[] rightWristEncoderPort = {8, 9};
  public static int wristDownSetPoint = (28*((4096/360)*(0)));
  public static int wristMidSetPoint = (28*((4096/360)*(45)));
  public static int wristUpSetPoint = (28*((4096/360)*(90)));
  public static final double defaultWristPosition = 0;
  public static final double[] wristPIDValues = {0.1, 0.1, 0.01, 0};


  public static final double defaultElevatorPosition = 0;
  // FIGURE OUT WHAT VALUE IS SUPPOSED TO BE
  public static final double distanceToTicks = (4096 / (Math.PI * 1.432));

  // Sensor Constants
  public static double leftSensorToRightSensor = 7;
  public static double leftSensorToFrontSensor = 3.5;
  public static double rightSensorToFrontSensor = 3.5;
  public static double frontSensorToBackSensor = 7;
  public static double leftSensorToBackSensor = 3.5;
  public static double rightSensorToBackSensor = 3.5;
  public static double leftSensorToCenterOfRobot = 1;
  public static double frontSensorToCenterOfRobot = 3.5;

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
  /** END OTHER CONSTANTS **/
}
