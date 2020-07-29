package ClassExtends;

public class XmlServerLine extends BaseFormatServerLine {
	private static String head = "\t"+ "\t" + "<server>";
	private static String end = "</server>" + "\n";
	
	public XmlServerLine(String ip, int prot){
		super(ip, prot);
	}
	
	@Override
	public void setEndType(Boolean isLast) {		
	}
	@Override
	public String getServerInfo(){
		return head + ip + "/" + port + end;
	}
}
