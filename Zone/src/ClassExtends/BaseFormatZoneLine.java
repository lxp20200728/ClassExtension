package ClassExtends;

public abstract class BaseFormatZoneLine {
	protected char c = 34;
	protected String name = null;
	protected String index = null;
	protected String capacity = null;
	public BaseFormatZoneLine(String name, int index, int capacity){
		this.name = c + name + c;
		this.index = c + String.valueOf(index) + c;
		this.capacity = c + String.valueOf(capacity) + c;;
	}
	public abstract String getZoneInfo();
	public abstract void setEndType(Boolean isLast);
	public String getName(){
		return this.name;
	}
}
