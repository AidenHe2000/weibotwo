package mementoPatternTest;

public class RuntimeGame {
	private String state;
	private Archive archive;
	
	public RuntimeGame(Archive archive) {
		this.archive = archive;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getState() {
		return state;
	}
	
	public void save() {
		ArchiveRecord record = new ArchiveRecord(state);
		this.archive.add(record);
		System.out.println("Saved point : " + record.getState());
	}
	
	public void load(ArchiveRecord record) {
		state = record.getState();
		System.out.println("Load : " + record.getState());
	}
}
