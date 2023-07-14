// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class RobotContainer {
  private final DriveSubsystem m_drive = new DriveSubsystem();

  private static final PS4Controller m_controller = new PS4Controller(0);
  private static final JoystickButton m_r1 = new JoystickButton(m_controller, 5);
  private static final JoystickButton m_circle = new JoystickButton(m_controller, 2);


  public RobotContainer() {
    configureBindings();
    m_drive.setDefaultCommand(new Stop(m_drive));
  }

  private void configureBindings() {
    m_r1.whileTrue(new DriveForward(m_drive));
    m_circle.onTrue(new DriveToDistance(m_drive, 3));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
