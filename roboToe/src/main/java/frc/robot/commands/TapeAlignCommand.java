package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.Utilities;
import frc.robot.utilities.RobotLog;

public class TapeAlignCommand extends CommandBase {

  private boolean endCommand;
  private boolean tapeTouched, touchFront, touchSide;
  private double start, end;

  private double startDistance;
  

  public TapeAlignCommand() {

    requires(drive);
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
  if (!drive.getLeftSensor()&&!drive.getFrontSensor()&&!drive.getRightSensor()&&!drive.getBackSensor()){
    drive.setBoth(0.3, 0.3);
  }
  drive.getWheelDistanceLeft();
  Utilities.AngleFinderFromFrontSensorToLeftSensor(drive.getWheelDistanceRight() - startDistance, Constants.leftSensorToCenterOfRobot);

  if(drive.getFrontSensor() || drive.getLeftSensor() || drive.getRightSensor() || drive.getBackSensor()){
    tapeTouched = true;
    }
  if (tapeTouched){
    
    if(!touchFront){
      start = drive.getWheelDistanceLeft();
      touchFront = true;
      }

      if(drive.getLeftSensor() || drive.getRightSensor()){
        
        if(!touchSide){
          end = drive.getWheelDistanceLeft();
          touchSide = true;
        }
        
      }

    } 

  if(touchFront){
    drive.setBoth(0.3,0.3);
    if(touchSide){ 
        drive.setBoth(0,0); 
        endCommand = true;
        //make sure this works!
        //new TurnAngle(Utilities.AngleFinderFromFrontSensorToLeftSensor(end-start,  Constants.frontSensorToCenterOfRobot));
        CommandBase.newDistanceToMove = Math.abs(Constants.frontSensorToCenterOfRobot-(end-start));
        CommandBase.turnAngle = Utilities.AngleFinderFromFrontSensorToLeftSensor(end-start,  Constants.frontSensorToCenterOfRobot);
      }
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return endCommand;
  }

  protected void end() {
    drive.setBoth(0, 0);

  }

  protected void interrupted() {
    drive.setBoth(0, 0);

  }
}