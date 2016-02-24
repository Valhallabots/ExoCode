package org.usfirst.frc.team3268.robot;

import org.usfirst.frc.team3268.robot.commands.drive.ReverseDrive;
import org.usfirst.frc.team3268.robot.commands.pickup.PneumaticDownCommand;
import org.usfirst.frc.team3268.robot.commands.pickup.PneumaticUpCommand;
import org.usfirst.frc.team3268.robot.commands.pickup.SpitCommand;
import org.usfirst.frc.team3268.robot.commands.pickup.SuckCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public final Joystick lStick = new Joystick(0), rStick = new Joystick(1);
	
    private final JoystickButton toggleDriveButton = new JoystickButton(rStick, 2);
    private final JoystickButton suckButton = new JoystickButton(rStick, 5), spitButton = new JoystickButton(rStick, 3);
    private final JoystickButton lifterUp = new JoystickButton(rStick, 6), lifterDown = new JoystickButton(rStick, 4);
    
    public OI() {
    	toggleDriveButton.toggleWhenPressed(new ReverseDrive());
    	
    	suckButton.whileHeld(new SuckCommand());
    	spitButton.whileHeld(new SpitCommand());
    	lifterUp.whenPressed(new PneumaticUpCommand());
    	lifterDown.whenPressed(new PneumaticDownCommand());
    }
}

