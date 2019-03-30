/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.CommandBase;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  Command m_autonomousCommand;
  public static Timer matchTimer;
  //Command LEDCommand = new LEDCommand(matchTimer);
  SendableChooser<Command> m_chooser = new SendableChooser<>();
  CommandBase commandBase;
  public static boolean onAttackPosition;
  private double ultrasonicPosition;

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    //m_chooser.setDefaultOption("Default Auto", new Auton());
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
    matchTimer = new Timer();
    onAttackPosition = false; 
    CommandBase.init();
    CommandBase.led.setLEDLightColor(0.87);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    //RobotLog.putMessage("Vertical Elevator Encoders"+ CommandBase.elevatorVertical.getVerticalElevatorEncoder());
  }

  /**
   * This function is called once each time the robot enters Disabled mode. You
   * can use it to reset any subsystem information you want to clear when the
   * robot is disabled.
   */
  @Override
  public void disabledInit() {
    
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString code to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons to
   * the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    //m_autonomousCommand = m_chooser.getSelected();
    //m_autonomousCommand = new AutonInput();
    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
     * switch(autoSelected) { case "My Auto": autonomousCommand = new
     * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
     * ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
    /*if(commandBase.oi.getleftYAxis() > 0.1 && commandBase.oi.getrightYAxis() > 0.1){
      m_autonomousCommand.cancel();
    }*/
  }

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    matchTimer.start();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    /*
    if(commandBase.oi.getleftYAxis() > 0.1 && commandBase.oi.getrightYAxis() > 0.1){
      m_autonomousCommand.cancel();
    }*/

    SmartDashboard.putString("DB/String 0", "" + CommandBase.elevatorHorizontal.getXElevatorEncoder());
    SmartDashboard.putString("DB/String 2", "" + CommandBase.wrist.getLeftWristEncoder());
    SmartDashboard.putString("DB/String 3", "" + CommandBase.elevatorVertical.getVerticalElevatorEncoder());
    SmartDashboard.putString("DB/String 5", "" + CommandBase.elevatorHorizontal.getlimitSwitch());
    SmartDashboard.putString("DB/String 4", "" + CommandBase.ultra.getUltrasonic());
    SmartDashboard.putString("DB/String 9", "" + matchTimer.get());
    Scheduler.getInstance().run();

    ultrasonicPosition = CommandBase.ultra.getUltrasonic();
    if(onAttackPosition)
      if(ultrasonicPosition > Constants.ultrasonicAttack[0] && ultrasonicPosition < Constants.ultrasonicAttack[1])
        CommandBase.led.setLEDLightColor(0.77);
      else
        CommandBase.led.setLEDLightColor(0.87);
    else
      if(ultrasonicPosition > Constants.ultrasonicVertical[0] && ultrasonicPosition < Constants.ultrasonicVertical[1]){
        SmartDashboard.putBoolean("DB/LED 0",  true);
        CommandBase.led.setLEDLightColor(0.77);
      }
      else{
        CommandBase.led.setLEDLightColor(0.87);
        SmartDashboard.putBoolean("DB/LED 0",  false);
      }
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
