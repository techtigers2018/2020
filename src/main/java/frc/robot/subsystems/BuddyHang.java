package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.util.Color;
import frc.robot.Robot;

import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Solenoid;

public class BuddyHang extends Subsystem {

    private static double limit;
    private PWMVictorSPX winchMotor;
    private Solenoid buddyActuator1;
    private Solenoid buddyActuator2;

    public BuddyHang() {
        limit = 10;
        winchMotor = new PWMVictorSPX(6);
        buddyActuator1 = new Solenoid(0);
        buddyActuator2 = new Solenoid(1);
        addChild("Winch Motor", winchMotor);
        addChild("Buddy Actuator 1", buddyActuator1);
        addChild("Buddy Actuator 2", buddyActuator2);
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

    public void releaseBuddyHang() {
        buddyActuator1.set(true);
        System.out.println(buddyActuator1.get());
        buddyActuator2.set(true);
    }

    public void releaseSpring() {
        buddyActuator1.set(false);
        buddyActuator2.set(false);
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
