package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class ElevatorInPlaceCommand extends CommandBase {

  public ElevatorInPlaceCommand() {
    requires(elevatorVertical);
    requires(elevatorHorizontal);
    requires(drive);
  }

  protected void initialize() {
    RobotLog.putMessage("Running ElevatorInPlaceCommand");
    drive.setBoth(0, 0);
  }

  protected void execute() {
    elevatorVertical.setYElevatorMotorPosition(Constants.defaultElevatorPosition);

    if (!elevatorHorizontal.getfastSlowStopSensor()) {
      elevatorHorizontal.setXElevatorMotor(-.4);
    } else {
      elevatorHorizontal.setXElevatorMotor(0);
    }

    SmartDashboard.putBoolean("X Elevator Sensor:", elevatorHorizontal.getfastSlowStopSensor());
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    drive.setBoth(0, 0);
  }

  protected void interrupted() {
    drive.setBoth(0, 0);
  }
}