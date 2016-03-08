package org.usfirst.frc.team3268.robot.commands.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SimpleTraverseGroup extends CommandGroup {
    
    public  SimpleTraverseGroup() {
        addSequential(new DriveToDefenseCommand());
        addSequential(new SimpleTraverseDefenseCommand());
    }
}
