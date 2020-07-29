package ClassExtends;

public class JsonZoneLine extends BaseFormatZoneLine{
	private String head = "\t"+ "\t" + "{";
	private String end = "}," + "\n";
	public JsonZoneLine(String name, int index, int capacity){
		super(name, index, capacity);
	}
	
	@Override
	public void setEndType(Boolean isLast){
		if(isLast)
			end = "}" + "\n";
	}
	@Override
	public String getZoneInfo(){
		return (head + c +" name" + c+ ":" + name  + "," + c + " serverIndex" + c +":" + index +"," + c + "capacity" + c + ":" + capacity + end);
	}

}
