package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.BuildConfig.BUILD_NUMBER;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@TeleOp(name = "Explore 4H")
public class Explore4H extends OpMode {
  private DcMotor frontLeft;
  private DcMotor frontRight;
  private DcMotor rearLeft;
  private DcMotor rearRight;

  @Override
  public void init() {
    frontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");
    frontRight = hardwareMap.get(DcMotor.class, "FrontRight");
    rearLeft = hardwareMap.get(DcMotor.class, "RearLeft");
    rearRight = hardwareMap.get(DcMotor.class, "RearRight");

    frontRight.setDirection(DcMotor.Direction.REVERSE);
    rearRight.setDirection(DcMotor.Direction.REVERSE);
    telemetry.addData("Build Number", BUILD_NUMBER);
  }

  @Override
  public void loop() {
    double drive = -gamepad1.left_stick_y;
    double strafe = gamepad1.left_stick_x;
    double rotate = gamepad1.right_stick_x;

    double frontLeftPower = drive + strafe + rotate;
    double frontRightPower = drive - strafe - rotate;
    double rearLeftPower = drive - strafe + rotate;
    double rearRightPower = drive + strafe - rotate;

    frontLeft.setPower(frontLeftPower);
    frontRight.setPower(frontRightPower);
    rearLeft.setPower(rearLeftPower);
    rearRight.setPower(rearRightPower);
  }
}
