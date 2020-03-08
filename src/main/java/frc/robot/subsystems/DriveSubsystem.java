/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

  // To do: Declare motor controllers (CANSparkMax)
  private CANSparkMax m_left1 = null;
  private CANSparkMax m_left2 = null;
  private CANSparkMax m_right1 = null;
  private CANSparkMax m_right2 = null;
  private DifferentialDrive m_drive;
  private boolean driveExist;
  


  
  /**
   * Creates a new DriveSubsystem.
   */
  public DriveSubsystem() {
    //Add motors to groups
    //Create ArcadeDrive
    m_left1 = new CANSparkMax(Constants.Drive.CANID_LEFT1, MotorType.kBrushless);
    m_left2 = new CANSparkMax(Constants.Drive.CANID_LEFT2, MotorType.kBrushless);
    m_right1 = new CANSparkMax(Constants.Drive.CANID_RIGHT1, MotorType.kBrushless);
    m_right2 = new CANSparkMax(Constants.Drive.CANID_RIGHT2, MotorType.kBrushless);
    
    if (m_left1 != null || m_left2 != null || m_right1 != null || m_right2 != null){
      //Declare motor groups 
      SpeedControllerGroup left = new SpeedControllerGroup(m_left1, m_left2);
      SpeedControllerGroup right = new SpeedControllerGroup(m_right1, m_right2);
      //Declare ArcadeDrive 
      m_drive = new DifferentialDrive(left, right);
    }
  }

  @Override
  public void periodic() {
    
  }

  public void setDrivePower(double power, double turn){
    //To do: Control motors
    if (m_left1 != null || m_left2 != null || m_right1 != null || m_right2 != null){
      m_drive.arcadeDrive(power, turn);
    }
  }
}

