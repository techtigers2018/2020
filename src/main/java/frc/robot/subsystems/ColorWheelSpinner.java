package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorSensorV3;

public class ColorWheelSpinner extends Subsystem {
    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    private final ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);
    private final Spark wheelSpinner = new Spark(7);

    public Color currentColor = new Color(0, 0, 0);
    public Color previousColor = new Color(0 ,0 ,0);
    public ColorWheelSpinner() {

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

}
