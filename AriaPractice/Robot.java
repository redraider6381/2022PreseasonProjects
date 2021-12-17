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
import frc.robot.Components;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

import java.io.Console;
import java.lang.Math;
// import edu.wpi.first.wpilibj.AnalogGyro;
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

  }
  public void Drive(double in, boolean forward) {
    encoder.reset();
    while(Components.encoder.getDistance() < in && forward){
      Components.CANBackLeft.set(0.5);
      Components.CANBackRight.set(0.5);
      Components.CANFrontLeft.set(0.5);
      Components.CANFrontRight.set(0.5);
    }
    while(Components.encoder.getDistance() > -in && forward == false){
      Components.CANBackLeft.set(-0.5);
      Components.CANBackRight.set(-0.5);
      Components.CANFrontLeft.set(-0.5);
      Components.CANFrontRight.set(-0.5);
    }
  }
  public void Turn(double angle, boolean clockwise){
    Components.gyro.reset();
    while(Components.gyro.getAngle() < angle && clockwise){
      Components.CANBackLeft.set(0.5);
      Components.CANBackRight.set(-0.5);
      Components.CANFrontLeft.set(0.5);
      Components.CANFrontRight.set(-0.5);
    }
    while(Components.gyro.getAngle() > -angle && clockwise == false){
      Components.CANBackLeft.set(-0.5);
      Components.CANBackRight.set(0.5);
      Components.CANFrontLeft.set(-0.5);
      Components.CANFrontRight.set(0.5);
    }
  }
  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void autonomousPeriodic() {
  //   int autoCount = 0;
  //   public static void barrel()
  //   {
  //       switch(autoCount){
  //         case 0:
  //         Drive(36, true);
  //         autocount++;

  //         case 1:
  //         Turn(36, true);
  //         break;

  //         case 2:
  //         Drive(36, false);
  //         break;
  //       }
        

  // }
  Components.CANBackLeft.set(usePID(encoder));
}
// public double It = 0;
// public double err;
// public double pErr;
//   public double err(int PV){
//     err = Components.pid.getSetpoint() - PV;
//     return err;
//   }
//   public void setPErr(double err){
//     pErr = err;
//   }
//   public double pErr(){
//     return pErr;
//   }
//   public double proportional(int PV){
//     setPErr(err(PV));
//     return Components.pid.getP() * err(PV);
//   }
//   public double integral(int PV){
//     double I = Components.pid.getI() * err(PV)  * 0.02/60;
//     It =+ I;
//     return It;
//   }
//   public double derivative(int PV){
//     return Components.pid.getD() * (err(PV) - pErr()) / 0.02/60;
//   }
//   public double usePID(int PV, int setPoint){
//     Components.pid.setSetPoint(setPoint);
//     return proportional(PV) + integral(PV) + derivative(PV);
//   }
  public double usePIDFancy(int PV, int setPoint){
    Components.pid.setSetPoint(setPoint);
    if (Components.pid.getI() > limit){
      Components.pid.setI(pid.getI() - )
    }
    Components.pid.calculate();
    double drivepower = Components.pid.get();
    Components.CANBackLeft.set(drivepower);
    Components.CANFrontLeft.set(drivepower);
    Components.CANBackRight.set(drivepower);
    Components.CANFrontRight.set(drivepower);
  }
  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() 
  {
    
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  
  }
 
}