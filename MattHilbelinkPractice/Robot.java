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
  @Override
  public void robotInit() {
    //   This function is called periodically at the start of all modes.
 //Starts the motors stopped.
    Components.backLeftEncoder.setPosition(0);
    Components.backRightEncoder.setPosition(0);
    Components.frontLeftEncoder.setPosition(0);
    Components.frontRightEncoder.setPosition(0);
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

  }

 
  @Override
  public void robotPeriodic() {
  }
  /*
   This function is called periodically during all modes.

   */
  @Override
  public void autonomousInit() {
    Components.Lidar
  }
  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void autonomousPeriodic() {
  }
  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() 
  {//XBox Controller connected to COM(USB) Port 0 from Components.java

  //Move the left wheels to the Left Joystick Y Axis Position
    double leftVerticalAxis = XBController.getRawAxis(1);
    CANBackLeft.set(leftVerticalAxis);
    CANFrontLeft.set(leftVerticalAxis);

  //Move the right wheels to the Right joystick y Axis Position
  double rightVerticalAxis = XBController.getRawAxis(5);
    CANBackRight.set(rightVerticalAxis);
    CANFrontRight.set(rightVerticalAxis);

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  
  }
 
}