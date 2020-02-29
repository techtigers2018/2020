package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.PIDSubsystem;


public class MotorBuddyHang extends Subsystem {
    private Spark leftBuddyMotor, rightBuddyMotor;

    public MotorBuddyHang() {
        leftBuddyMotor = new Spark(7);
        leftBuddyMotor.setInverted(false);
        rightBuddyMotor = new Spark(8);
        rightBuddyMotor.setInverted(true);
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new MotorHangCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
    }
    public void setBuddyMotors(boolean left, boolean right, boolean up, boolean down){
        int i = 0;
        double speed = 0.5;
        if (up){
            i = -1;
        }
        else if (down){
            i = 1;
        }
        if (left){
            leftBuddyMotor.set(speed * i);
        }
        else{
            leftBuddyMotor.set(0);
        }
        if (right){
            rightBuddyMotor.set(speed * i);
        }
        else{
            rightBuddyMotor.set(0);
        }
    }
}
