package mementoPatternTest;

import java.util.ArrayList;
import java.util.List;

public class Archive {
	private List<ArchiveRecord> records = 
			new ArrayList<ArchiveRecord>();
	
	public void add(ArchiveRecord record) {
		records.add(record);
	}
	
	public ArchiveRecord get(int index) {
		return records.get(index);
	}
}
