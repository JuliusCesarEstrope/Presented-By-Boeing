package frc.robot.subsystems;
import edu.wpi.cscore.UsbCamera;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class Camera {
  Thread visionThread;

  public void init() {
    if (Constants.wristEnabled){
    RobotLog.putMessage("Running Camera");
    visionThread = new Thread(() -> {
      UsbCamera camera = edu.wpi.first.cameraserver.CameraServer.getInstance().startAutomaticCapture();
      camera.setResolution(640, 480);
    });
    visionThread.setDaemon(true);
    visionThread.start();
  }
  }

  public void initDefaultCommand() {
    if (Constants.wristEnabled){
    }
  }
}