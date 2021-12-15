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

// indevidual motors
 BLEncoder = new encoder(0);
BLEncoder.setDistancePerPulse(Math.PI / 60);
BLEncoder.setReverseDirection(true);
FLEncoder = new encoder(1);
FLEncoder.setDistancePerPulse(Math.PI / 60);
FLEncoder.setReverseDirection(true);
BREncoder = new encoder(2);
BREncoder.setDistancePerPulse(Math.PI / 60);
FREncoder = new encoder(3);
FREncoder.setDistancePerPulse(Math.PI / 60);

Double FLEncDist = FLEncoder.getDistance();
Double BLEncDist = BLEncoder.getDistance();
Double FREncDist = FREncoder.getDistance();
Double BREncDist = BREncoder.getDistance();

// the left side and right side
// LeftSideEnc = new encoder(0, 1);
// LeftSideEnc.setDistancePerPulse(Math.PI / 60);
// LeftSideEnc.setReverseDirection(true);

// RightSideEnc = new encoder(2, 3);
// RightSideEnc.setDistancePerPulse(Math.PI / 60);


private static void travel(Double TravelDist){
  while( FLEncDist < TravelDist && BLEncDist < TravelDist && FREncDist < TravelDist && BREncDist < TravelDist){
    Components.CANFrontLeft.set(1);
    Components.CANFrontRight.set(1);
    Components.CANBackLeft.set(1);
    Components.CANBackRight.set(1);
    FLEncDist = FLEncoder.getDistance();
    BLEncDist = BLEncoder.getDistance();
    FREncDist = FREncoder.getDistance();
    BREncDist = BREncoder.getDistance();
}
}
private static void TurnLeft()

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
  }
  /**
   * This function is called periodically during operator control.
   */
  // add the input
  
  
  @Override
  private Timer autoTimer = new Timer();
  public void autonomousPeriodic() {

    
     
    switch(autoCount){
      case 0:
      
      autoTimer.start();
    Components.CANFrontLeft.set(0);
    Components.CANBackLeft.set(0);
    Components.CANFrontRight.set(0);
    Components.CANBackRight.set(0);
    autoCount++;

    break;
    
    case 1;
   // autoTimer.start();
    Travel(3);
    autoCounter++;
    
    
    // case 1;
    // autoTimer.start();
    // Components.CANFrontLeft.set(0);
    // Components.CANBackLeft.set(0);
    // Components.CANFrontRight.set(0);
    // Components.CANBackRight.set(0);
    // autoCounter++;

      break;

      case 2;
      autoTimer.start();
      Components.CANFrontLeft.set(0);
      Components.CANBackLeft.set(0);
      Components.CANFrontRight.set(0);
      Components.CANBackRight.set(0);
      autoCounter++;
      
      // break;
      
  //     case 3;

  //     Travel(5);
  //     autoCounter++;
      

  //     if (autoTimer.get() >= 3){
  //     autoTimer.start();
  //     Components.CANFrontLeft.set(0);
  //     Components.CANBackLeft.set(0);
  //     Components.CANFrontRight.set(0);
  //     Components.CANBackRight.set(0);
  //     autoCounter++;
  // }
  //     break;

  //     case 4;
  //     autoTimer.start();
  //     Components.CANFrontLeft.set(0);
  //     Components.CANBackLeft.set(0);
  //     Components.CANFrontRight.set(0);
  //     Components.CANBackRight.set(0);
  //     autoCounter++;
      
  //     break;      

  //     case 5;
  //     Travel(5);
  //     autoCounter++;
      
  //     if (autoTimer.get() >= 1.85){
  //     autoTimer.start();
  //     Components.CANFrontLeft.set(0);
  //     Components.CANBackLeft.set(0);
  //     Components.CANFrontRight.set(0);
  //     Components.CANBackRight.set(0);
  //     autoCounter++;
  //     }
  //     break;

  //     case 6;
  //     autoTimer.start();
  //     Components.CANFrontLeft.set(0);
  //     Components.CANBackLeft.set(0);
  //     Components.CANFrontRight.set(0);
  //     Components.CANBackRight.set(0);
  //     autoCounter++;
      
  //     break;

  //     case 7;
  //     Travel(1);
  //     autoCounter++;

  //     if (autoTimer.get() >= .78){
  //     autoTimer.start();
  //     Components.CANFrontLeft.set(0);
  //     Components.CANBackLeft.set(0);
  //     Components.CANFrontRight.set(0);
  //     Components.CANBackRight.set(0);
  //     autoCounter++;
  //     }

  //     break;

  //     case 8;
  //     autoTimer.start();
  //     Components.CANFrontLeft.set(-0.5);
  //     Components.CANBackLeft.set(-0.5);
  //     Components.CANFrontRight.set(0.5);
  //     Components.CANBackRight.set(0.5);
  //     autoCounter++;
      
  //     break;

  //     case 9;
  //     if (autoTimer.get() >= 2.65){
  //     autoTimer.start();
  //     Components.CANFrontLeft.set(0);
  //     Components.CANBackLeft.set(0);
  //     Components.CANFrontRight.set(0);
  //     Components.CANBackRight.set(0);
  //     autoCounter++;
  //     }
  //     break;

  //     case 10;
  //     autoTimer.start();
  //     Components.CANFrontLeft.set(0.5);
  //     Components.CANBackLeft.set(0.5);
  //     Components.CANFrontRight.set(0.5);
  //     Components.CANBackRight.set(0.5);
  //     autoCounter++;
      
  //     break;

  //     case 11;
  //     if (autoTimer.get() >= 1.43){
  //     autoTimer.start();
  //     components.CANFrontLeft.set(0);
  //     components.CANFrontRight.set(0);
  //     components.CANBackLeft.set(0);
  //     components.CANBackRight.set(0);
  //     autoCounter++;
  //   }

  //   break;

  //   case 12;
  //   autoTimer.start();
  //   components.CANFrontLeft.set(.5);
  //   components.CANFrontRight.set(-.5);
  //   components.CANBackRight.set(-.5);
  //   components.CANBackLeft.set(.5)
  //   autoCounter++;

  //   break;

  //   case 13;
  //     if (autoTimer.get() >= 2.24){
  //     autoTimer.start();
  //     components.CANFrontLeft.set(0);
  //     components.CANFrontRight.set(0);
  //     components.CANBackLeft.set(0);
  //     components.CANBackRight.set(0);
  //     autoCounter++;
  //   }

  //   break;

  //   case 14;
     
  //     autoTimer.start();
  //     components.CANFrontLeft.set(-0.5);
  //     components.CANFrontRight.set(0.5);
  //     components.CANBackLeft.set(-0.5);
  //     components.CANBackRight.set(0.5);
  //     autoCounter++;

  //     break;

  //     case 15;
  //     if (autoTimer.get() >= 2.45){
  //     autoTimer.start();
  //     components.CANFrontLeft.set(0);
  //     components.CANFrontRight.set(0);
  //     components.CANBackLeft.set(0);
  //     components.CANBackRight.set(0);
  //     autoCounter++;
  //   }
    
  }
  /**
   * This function is called periodically during operator control.
   */
  @Override
  private Encoder LEncoder;
  private Encoder REncoder;
 
  public void teleopPeriodic() 
  {
    //Add Teleop Code here!!!
   
    // Motors
    Double leftRear = Components.XBController.getRawAxis(0);
    Double leftFront = Components.XBController.getRawAxis(1);
    Double rightFront = Components.XBController.getRawAxis(3);    
    Double rightRear = Components.XBController.getRawAxis(2);
    Boolean xButtonPressed = Components.XBController.getXButtonPressed();
    Boolean aButtonPressed = components.XBController.getAButtonPressed();

    Components.CANFrontLeft.set(leftFront);
    Components.CANBackLeft.set(leftRear);
    Components.CANFrontRight.set(rightFront);
    Components.CANBackLeft.set(rightRear);
    if(xButtonPressed){
      Components.CANFrontRight.set(0);
      Components.CANFrontLeft.set(0); 
      Components.CANBackLeft.set(0);
      Components.CANBackRight.set(0);
    }
    if(aButtonPressed){

    }
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  
  }
 
}