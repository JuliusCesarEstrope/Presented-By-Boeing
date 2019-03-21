package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.Utilities;
import frc.robot.utilities.RobotLog;

public class TapeAlignCommand extends CommandBase {

  private boolean endCommand;
  private boolean tapeTouched, touchFront, touchSide;
  private double start, end;
  private double angleToTurn;

  private double startDistance;
  
  public TapeAlignCommand() {
    requires(drive);
    requires(led);
  }

  protected void initialize() {
    RobotLog.putMessage("Running TapeAlignCommand");
    startDistance = drive.getWheelDistanceRight();
    drive.setBoth(0, 0);
    endCommand = false;
    tapeTouched = false;
    touchFront = false;
    touchSide = false;
  }

  protected void execute() {
    if (!drive.getLeftSensor() && !drive.getFrontSensor() && !drive.getRightSensor() && !drive.getBackSensor()) {
      drive.setBoth(0.3, 0.3);
    }

    if (drive.getFrontSensor() || drive.getLeftSensor() || drive.getRightSensor() || drive.getBackSensor()) {
      tapeTouched = true;
    }
    if (tapeTouched) {

      if (!touchFront && drive.getFrontSensor()) {
        start = drive.getWheelDistanceLeft();
        touchFront = true;
      }

      if ((drive.getLeftSensor() || drive.getRightSensor()) && touchFront) {

        if (!touchSide) {
          end = drive.getWheelDistanceLeft();
          touchSide = true;
        }

      }

    }

    if (touchFront) {
      drive.setBoth(0.3, 0.3);
      if (touchSide) {
        drive.setBoth(0, 0);
        endCommand = true;
        // make sure this works!
        // new TurnAngle(Utilities.AngleFinderFromFrontSensorToLeftSensor(end-start,
        // Constants.frontSensorToCenterOfRobot));
      //  CommandBase.newDistanceToMove = Math.abs(Constants.frontSensorToCenterOfRobot - (end - start));
        angleToTurn = Utilities.AngleFinderFromFrontSensorToLeftSensor(end - start,
            Constants.frontSensorToCenterOfRobot);
        CommandBase.turnAngle = angleToTurn;
      }
    }
    SmartDashboard.putBoolean("Left Sensor", drive.getLeftSensor());
    SmartDashboard.putBoolean("Front Sensor", drive.getFrontSensor());
    SmartDashboard.putBoolean("Right Sensor", drive.getRightSensor());
    SmartDashboard.putBoolean("Back Sensor", drive.getBackSensor());
    SmartDashboard.putNumber("Calculated Angle", (angleToTurn));
    SmartDashboard.putNumber("DistanceTraveled", drive.getWheelDistanceLeft());
  }

  protected boolean isFinished() {
    return endCommand;
  }

  protected void end() {
    drive.setBoth(0, 0);
    led.setLEDLightColor(.87); // Blue
  }

  protected void interrupted() {
    drive.setBoth(0, 0);
    led.setLEDLightColor(.87); // Blue
  }
}