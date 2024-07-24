// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;


import edu.wpi.first.wpilibj.DigitalInput;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;


public class ShooterSubsystem extends SubsystemBase {
  CANSparkMax MotorDeCima1 = new CANSparkMax(Constants.ShooterConstants.Motor1cima, MotorType.kBrushed);
  CANSparkMax MotorDeCima2 = new CANSparkMax(Constants.ShooterConstants.Motor2cima, MotorType.kBrushed);
  
  CANSparkMax MotorDeBaixo3 = new CANSparkMax(Constants.ShooterConstants.Motor3baixo, MotorType.kBrushed);
  CANSparkMax MotorDeBaixo4 = new CANSparkMax(Constants.ShooterConstants.Motor4baixo, MotorType.kBrushed);

  DigitalInput FimDeCurso = new DigitalInput(0);


  public ShooterSubsystem() {

    MotorDeCima1.setIdleMode(IdleMode.kCoast);
    MotorDeCima2.setIdleMode(IdleMode.kCoast);

    MotorDeBaixo3.setIdleMode(IdleMode.kCoast);
    MotorDeBaixo4.setIdleMode(IdleMode.kCoast);

  
  
  }


  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  public void prelancar(double speed, boolean trueoufalse){
    if(trueoufalse = true){
      MotorDeCima1.setIdleMode(IdleMode.kCoast);
      MotorDeCima2.setIdleMode(IdleMode.kCoast);
    }else{
      MotorDeCima1.setIdleMode(IdleMode.kBrake);
      MotorDeCima2.setIdleMode(IdleMode.kBrake);
    }
   
   MotorDeCima2.set(speed);
   MotorDeBaixo4.set(speed);

  }

  public void lancar(double speed){
    MotorDeCima1.set(-speed);
    MotorDeCima2.set(speed); 

    MotorDeBaixo3.set(speed);
    MotorDeBaixo4.set(-speed);
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Nota",FimDeCurso.get());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
