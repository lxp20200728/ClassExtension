package ClassExtends;

public class JsonServerLine extends BaseFormatServerLine {
	private static String head = "\t"+ "\t" + "{";
	private static String end = "}," + "\n";

	public JsonServerLine(String ip, int prot){
		super(ip, prot);
	}
	
	public void setEndType(Boolean isLast){
		if(isLast)
			end = "}" + "\n";
	}
	
	@Override
	public String getServerInfo(){
		return head + c + "ip" + c + ":" + c + ip + c + "," + c + "port" + c + ":" + c + port + c + end;
	}
}
