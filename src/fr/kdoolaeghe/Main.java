package fr.kdoolaeghe;

import fr.kdoolaeghe.input.NumberInput;

public class Main {

    public static String calculate(double angleA, double pointAx, double pointAz, double angleB, double pointBx,
                                   double pointBz) {
        double deg2rad = Math.PI / 180;

        if (angleA >= 90) angleA = 180 - angleA + 90;
        else angleA = -1 * (angleA + 90);

        if (angleB >= 90) angleB = 180 - angleB + 90;
        else angleB = -1 * (angleB + 90);

        double slopeA = -1 * Math.tan(angleA * deg2rad);
        double slopeB = -1 * Math.tan(angleB * deg2rad);

        // (-Z) = MX + B solve for B, then set equations equal to each other

        // Equation of Line for point A
        // -1*pointAz = slopeA*pointAx + B
        // <=> B = -1*pointAz - slopeA*pointAx
        double interceptA = pointAz - slopeA * pointAx;
        double interceptB = pointBz - slopeB * pointBx;

        // Solve for X
        // slopeA*X + interceptA = slopeB*X + interceptB
        // <=> (slopeA-slopeB)*X = interceptB - interceptA
        // <=> X = (interceptB - interceptA)/(slopeA-slopeB)
        double X = (interceptB - interceptA) / (slopeA - slopeB);
        double Z = slopeA * X + interceptA;

        return Math.round(X) + "," + Math.round(Z);
    }

    public static void main(String[] args) {
        double angleA, pointAx, pointAz;
        double angleB, pointBx, pointBz;

        NumberInput cli = new NumberInput();

        angleA = cli.promptNumber("Enter angleA value: ");
        pointAx = cli.promptNumber("Enter pointAx value: ");
        pointAz = cli.promptNumber("Enter pointAz value: ");
        angleB = cli.promptNumber("Enter angleB value: ");
        pointBx = cli.promptNumber("Enter pointBx value: ");
        pointBz = cli.promptNumber("Enter pointBz value: ");

        String result = calculate(angleA, pointAx, pointAz, angleB, pointBx, pointBz);
        System.out.println("Result: " + result);
    }
}
