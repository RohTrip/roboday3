// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;


public class DriveSubsystem extends SubsystemBase {
  CANSparkMax m_leftMotor1 = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax m_leftMotor2 = new CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax m_rightMotor1 = new CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax m_rightMotor2 = new CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushless);

  MotorControllerGroup m_leftMotors = new MotorControllerGroup(m_leftMotor1, m_leftMotor2);
  MotorControllerGroup m_rightMotors = new MotorControllerGroup(m_rightMotor1, m_rightMotor2);


  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    m_leftMotor1.getEncoder().setPosition(0);
    m_leftMotor2.getEncoder().setPosition(0);
    m_rightMotor1.getEncoder().setPosition(0);
    m_rightMotor2.getEncoder().setPosition(0);

    m_leftMotor1.getEncoder().setPositionConversionFactor(Units.inchesToMeters(6) * Math.PI);
    m_leftMotor2.getEncoder().setPositionConversionFactor(Units.inchesToMeters(6) * Math.PI);
    m_rightMotor1.getEncoder().setPositionConversionFactor(Units.inchesToMeters(6) * Math.PI);
    m_rightMotor2.getEncoder().setPositionConversionFactor(Units.inchesToMeters(6) * Math.PI);

    m_leftMotor1.getEncoder().setInverted(true);
    m_leftMotor2.getEncoder().setInverted(true);
  }

  public void drive(double speed) {
    m_leftMotors.set(-speed);
    m_rightMotors.set(speed);
  }

  public double getDistance() {
    return m_leftMotor1.getEncoder().getPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
