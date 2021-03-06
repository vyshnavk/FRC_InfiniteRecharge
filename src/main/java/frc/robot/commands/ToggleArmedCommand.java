/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.StorageSubsystem;

public class ToggleArmedCommand extends CommandBase {
  private final StorageSubsystem m_storageSubsystem;
  private boolean currentState;
  private boolean newState;

  /**
   * Creates a new ToggleArmedCommand.
   */
  public ToggleArmedCommand(StorageSubsystem subsystem) {
    m_storageSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    currentState = m_storageSubsystem.getArmed();
    if (currentState == true){
      newState = false;
    } else if (currentState == false) {
      newState = true;
    }
    m_storageSubsystem.setArmed(newState);
    System.out.println("Current State is: " + currentState);
    System.out.println("New State is: " + newState);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
