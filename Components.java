package frc.robot;
// NO TOUCHY Imports
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Encoder;
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
import com.revrobotics.CANEncoder;
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

        // NAVX SUPER Gyro (Idk if we are using a gyro)
        //public static AHRS OGgyro = new AHRS(SPI.Port.kMXP);
        public static ADXRS450_Gyro gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
        //public static AnalogGyro gyro = new AnalogGyro(0);
    
        // CAN Motors (THIS NEEDS TO BE MODIFIED WHEN WE KNOW WHERE ALL THE MOTERS ARE !!!!!!!!!!!!!!!!!IMPOTTANT!!!!!!!!!!!!!!!!!!!!!)
        public static CANSparkMax CANBackLeft     = new CANSparkMax(1, MotorType.kBrushless);
        public static CANSparkMax CANBackRight    = new CANSparkMax(3, MotorType.kBrushless);
        public static CANSparkMax CANFrontLeft    = new CANSparkMax(2, MotorType.kBrushless);
        public static CANSparkMax CANFrontRight   = new CANSparkMax(4, MotorType.kBrushless);
        public static CANSparkMax CANShooter  = new CANSparkMax(5, MotorType.kBrushless);
        public static CANSparkMax CANShooter2  = new CANSparkMax(7, MotorType.kBrushless);
        public static CANSparkMax CANShooterSpin =new CANSparkMax(6, MotorType.kBrushless);
        public static Servo ExampleServo  = new Servo(8);
        public static Servo ExampleServo2  = new Servo(9);



        // Joystick
        public static Joystick happyStick = new Joystick(1);
    
        // X-Box controller
        public static XboxController XBController= new XboxController(0);
    
        // Sparks
        public static Spark Spindexer        = new Spark(1);
        public static Spark sparkIntake       = new Spark(2);
        public static Spark shootAngler       = new Spark(3);
        public static Spark LeftUptake       = new Spark(4);
        public static Spark RightUptake       = new Spark(5);

    
        //lazer 
        public static I2C lidar;
        //public static Counter m_LIDAR = new Counter(0);

        // Encoders
    
        



        public static CANEncoder shooterEncoder             = CANShooter.getEncoder();

        public static CANEncoder backLeftEncoder            = CANBackLeft.getEncoder();
        public static CANEncoder backRightEncoder           = CANBackRight.getEncoder();
        public static CANEncoder frontLeftEncoder           = CANFrontLeft.getEncoder();
        public static CANEncoder frontRightEncoder          = CANFrontRight.getEncoder();
        
    
        //(((((((((((((((((((((((((((((((((((((((((((((((ignore)))))))))))))))))))))))))))))))))))))))))))))))
        // USB Camera
        //public static UsbCamera CameraUSB= new UsbCamera();
        //(((((((((((((((((((((((((((((((((((((((((((((((ignore)))))))))))))))))))))))))))))))))))))))))))))))
    
        // Limit Switch
        //public static DigitalInput limitSwitch = new DigitalInput(1);
    
        // PID controller (This is a coppy from last year THIS NEEDS AJUSTING)
        //public static PIDController example = new PIDController(1,.1,.001); (EXAMPLE)
        public static PIDController RPMPID = new PIDController(1,.1,.001);


        // limelight
    
        public static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");


		
    
        // the real for real intake sensor
    
        //public static DigitalInput intakeSensor = new DigitalInput(1);
        //public static DigitalInput intakeCounter = new DigitalInput(2);
    }
