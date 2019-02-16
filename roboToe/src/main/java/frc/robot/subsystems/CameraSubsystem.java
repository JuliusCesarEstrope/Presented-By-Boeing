package frc.robot.subsystems;
import edu.wpi.cscore.UsbCamera;
<<<<<<< HEAD:roboToe/src/main/java/frc/robot/subsystems/Camera.java
import frc.robot.utilities.RobotLog;

public class Camera {
=======
import edu.wpi.first.wpilibj.command.Subsystem;
public class CameraSubsystem extends Subsystem {
>>>>>>> Salvatore:roboToe/src/main/java/frc/robot/subsystems/CameraSubsystem.java
  Thread visionThread;

  public void init() {
    RobotLog.putMessage("Running Camera");
    visionThread = new Thread(() -> {
      UsbCamera camera = edu.wpi.first.cameraserver.CameraServer.getInstance().startAutomaticCapture();
      camera.setResolution(640, 480);
    });
    visionThread.setDaemon(true);
    visionThread.start();
  }

  public void initDefaultCommand() {
  }
}