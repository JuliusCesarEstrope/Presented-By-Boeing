package frc.robot.commands;

public class FourBarAngleCommand extends CommandBase {

  double wristSetPoint;

  public FourBarAngleCommand() {
    //requires(fourBar);
    // Use requires() here to declare subsystem dependencies

  }

  protected void initialize() {

  }

  @Override
  protected void execute() {

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