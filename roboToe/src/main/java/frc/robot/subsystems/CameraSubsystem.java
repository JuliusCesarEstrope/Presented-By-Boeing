package frc.robot.subsystems;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.command.Subsystem;
public class CameraSubsystem extends Subsystem {
  Thread visionThread;
    public void init(){
        visionThread = new Thread(() -> {
        UsbCamera camera = edu.wpi.first.cameraserver.CameraServer.getInstance().startAutomaticCapture();
        camera.setResolution(640, 480);
      });
      visionThread.setDaemon(true);
      visionThread.start();
    }
  @Override
  public void initDefaultCommand() {
  }
}