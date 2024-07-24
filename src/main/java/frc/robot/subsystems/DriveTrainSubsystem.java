package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveTrainSubsystem extends SubsystemBase{
    //motores
    CANSparkMax frontleftmotorleader = new CANSparkMax (Constants.DriveConstants.m_frontleft, MotorType.kBrushed);
    CANSparkMax rearleftmotorfollower = new CANSparkMax (Constants.DriveConstants.m_rearleft, MotorType.kBrushed);
    
    CANSparkMax frontrightmotorleader = new CANSparkMax (Constants.DriveConstants.m_frontright, MotorType.kBrushed);
    CANSparkMax rearrightmotorfollower = new CANSparkMax (Constants.DriveConstants.m_rearright, MotorType.kBrushed);

    DifferentialDrive drive;


    double speed;    

    public DriveTrainSubsystem(){
        
        frontleftmotorleader.setIdleMode(IdleMode.kBrake);
        frontrightmotorleader.setIdleMode(IdleMode.kBrake);

        rearleftmotorfollower.follow(frontleftmotorleader);
        rearrightmotorfollower.follow(frontrightmotorleader);

        frontleftmotorleader.setInverted(true);

        drive =  new DifferentialDrive(frontleftmotorleader, frontrightmotorleader);

    }

    public void arcadeDrive(double y_axis, double x_axis, double speed) {
    
      drive.arcadeDrive(y_axis * speed, x_axis * speed) ;

      this.speed = speed;
    }

    public void driveFWD(double speed){
        drive.tankDrive(speed, speed);
    }

    public void driveBWD(double speed){
        drive.tankDrive(-speed, -speed);
    }
    
    public void driveLeft(double speed){
        drive.tankDrive(-speed, speed);
    }

    public void driveRight(double speed){
        drive.tankDrive(speed, -speed);
    }

    public void stop(){
        drive.stopMotor();
    }

    @Override

    public void periodic(){
     
     SmartDashboard.putNumber("Valor Speed", speed);

    }




    }
   

