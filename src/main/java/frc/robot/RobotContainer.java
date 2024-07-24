// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.DriveTrainCommand;
import frc.robot.commands.Shooter.ShooterCommand;
import frc.robot.commands.Shooter.ShooterPreCommand;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // robot subsystem
  
  public static final DriveTrainSubsystem drive = new DriveTrainSubsystem();
  public static final DriveTrainCommand driveTrainCommand = new DriveTrainCommand(drive);

  public static final ShooterSubsystem ShooterSubSystem = new ShooterSubsystem();
  public static final ShooterCommand shooterCommand = new ShooterCommand(ShooterSubSystem, 1);
  public static final ShooterPreCommand shooterprecomand = new ShooterPreCommand(ShooterSubSystem, 0, false);


  // Replace with CommandPS4Controller or CommandJoystick if needed
  public static final Joystick m_driverController = new Joystick(0);

  public static final Joystick m_operatorController = new Joystick(1);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    driveTrainCommand.addRequirements(drive);
    drive.setDefaultCommand(driveTrainCommand);
    
    ShooterSubSystem.setDefaultCommand(new ShooterCommand(ShooterSubSystem, 0));

    //m_driverController 

    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {
    

   new JoystickButton(m_driverController, Constants.ShooterConstants.ButtonLancar)
   .whileTrue(new ShooterCommand(ShooterSubSystem, 1));

   new JoystickButton(m_driverController, Constants.ShooterConstants.ButtonRecolher)
   .whileTrue(new ShooterCommand(ShooterSubSystem, -0.5));
   
   new JoystickButton(m_driverController, Constants.ShooterConstants.ButtonPreLanc)
   .whileTrue(new ShooterPreCommand(ShooterSubSystem, 1, true));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  //public Command getAutonomousCommand() {
    
 // }
}
