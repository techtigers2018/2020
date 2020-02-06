package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class ColorWheelSpinner extends Subsystem {
    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    private final ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);
    // private final Spark wheelSpinner = new Spark(7);
    public Color[] colorOrder;

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

    public void readColor(){
        Color col;
        double sum_red, sum_blue, sum_green, avg_red, avg_blue, avg_green;
        sum_red = 0;
        sum_blue = 0;
        sum_green = 0;

        // for (int i = 0; i < 10; i++){
        //     Color tmp = colorSensor.getColor();
        //     sum_red += tmp.red;
        //     sum_blue += tmp.blue;
        //     sum_green += tmp.green;
        // }

        // avg_red = sum_red/10;
        // avg_green = sum_green/10;
        // avg_blue = sum_blue/10;
        // col = new Color(avg_red, avg_green, avg_blue);
        col = colorSensor.getColor();
        // col8 = new Color
        
        SmartDashboard.putString("Color", col.toString());
    }   

}
