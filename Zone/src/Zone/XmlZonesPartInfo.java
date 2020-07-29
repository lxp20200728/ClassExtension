package Zone;

public class XmlZonesPartInfo {
	private String head = "\t" + "<zones>" + "\n";
	private String end = "\t" + "</zones>" + "\n";
	private ZoneLine[] myZoneLines = new ZoneLine[100];
	private int zoneCount = 0;
	private String xml = "";
	public XmlZonesPartInfo(){}
	public XmlZonesPartInfo(ZoneLine[] zoneLines, int zoneCount){
		this.myZoneLines = zoneLines;
		this.zoneCount = zoneCount;
	}
	public String getXmlZoneInfo(){
		for(int i = 0; i < zoneCount; i++){
			if (myZoneLines[i].getName() == null) {
				break;
			}
			xml = xml + myZoneLines[i].getZoneLine();
		}
		return head + xml + end;
	}
}
