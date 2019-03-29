package frc.robot.commands;


import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class ElevatorHorizontalAutoCommand extends CommandBase {
  Potentiometer potentiometer;
  Timer timer;

  public ElevatorHorizontalAutoCommand() {
    requires(elevatorHorizontal);
    timer = new Timer();
  }

  protected void initialize() {
    RobotLog.putMessage("Running ElevatorHorizontalAutoCommand");
    drive.setBoth(0, 0);
    timer.start();
  }

  protected void execute() {
   elevatorHorizontal.setXElevatorMotor(.4);

  // if (elevatorHorizontal.getXElevatorEncoder() < Constants.elevatorHorizontalFast) {
  //   elevatorHorizontal.setXElevatorMotor(.6);

  // } else if (elevatorHorizontal.getXElevatorEncoder() >= Constants.elevatorHorizontalFast && elevatorHorizontal.getXElevatorEncoder() < Constants.elevatorHorizontalSlow) {
  //   elevatorHorizontal.setXElevatorMotor(.4);

  // } else if (elevatorHorizontal.getXElevatorEncoder() >= Constants.elevatorHorizontalSlow && elevatorHorizontal.getXElevatorEncoder() < Constants.elevatorHorizontalStop) {
  //   elevatorHorizontal.setXElevatorMotor(.2);
  //   drive.setBoth(.4, .4);

  // } else if (elevatorHorizontal.getXElevatorEncoder() >= Constants.elevatorHorizontalStop) {
  //   elevatorHorizontal.setXElevatorMotor(0);

  //  } SmartDashboard.putBoolean("X Elevator Sensor:", elevatorHorizontal.getlimitSwitch());
  //   SmartDashboard.putNumber("Speed of Horizontal Wheels:", elevatorHorizontal.getXElevatorMotor());
  }

  protected boolean isFinished() {
    return (elevatorHorizontal.getlimitSwitch() || oi.getElevatorEmergencyStopButton() || (elevatorHorizontal.getXElevatorEncoder() == 0) || timer.hasPeriodPassed(5));
  }

  protected void end() {
    drive.setBoth(0, 0);
    elevatorHorizontal.setXElevatorMotor(0);

  }

  protected void interrupted() {
    elevatorHorizontal.setXElevatorMotor(0);
  }
}