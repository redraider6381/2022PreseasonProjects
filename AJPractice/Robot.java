/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

import java.io.Console;
import java.lang.Math;
<<<<<<< HEAD

import javax.print.CancelablePrintJob;

=======
>>>>>>> cf52aa3fc7d290cd1dc7cfa21c9bfdb730b3cdcb
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Counter;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANError;


import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DriverStation;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  double wheelDiameter = 6; //inches
  double gearRatio = 10.7; //1/10.7
<<<<<<< HEAD
  //Encoder Stuff
  private Encoder leftFrontEncoder;
  private Encoder leftBackEncoder;  
  private Encoder rightFrontEncoder;
  private Encoder rightBackEncoder;

  //methods
  public drive(double distance)
  {
    while(distance >= lfEncDist){
      Componenets.CANBackLeft.set(1);
    }else{

    }
  }

  @Override
  public void robotInit() {
    //   This function is called periodically at the start of all modes.
 
=======
  @Override
  public void robotInit() {
    //   This function is called periodically at the start of all modes.
 //Starts the motors stopped.
    Components.backLeftEncoder.setPosition(0);
    Components.backRightEncoder.setPosition(0);
    Components.frontLeftEncoder.setPosition(0);
    Components.frontRightEncoder.setPosition(0);
>>>>>>> cf52aa3fc7d290cd1dc7cfa21c9bfdb730b3cdcb
     //Motor set up:
  //When we set the motors to 0 power they imediatly stop
  Components.CANBackLeft.setIdleMode(IdleMode.kBrake);
  Components.CANFrontLeft.setIdleMode(IdleMode.kBrake);
  Components.CANBackRight.setIdleMode(IdleMode.kBrake);
  Components.CANBackRight.setIdleMode(IdleMode.kBrake);

  Components.CANBackLeft.setInverted(true);
  Components.CANFrontLeft.setInverted(true);
  //Inverts the right becuase the motors are flipped compared to the left 
  Components.CANBackRight.setInverted(false);
  Components.CANBackRight.setInverted(false);

<<<<<<< HEAD
  //Autonomous Encoder Stuff
  leftFrontEncoder = new Encoder(0,1);
  leftFrontEncoder.setDistancePerPulse(Math.PI / (360 / wheelDiameter));
  leftFrontEncoder.setReverseDirection(true);
  leftBackEncoder = new Encoder(2,3);
  leftBackEncoder.setDistancePerPulse(Math.PI / (360 / wheelDiameter));
  leftBackEncoder.setReverseDirection(true);
  rightFrontEncoder = new Encoder(4,5);
  rightFrontEncoder.setDistancePerPulse(Math.PI / (360 / wheelDiameter));
  rightBackEncoder = new Encoder(6,7);
  rightBackEncoder.setDistancePerPulse(Math.PI / (360 / wheelDiameter));

  double lfEncDist = leftFrontEncoder.getDistance();
  double lbEncDist = leftBackEncoder.getDistance();
  double rfEncDist = rightFrontEncoder.getDistance();
  double rbEncDist = rightBackEncoder.getDistance();

  double lfCounts = leftFrontEncoder.get();
  double lbCounts = leftBackEncoder.get();
  double rfCounts = rightFrontEncoder.get();
  double rbCounts = rightBackEncoder.get();
=======
>>>>>>> cf52aa3fc7d290cd1dc7cfa21c9bfdb730b3cdcb
  }

 
  @Override
  public void robotPeriodic() {
<<<<<<< HEAD
=======

>>>>>>> cf52aa3fc7d290cd1dc7cfa21c9bfdb730b3cdcb
  }
  /*
   This function is called periodically during all modes.

   */
  @Override
  public void autonomousInit() {
  }
  /**
   * This function is called periodically during operator control.
   */
<<<<<<< HEAD
  @Override
  public void autonomousPeriodic() {

    int autoCount = 0
    switch(autoCount);{

      case 0;
      while()
      break;

    }
  }
  
  @Override
  public void teleopPeriodic() 
  {
    
=======
  double autoCount = 0;
  @Override
  public void autonomousPeriodic() {
    switch(autoCount) {
           
      case 0:
       
          autoTimer.start();
      Component.CANBackRight = 0.25;
      Component.CANFrontRight = 0.25;
      Component.CANFrontLeft = -0.25;
      Component.CANBackLeft = -0.25;

      autoCount++;
      
      break;

      case 1:
      while (autoTimer.get() < 0.25){
      }
          autoTimer.start();
          Component.CANBackRight = -0.25;
          Component.CANFrontRight = -0.25;
          Component.CANFrontLeft = 0.25;
          Component.CANBackLeft = 0.25;
          System.Println("Monkey");

      autoCount++;
      }

      break;

      case 2:
      
          autoTimer.start();
      

      autoCount++;
      
      break;
      case 3:
      if (autoTimer.get() >= 3){
          autoTimer.start();
      

      autoCount++;
      }
      break;
      case 4:
          autoTimer.start();
      

      autoCount++;
  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() 
  {
    Components.CANBackLeft = Components.XBControl.getRawAxis(1);
    Components.CANFrontLeft = Components.XBControl.getRawAxis(1);
    Components.CANBackRight = Components.XBControl.getRawAxis(5);
    Components.CANFrontRight = Components.XBControl.getRawAxis(5);
    System.Println(Components.XBControl.getRawAxis(1) + " left, Monkey");
    System.Println(Components.XBControl.getRawAxis(5) + " right, AJ");

>>>>>>> cf52aa3fc7d290cd1dc7cfa21c9bfdb730b3cdcb
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  
  }
 
}