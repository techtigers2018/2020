package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.util.Color;
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

    public void climb() {
        winchMotor.set(0.3);
    }

    public void descend() {
        winchMotor.set(-0.3);
    }
}
