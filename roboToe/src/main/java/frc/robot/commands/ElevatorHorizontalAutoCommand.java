package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.utilities.RobotLog;

public class ElevatorHorizontalAutoCommand extends CommandBase {

  public ElevatorHorizontalAutoCommand() {
    requires(elevatorHorizontal);
  
  }

  protected void initialize() {
    RobotLog.putMessage("Running ElevatorHorizontalAutoCommand");
    drive.setBoth(0, 0);
 
  }

  protected void execute() {
   elevatorHorizontal.setXElevatorMotors(.4);

    SmartDashboard.putBoolean("X Elevator Sensor:", elevatorHorizontal.getlimitSwitch());
    SmartDashboard.putNumber("Speed of Horizontal Wheels:", elevatorHorizontal.getXElevatorMotors());
  }

  protected boolean isFinished() {
    return (elevatorHorizontal.getlimitSwitch() || oi.getElevatorEmergencyStopButton());
  }

  protected void end() {
    drive.setBoth(0, 0);
  }

  protected void interrupted() {
    drive.setBoth(0, 0);
  }
}