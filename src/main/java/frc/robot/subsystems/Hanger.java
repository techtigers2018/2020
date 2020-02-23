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
        hangerMotor = new PWMVictorSPX(5);
        addChild("Hanger Motor", hangerMotor);
        hangerMotor.setInverted(false);
    }

    @Override
    public void initDefaultCommand() {
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {

    }

    public void runMotor(boolean dir) {
        if(dir) {
            climb();
        }
        else {
            double speed = -0.75;
            descend(speed);
        }
    }

    public void climb() {
        hangerMotor.set(1);
    }

    public void descend(double speed) {
        hangerMotor.set(speed);
    }

    public void stopMotor(){
        hangerMotor.set(0);
    }
}
