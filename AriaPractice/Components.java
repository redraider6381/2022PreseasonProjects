package frc.robot;
// NO TOUCHY Imports
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Encoder; // fancy
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.cscore.UsbCamera;// Idk if we are even using one 
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.I2C.*;
import edu.wpi.first.wpilibj.Ultrasonic;
// stuff for CAN
import com.revrobotics.CANEncoder; // fancy2.0
import edu.wpi.first.wpilibj.AnalogGyro; // special
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.cameraserver.*;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Counter;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class Components {

    
        // CAN Motors (THIS NEEDS TO BE MODIFIED WHEN WE KNOW WHERE ALL THE MOTERS ARE !!!!!!!!!!!!!!!!!IMPOTTANT!!!!!!!!!!!!!!!!!!!!!)
        public static CANSparkMax CANBackLeft     = new CANSparkMax(1, MotorType.kBrushless);
        public static CANSparkMax CANBackRight    = new CANSparkMax(3, MotorType.kBrushless);
        public static CANSparkMax CANFrontLeft    = new CANSparkMax(2, MotorType.kBrushless);
        public static CANSparkMax CANFrontRight   = new CANSparkMax(4, MotorType.kBrushless);
      
        // Joystick
        public static Joystick happyStick = new Joystick(1);
    
        // X-Box controller
        public static XboxController XBController = new XboxController(0);

        // encoder
        public encoder = new Encoder(0, 1);
        encoder.setDistancePerPulse(MATH.PI / 60.0);

        // gyro
        public gyro = new AlalogGyro(1);
    }
