/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

public class WristCommand extends CommandBase {
    boolean buttonReleased;
    int leftWristEncoder;
    int rightWristEncoder;
    int wristDownSetPoint = 70;   ////////////////////////////////////
    int wristUpSetPoint = 0; /////////////////////////////////////////
    boolean wristUp = false;
    boolean wristDown = false;
  
  public WristCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(wrist);
    leftWristEncoder = wrist.getLeftWristEncoder();
    rightWristEncoder = wrist.getRightWristEncoder();

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Set point
    //Send PID to correct  motors

    buttonReleased = true;
    moveWrist = false;
    
    wrist.ResetEncoder();
    wrist.getLeftWristPIDOutput();
    wrist.getRightWristPIDOutput();
    //wrist.setLeftWristSetpoint(leftWristEncoder);
    //wrist.setRightWristSetpoint(rightWristEncoder);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //Two Positions (Up, Down)
  

    if(moveWrist && leftWristEncoder <= 0 && rightWristEncoder >= 0) {
      wrist.setBothWristMotor(-0.70, 0.70);
      
    }

    else if(!moveWrist && leftWristEncoder >= 0 && rightWristEncoder <= 0) {
      wrist.setBothWristMotor(0.70, -0.70);
    }

    if(wristUp && leftWristEncoder >=0 && rightWristEncoder <= 0) {
      wrist.setWristUpSetpoint(wristUpSetPoint);
      
    }

    if(wristDown && rightWristEncoder >=0 && leftWristEncoder <= 0) {
      wrist.setWristDownSetpoint(wristDownSetPoint);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    //if needed to maintain set pont (false) stopping point (true)
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
