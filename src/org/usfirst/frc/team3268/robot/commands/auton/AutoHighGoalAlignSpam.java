package org.usfirst.frc.team3268.robot.commands.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoHighGoalAlignSpam extends CommandGroup {

	public AutoHighGoalAlignSpam() {
		for (int i = 0; i < 4; i++) {
			addSequential(new AutoHighGoalAlignCommand());
			addSequential(new WaitCommand(0.1));
		}
	}
}
