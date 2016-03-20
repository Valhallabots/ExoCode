package org.usfirst.frc.team3268.robot.commands.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SimpleTraverseGroup extends CommandGroup {

    public SimpleTraverseGroup() {
        addSequential(new DriveToDefenseCommand());
        addSequential(new DriveToDefenseCommand());
        //addSequential(new WaitCommand(1.0));
//        addSequential(new SimpleTraverseDefenseCommand());
    }
}
