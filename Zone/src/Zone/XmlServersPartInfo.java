package Zone;

public class XmlServersPartInfo {
	private String head = "\t" + "<servers>" + "\n";
	private String end = "\t" + "</servers>" + "\n";
	private ServerLine[] myServerLines = new ServerLine[100];
	private int serverCount = 0;
	private String xml = "";
	public XmlServersPartInfo(){}
	public XmlServersPartInfo(ServerLine[] serverLines, int count) {
		this.myServerLines = serverLines;
		this.serverCount = count;
	}
	public String getXmlZoneInfo(){
		for(int i = 0; i < serverCount; i++){
			if (myServerLines[i].getIp() == null) {
				break;
			}
			xml = xml + myServerLines[i].getServerLine();
		}
		return head + xml + end;
	}
}
