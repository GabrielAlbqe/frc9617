package frc.robot.commands.Shooter;


import frc.robot.RobotContainer;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class ShooterPreCommand extends Command {

    double speed;
    boolean trueoufalse;

    public ShooterPreCommand(ShooterSubsystem shootersubsystem, double speed, boolean trueoufalse){
     
      this.speed = speed;
      this.trueoufalse = trueoufalse;
  
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(shootersubsystem);
    }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.ShooterSubSystem.prelancar(speed, trueoufalse);
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
