
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GameControllerTest {

	GameController gameController = new GameController();

	@BeforeTest
	public void prepareAddGameInputSouce() throws FileNotFoundException {
		gameController.in = new Scanner(new File("AddGame Input.txt"));
	}

	@Test(invocationCount = 4)
	public void AddGame() {
		gameController.AddGame();
	}

	@Test
	public void PlayGame() {
		throw new RuntimeException("Test not implemented");
	}
}
