// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class DriveTrainCommand extends Command {
 
//  private final DriveTrainSubsystem drive;
  
  public DriveTrainCommand(DriveTrainSubsystem subsystem) {
    

    
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.drive.stop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //valores de Y e X dos controles
    double Y_axis = RobotContainer.m_driverController.getRawAxis
    (Constants.DriveTrainConstants.yAxisDriver);

    double X_axis = RobotContainer.m_driverController.getRawAxis
    (Constants.DriveTrainConstants.xAxisDriver);

  
    RobotContainer.drive.arcadeDrive(Y_axis, X_axis, 1);
  }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
