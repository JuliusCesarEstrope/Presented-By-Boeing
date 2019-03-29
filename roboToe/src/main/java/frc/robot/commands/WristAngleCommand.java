package frc.robot.commands;

public class WristAngleCommand extends CommandBase {
  double wristSetPoint;

  public WristAngleCommand() {
    requires(wrist);
    // Use requires() here to declare subsystem dependencies

  }

  protected void initialize() {
  }

  protected void execute() {
    if((oi.getWristAxis() > 0.1 || oi.getWristAxis() < -0.1) && oi.getWristTurboButton()){
      wrist.setLeftWristMotor(oi.getWristAxis());
      wristSetPoint = wrist.getLeftWristEncoder();
    } else if(oi.getWristAxis() > 0.1 || oi.getWristAxis() < -0.1){
      wrist.setLeftWristMotor(oi.getWristAxis() * 0.4);
      wristSetPoint = wrist.getLeftWristEncoder();
    } else {
      //wrist.setLeftWristMotorPosition(wristSetPoint);
      //wrist.setRightWristMotor(wrist.getLeftTalonOutput());
    }

    
  }

  protected boolean isFinished() {
    // if needed to maintain set pont (false) stopping point (true)
    return false;
  }

  protected void end() {
   // drive.setBoth(0, 0);
    wrist.setBothWristMotor(0, 0);
  }

  protected void interrupted() {
    wrist.setBothWristMotor(0, 0);
  }
}