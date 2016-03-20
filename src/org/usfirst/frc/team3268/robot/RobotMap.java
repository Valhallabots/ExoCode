package org.usfirst.frc.team3268.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class RobotMap {
//    public static final CANTalon leftDrive = new CANTalon(1), rightDrive = new CANTalon(2);
//    public static final Talon leftDrive2 = new Talon(5), rightDrive2 = new Talon(2);
    
    public static final Talon leftDrive = new Talon(3), leftDrive2 = new Talon(1), rightDrive = new Talon(2), rightDrive2 = new Talon(0);
    
    public static final DoubleSolenoid solenoid = new DoubleSolenoid(1, 0);
    
    public static final Talon intake1 = new Talon(6), intake2 = new Talon(7);
    public static final Talon firingRight = new Talon(5), firingLeft = new Talon(4);
    public static final Servo firingServo = new Servo(8);
    
    public static final Gyro gyro = new AnalogGyro(1);
}
