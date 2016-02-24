package org.usfirst.frc.team3268.robot.subsystems;

import org.usfirst.frc.team3268.robot.RobotMap;
import org.usfirst.frc.team3268.robot.commands.drive.StandardDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSystem extends Subsystem {
    
    public final RobotDrive driveHelper = new RobotDrive(RobotMap.leftDrive, RobotMap.rightDrive);
	
	public void initDefaultCommand() {
    	setDefaultCommand(new StandardDrive());
    }
}

