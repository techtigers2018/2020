package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.PWMVictorSPX;

public class Hanger extends Subsystem {

    private static double limit;
    private PWMVictorSPX hangerMotor;

    public Hanger() {
        limit = 10;
        hangerMotor = new PWMVictorSPX(0);
        addChild("Hanger Motor", hangerMotor);
        hangerMotor.setInverted(false);
    }

    @Override
    public void initDefaultCommand() {
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void climb() {
        hangerMotor.set(0.3);
    }

    public void descend() {
        hangerMotor.set(-0.3);
    }
}
