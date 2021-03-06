package frc.robot.utilities;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Timer;

public class ManualPID {
    double P, I, D;
    PIDSource pidSource;

    double previousError;
    double currentError;
    double PIDOutput;
    double setpoint;
    double currentPosition;
    double integral;
    double POutput;
    double IOutput;
    double DOutput;
    Timer timer;

    public ManualPID(double P, double I, double D, PIDSource pidSource){
         setPID(P, I, D);
         this.pidSource = pidSource;
         previousError = 0;
         currentError = 0;
         PIDOutput = 0;
         setpoint = 0;
         currentPosition = 0;
         integral = 0;
         POutput = 0;
         IOutput = 0;
         DOutput = 0;
         timer = new Timer();
    }

    public void setSetpoint(double setpoint) {
        this.setpoint = setpoint;
    }

    public void setCurrentPosition(double currentPosition) {
        this.currentPosition = currentPosition;
    }

    public double getError() {
        previousError = currentError;
        currentError = pidSource.pidGet() - setpoint;
        return currentError;
    }

    public double getIntegral(){
        if(I == 0){
            return 0;
        }
        else{
            integral += ((previousError + getError()) / 2) * timer.get();
            return integral; 
        }
        
    }

    public void setPID(double P, double I, double D) {
        setP(P);
        setI(I);
        setD(D);
    }

    public void setP(double P) {
        this.P = P;
    }

    public void setI(double I) {
        this.I = I;
        integral = 0;
    }

    public void setD(double D) {
        this.D = D;
    }

    public double getPIDOutput() {
        if (timer.get() == 0){
            timer.start();
        }

        POutput = getError() * P;
        IOutput = getIntegral() * I;
        DOutput = ((currentError - previousError) / timer.get()) * D;
        timer.reset();
        return POutput + IOutput + DOutput;
    }
}