package org.usfirst.frc.team3268.robot.commands.auton;

import org.usfirst.frc.team3268.robot.commands.firing.ReleaseBallCommand;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class FullAutoHighGoalCommand extends CommandGroup {

	public FullAutoHighGoalCommand() {
		addParallel(new AutonSpinUpWheelsCommand());
		addSequential(new AutoHighGoalAlignSpam());
		addSequential(new ReleaseBallCommand());
		addSequential(new Command() {

			@Override
			protected void initialize() {
				AutonSpinUpWheelsCommand.done = true;
				setTimeout(0.5);
			}

			@Override
			protected void execute() {
			}

			@Override
			protected boolean isFinished() {
				return isTimedOut();
			}

			@Override
			protected void end() {
			}

			@Override
			protected void interrupted() {
			}
		});

		addSequential(new Command() {

			@Override
			protected void initialize() {
				AutonSpinUpWheelsCommand.done = false;
			}

			@Override
			protected void execute() {
			}

			@Override
			protected boolean isFinished() {
				return true;
			}

			@Override
			protected void end() {
			}

			@Override
			protected void interrupted() {
			}
		});
	}
}
