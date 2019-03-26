package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.utilities.RobotLog;

public class ElevatorFastSlowStopCommand extends CommandBase {
  int tapeHit;
  boolean tapeToggle;

  public ElevatorFastSlowStopCommand() {
    requires(elevatorHorizontal);
    requires(drive);
  }

  protected void initialize() {
    RobotLog.putMessage("Running ElevatorFastSlowStopCommand");
    drive.setBoth(0, 0);
    tapeToggle = true;
  }

  protected void execute() {
    if (elevatorHorizontal.getfastSlowStopSensor() && tapeToggle) {
      tapeHit++;
      tapeToggle = false;
    } else if (!elevatorHorizontal.getfastSlowStopSensor()){
      tapeToggle = true;
    }

    if (tapeHit == 0) {
      elevatorHorizontal.setXElevatorMotor(.6);

    } else if (tapeHit == 1) {
      elevatorHorizontal.setXElevatorMotor(.4);

    } else if (tapeHit == 2) {
      elevatorHorizontal.setXElevatorMotor(.2);
      drive.setBoth(.4, .4);

    } else if (tapeHit == 3) {
      elevatorHorizontal.setXElevatorMotor(0);

    }

    SmartDashboard.putBoolean("X Elevator Sensor:", elevatorHorizontal.getfastSlowStopSensor());
    SmartDashboard.putNumber("Tape hit of sensor:", tapeHit);
    SmartDashboard.putNumber("Speed of Horizontal Wheels:", elevatorHorizontal.getXElevatorMotor());
  }

  protected boolean isFinished() {
    return ((tapeHit == 3) || oi.getElevatorEmergencyStopButton());
  }

  protected void end() {
    drive.setBoth(0, 0);
  }

  protected void interrupted() {
    drive.setBoth(0, 0);
  }
}