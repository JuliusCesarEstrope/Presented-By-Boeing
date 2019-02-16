package frc.robot.commands;
import frc.robot.Constants;
<<<<<<< HEAD

import frc.robot.utilities.RobotLog;

import frc.robot.utilities.RobotLog;
=======
>>>>>>> John-Schultz

public class WristCommand extends CommandBase {
<<<<<<< HEAD
<<<<<<< HEAD
    boolean buttonReleased;
    int leftWristEncoder;
    int rightWristEncoder;
    int wristDownSetPoint = 70;   ////////////////////////////////////
    int wristUpSetPoint = 0; /////////////////////////////////////////
    boolean wristUp = false;
    boolean wristDown = false;
    boolean moveWrist;
    double wristDistance;

  
<<<<<<< HEAD
<<<<<<< HEAD
  public WristCommand(int wristUpSetPoint) {
=======
  public WristCommand(double wristDistance) {
>>>>>>> John-Schultz
=======
  public WristCommand(double wristDistance) {
>>>>>>> John-Schultz
    // Use requires() here to declare subsystem dependencies
=======
=======
>>>>>>> Maggie
  boolean buttonReleased;
  int leftWristEncoder;
  int rightWristEncoder;
  int wristDownSetPoint = 70;
  int wristUpSetPoint = 0;
  boolean wristUp = false;
  boolean wristDown = false;
  boolean moveWrist;

  public WristCommand() {
    RobotLog.putMessage("Running WristCommand");
<<<<<<< HEAD
>>>>>>> Maggie
=======
>>>>>>> Maggie
    requires(wrist);
<<<<<<< HEAD
<<<<<<< HEAD
    leftWristEncoder = wrist.getLeftWristEncoder();
    rightWristEncoder = wrist.getRightWristEncoder();
<<<<<<< HEAD
=======
=======
>>>>>>> John-Schultz
    this.wristDistance = wristDistance;

>>>>>>> John-Schultz
  }

  protected void initialize() {
<<<<<<< HEAD
<<<<<<< HEAD
=======
  }

  protected void initialize() {
>>>>>>> Maggie
    // Set point
    // Send PID to correct motors

    buttonReleased = true;
<<<<<<< HEAD
<<<<<<< HEAD
    
    wrist.ResetEncoder();
    wrist.getLeftWristPIDOutput();
    wrist.getRightWristPIDOutput();
    wrist.setWristUpSetpoint(wristUpSetPoint);
    wrist.setWristDownSetpoint(wristDownSetPoint);
=======
    moveWrist = false;

    wrist.ResetEncoder();
    wrist.getLeftWristPIDOutput();
    wrist.getRightWristPIDOutput();
    // wrist.setLeftWristSetpoint(leftWristEncoder);
    // wrist.setRightWristSetpoint(rightWristEncoder);
>>>>>>> Maggie
=======
    //Set point
    //Send PID to correct  motors
    wrist.setWristSetpoint(wristDistance + Constants.defaultWristPosition);

=======
    //Set point
    //Send PID to correct  motors
    wrist.setWristSetpoint(wristDistance + Constants.defaultWristPosition);

>>>>>>> John-Schultz
    //wrist.setLeftWristSetpoint(leftWristEncoder);
    //wrist.setRightWristSetpoint(rightWristEncoder);
>>>>>>> John-Schultz
=======
    moveWrist = false;

    wrist.ResetEncoder();
    wrist.getLeftWristPIDOutput();
    wrist.getRightWristPIDOutput();
    // wrist.setLeftWristSetpoint(leftWristEncoder);
    // wrist.setRightWristSetpoint(rightWristEncoder);
>>>>>>> Maggie
  }

  @Override
  protected void execute() {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    // Two Positions (Up, Down)

<<<<<<< HEAD
    if(leftWristEncoder <= 0 && rightWristEncoder >= 0) {
      wrist.setBothWristMotor(-0.70, 0.70);
    }

    else if(leftWristEncoder >= 0 && rightWristEncoder <= 0) {
=======
    if (moveWrist && leftWristEncoder <= 0 && rightWristEncoder >= 0) {
      wrist.setBothWristMotor(-0.70, 0.70);
    }

    else if (!moveWrist && leftWristEncoder >= 0 && rightWristEncoder <= 0) {
>>>>>>> Maggie
=======
    // Two Positions (Up, Down)

    if (moveWrist && leftWristEncoder <= 0 && rightWristEncoder >= 0) {
      wrist.setBothWristMotor(-0.70, 0.70);
    }

    else if (!moveWrist && leftWristEncoder >= 0 && rightWristEncoder <= 0) {
>>>>>>> Maggie
      wrist.setBothWristMotor(0.70, -0.70);
    }

    if (wristUp && leftWristEncoder >= 0 && rightWristEncoder <= 0) {
      wrist.setWristUpSetpoint(wristUpSetPoint);

    }

    if (wristDown && rightWristEncoder >= 0 && leftWristEncoder <= 0) {
      wrist.setWristDownSetpoint(wristDownSetPoint);
    }
=======
    //Two Positions (Up, Down)
    wrist.setBothWristMotor(wrist.getLeftWristPIDOutput());
    
>>>>>>> John-Schultz
=======
    //Two Positions (Up, Down)
    wrist.setBothWristMotor(wrist.getLeftWristPIDOutput());
    
>>>>>>> John-Schultz
  }

  protected boolean isFinished() {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Maggie
    // if needed to maintain set pont (false) stopping point (true)
    return false;
=======
    //if needed to maintain set pont (false) stopping point (true)
    return wrist.leftWristOnTarget();
>>>>>>> John-Schultz
=======
    //if needed to maintain set pont (false) stopping point (true)
    return wrist.leftWristOnTarget();
>>>>>>> John-Schultz
  }

  protected void end() {
<<<<<<< HEAD
<<<<<<< HEAD
    drive.setBoth(0, 0);  
=======
    wrist.setBothWristMotor(0, 0);
>>>>>>> John-Schultz
=======
    wrist.setBothWristMotor(0, 0);
>>>>>>> John-Schultz
  }

  protected void interrupted() {
    wrist.setBothWristMotor(0, 0);
  }
}