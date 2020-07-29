package ClassExtends;

public class XmlZonesPartInfo extends BaseZonesPartInfo{
	private String head = "\t" + "<zones>" + "\n";
	private String end = "\t" + "</zones>" + "\n";
	private String xml = "";
	public XmlZonesPartInfo(BaseFormatZoneLine[] zoneLines, int zoneCount){
		super(zoneLines ,zoneCount);
	}
	@Override
	public String getZonePartInfo(){
		for(int i = 0; i < zoneCount; i++){
			if (myZoneLines[i].getName() == null) {
				break;
			}
			if(i == zoneCount - 1)
				myZoneLines[i].setEndType(true);
			xml = xml + myZoneLines[i].getZoneInfo();
		}
		return head + xml + end;
	}
}
