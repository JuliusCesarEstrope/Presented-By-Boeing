package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.Utilities;

public class TapeAlignCommand extends CommandBase {

  private boolean endCommand;
  private boolean tapeTouched, touchFront, touchSide;
  private double start, end;

  private double startDistance, newDistanceToMove;
  

  public TapeAlignCommand() {

    requires(drive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() { 
    startDistance = drive.getWheelDistanceRight();
    drive.setBoth(0, 0);
    endCommand = false;
    tapeTouched = false;
    touchFront = false;
    touchSide = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  if (!drive.getLeftSensor()&&!drive.getFrontSensor()&&!drive.getRightSensor()&&!drive.getBackSensor()){
    drive.setBoth(0.3, 0.3);
  }
  drive.getWheelDistanceLeft();
  Utilities.AngleFinderFromFrontSensorToLeftSensor(drive.getWheelDistanceRight() - startDistance, Constants.leftSensorToCenterSensor);

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
        Utilities.AngleFinderFromFrontSensorToLeftSensor(end-start, Constants.frontSensorToCenterSensor);
        newDistanceToMove = Math.abs(Constants.frontSensorToCenterSensor-(end-start));
        

      }
    }
  } 

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return endCommand;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    drive.setBoth(0, 0);
   
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    drive.setBoth(0, 0);
    
  }
}
