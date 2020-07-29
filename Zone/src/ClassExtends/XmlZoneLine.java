package ClassExtends;

public class XmlZoneLine extends BaseFormatZoneLine{
	private String head = "\t"+ "\t" + "<zone ";
	private String end = "/>" + "\n";
	public XmlZoneLine(String name, int index, int capacity){
		super(name, index, capacity);
	}
	
	@Override
	public String getZoneInfo(){
		return (head + "name=" + name +" serverIndex=" + index + " capacity=" + capacity + end);
	}
	@Override
	public void setEndType(Boolean isLast) {		
	}
}
