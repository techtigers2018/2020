package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.util.Color;
import frc.robot.Robot;

import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.PWMVictorSPX;

public class BuddyHang extends Subsystem {

    private static double limit;
    private PWMVictorSPX winchMotor;

    public BuddyHang() {
        limit = 10;
        winchMotor = new PWMVictorSPX(6);
        addChild("Winch Motor", winchMotor);
        winchMotor.setInverted(true);
    }

    @Override
    public void initDefaultCommand() {
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {

    }

    public void runMotor(boolean dir, boolean liftRobot) {
        if(dir && liftRobot) {
            climb();
        }
        else if (dir && !liftRobot) {
            spool();
        }
        else {
            descend();
        }
    }

    public void climb() {
        spool();
        hangerbackDrive();
    }

    public void descend() {
        winchMotor.set(-0.4);
    }

    public void spool() {
        winchMotor.set(0.43);
    }

    public void hangerbackDrive() {
        Robot.hanger.descend(-0.4);
    }

    public void stopMotor(){
        winchMotor.set(0);
        Robot.hanger.stopMotor();
    }
}
