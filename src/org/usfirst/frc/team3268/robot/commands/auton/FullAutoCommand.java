package org.usfirst.frc.team3268.robot.commands.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class FullAutoCommand extends CommandGroup {
    
    public FullAutoCommand() {
        addSequential(new DriveToDefenseCommand(true));
        // TODO: Add rotating as a separate command here
        addSequential(new FullAutoHighGoalCommand());
    }
}
