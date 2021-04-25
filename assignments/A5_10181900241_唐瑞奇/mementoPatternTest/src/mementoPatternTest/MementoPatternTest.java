package mementoPatternTest;

//备忘录模式:游戏存档与读取

public class MementoPatternTest {

	public static void main(String[] args) {
		Archive archive = new Archive();
		RuntimeGame runtimeGame = new RuntimeGame(archive);
		
		runtimeGame.setState("Chapter 1");
		runtimeGame.save();
		
		runtimeGame.setState("Chapter 3");
		runtimeGame.save();
		
		runtimeGame.load(archive.get(0));
	}

}
