// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  CANSparkMax frontRight;
  CANSparkMax frontLeft;
  CANSparkMax backRight;
  CANSparkMax backLeft;
  MotorControllerGroup rightMotorGroup;
  MotorControllerGroup leftMotorGroup;

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    frontRight = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushed);
    frontLeft = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushed);
    backRight = new CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushed);
    backLeft = new CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushed);
    rightMotorGroup = new MotorControllerGroup(frontRight, backRight);
    leftMotorGroup = new MotorControllerGroup(frontLeft, backLeft);
  }

  public void drive(double rightSpeed, double leftSpeed) {
    rightMotorGroup.set(rightSpeed);
    leftMotorGroup.setInverted(true);
    leftMotorGroup.set(leftSpeed);
  }

  public void stop() {
    rightMotorGroup.stopMotor();
    leftMotorGroup.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
