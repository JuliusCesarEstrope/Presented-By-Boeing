package frc.robot.commands;

public class WristAngleCommand extends CommandBase {

  double wristSetPoint;

  public WristAngleCommand() {
    requires(wrist);
    // Use requires() here to declare subsystem dependencies

  }

  protected void initialize() {

  }

  @Override
  protected void execute() {
    wrist.setBothWristMotor(oi.getWristAxis() * 0.4);
    
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