package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
<<<<<<< HEAD
import frc.robot.commands.Roller;
=======
import frc.robot.commands.RollerCommand;
>>>>>>> Maggie
import frc.robot.utilities.RobotLog;

public class RollerSubsystem extends Subsystem {
  static TalonSRX rollerMotor;

  public RollerSubsystem(int rollerMotorPort) {

    rollerMotor = new WPI_TalonSRX(rollerMotorPort);
    RobotLog.putMessage("Running RollerSubsystem");
  }

  public void setRollerMotor(double Speed) {
    rollerMotor.set(ControlMode.PercentOutput, Speed);
  }

  public void initDefaultCommand() {
    setDefaultCommand(new RollerCommand());
  }
}