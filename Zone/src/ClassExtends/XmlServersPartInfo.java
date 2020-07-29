package ClassExtends;

public class XmlServersPartInfo extends BaseServersPartInfo{
	private String head = "\t" + "<servers>" + "\n";
	private String end = "\t" + "</servers>" + "\n";
	private String xml = "";
	public XmlServersPartInfo(BaseFormatServerLine[] serverLines, int count) {
		super(serverLines, count);
	}
	
	@Override
	public String getServerPartInfo(){
		for(int i = 0; i < serverCount; i++){
			if (myServerLines[i].getIp() == null) {
				break;
			}
			if(i == serverCount - 1)
				myServerLines[i].setEndType(true);
			xml = xml + myServerLines[i].getServerInfo();
		}
		return head + xml + end;
	}
}
