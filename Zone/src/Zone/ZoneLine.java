package Zone;

public class ZoneLine {
	private String head = "\t"+ "\t" + "<zone ";
	private String end = "/>" + "\n";
	private char c = 34;
	private String name = null;
	private String index = null;
	private String capacity = null;
	public ZoneLine(){}
	public ZoneLine(String name, int index, int capacity){
		this.name = c + name + c;
		this.index = c + String.valueOf(index) + c;
		this.capacity = c + String.valueOf(capacity) + c;
	}
	
	public String getZoneLine(){
		return (head + "name=" +this.name +" serverIndex=" + this.index + " capacity=" +this.capacity + end);
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the index
	 */
	public String getIndex() {
		return index;
	}
	/**
	 * @param index the index to set
	 */
	public void setIndex(String index) {
		this.index = index;
	}
	/**
	 * @return the capacity
	 */
	public String getCapacity() {
		return capacity;
	}
	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	
}
