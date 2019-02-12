package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.commands.Roller;
public class RollerSubsystem extends Subsystem {
  static TalonSRX rollerMotor;
public RollerSubsystem(int rollerMotorPort){
  
  rollerMotor = new WPI_TalonSRX(rollerMotorPort);
}
public void setRollerMotor(double Speed){
  rollerMotor.set(ControlMode.PercentOutput, Speed);
}
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Roller());
  }
}