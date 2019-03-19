package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.RollerCommand;


public class CounterWeightSubsystem extends Subsystem {
  static TalonSRX counterWeightMotor; 
  Timer timer; 
  
  public CounterWeightSubsystem(int counterWeightMotorPort) {
    counterWeightMotor = new WPI_TalonSRX(counterWeightMotorPort);
    timer = new Timer();
  }

  public void setCounterWeightMotor(double Speed) {
    counterWeightMotor.set(ControlMode.PercentOutput, Speed);
    }
  

  public void initDefaultCommand() {
    
  }

}