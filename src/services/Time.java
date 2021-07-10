package services;

public class Time {
	private static double timeStarted = System.nanoTime();
	
	
	public static double getTime() { //Diferenša entre o tempo inicial e final (do loop run) em segundos
		return (System.nanoTime() - timeStarted) * 1E-9;
									//1E-9 = 1 X 10^-9 (0.000000001)
		
	}
}
