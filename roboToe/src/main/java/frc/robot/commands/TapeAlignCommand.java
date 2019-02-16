package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.Utilities;
import frc.robot.utilities.RobotLog;

public class TapeAlignCommand extends CommandBase {

  private boolean endCommand;
  private boolean tapeTouched, touchFront, touchSide;
  private double start, end;

<<<<<<< HEAD
  private double startDistance, newDistanceToMove;
=======
  private double startDistance;
  
>>>>>>> Josh-Frazier

  public TapeAlignCommand() {

    requires(drive);
  }

  protected void initialize() { 
<<<<<<< HEAD
    RobotLog.putMessage("Running TapeAlignCommand");
    startDistance = drive.getWheelDistanceRight();
=======
>>>>>>> Josh-Frazier
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
<<<<<<< HEAD
    drive.getWheelDistanceLeft();
    //Utilities.AngleFinder(drive.getWheelDistanceLeft());
=======
>>>>>>> Josh-Frazier

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

<<<<<<< HEAD
  if(drive.getLeftSensor()&&drive.getFrontSensor()&&drive.getRightSensor())

  {
    endCommand = true;
  }else if(drive.getLeftSensor()&&drive.getFrontSensor()&&!drive.getRightSensor())
  {
    drive.setBoth(0.1, 0);
  }else if(!drive.getLeftSensor()&&drive.getFrontSensor()&&drive.getRightSensor())
  {
    drive.setBoth(0, 0.1);
  }else if(!drive.getLeftSensor()&&!drive.getFrontSensor()&&drive.getRightSensor())
  {
    drive.setBoth(.1, 0);
  }else if(drive.getLeftSensor()&&!drive.getFrontSensor()&&!drive.getRightSensor())
  {
    drive.setBoth(0, .1);
  }else if(!drive.getLeftSensor()&&!drive.getFrontSensor()&&!drive.getRightSensor())
  {
    endCommand = true;
  }else if(!drive.getLeftSensor()&&drive.getFrontSensor()&&!drive.getRightSensor())
  {
    drive.setBoth(.1, .1);
  }

=======
  // Make this return true when this Command no longer needs to run execute()
  @Override
>>>>>>> Josh-Frazier
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