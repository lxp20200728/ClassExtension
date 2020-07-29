package ClassExtends;

public class JsonServersPartInfo extends BaseServersPartInfo{
	private char c = 34;
	private String head = "\t" + c + "servers" + c +":"+ "\n" + "\t" + "[" + "\n";
	private String end = "\t" + "]," + "\n";
	private String xml = "";
	public JsonServersPartInfo(BaseFormatServerLine[] serverLines, int count) {
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
