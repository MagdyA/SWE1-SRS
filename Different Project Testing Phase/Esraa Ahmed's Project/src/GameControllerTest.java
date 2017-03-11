
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GameControllerTest {

	GameController gameController = new GameController();
	

	@BeforeTest
	public void prepareAddGameRequiredData() throws FileNotFoundException {
		gameController.in = new Scanner(new File("AddGame Input.txt"));
		Category math = new Category(); 
		math.CatName = "Math";
		Category science = new Category();
		science.CatName = "Science";
		gameController.Categories.add(math);
		gameController.Categories.add(science);		
	}

	@Test(invocationCount = 4)
	public void AddGame() {
		gameController.AddGame();
		for ( int i = 0; i < gameController.Categories.size(); i++ ) {
			System.out.println("Category: " + gameController.Categories.get(i).CatName);
			for ( int j = 0 ; j < gameController.Categories.get(i).ListOfGames.size() ; j++) {
				System.out.println("Game :" + gameController.Categories.get(i).ListOfGames.get(j).Name);
			}
		}
	}

	@Test
	public void PlayGame() {
		throw new RuntimeException("Test not implemented");
	}
}
