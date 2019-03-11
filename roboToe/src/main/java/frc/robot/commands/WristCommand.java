package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.utilities.RobotLog;

public class WristCommand extends CommandBase {

  double wristSetPoint;

  public WristCommand(double wristSetPoint) {
    requires(wrist);
    // Use requires() here to declare subsystem dependencies
    RobotLog.putMessage("Running WristCommand");
    this.wristSetPoint = wristSetPoint;
  }

  protected void initialize() {

  }

  @Override
  protected void execute() {
    // Two Positions (Up, Down)
    wrist.setBothWristMotorPosition(wristSetPoint);
    SmartDashboard.putNumber("LeftWristEncoder", wrist.getLeftWristEncoder());
    SmartDashboard.putNumber("RightWristEncoder", wrist.getRightWristEncoder());
    
  }

  protected boolean isFinished() {
    // if needed to maintain set pont (false) stopping point (true)
    return false;
  }

  protected void end() {
    //drive.setBoth(0, 0);
    wrist.setBothWristMotor(0, 0);
  }

  protected void interrupted() {
    wrist.setBothWristMotor(0, 0);
  }
}