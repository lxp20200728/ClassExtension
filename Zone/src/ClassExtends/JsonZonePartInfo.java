package ClassExtends;

public class JsonZonePartInfo extends BaseZonesPartInfo{
	private char c = 34;
	private String head = "\t" + c + "zones" + c +":"+ "\n" + "\t" + "[" + "\n";
	private String end = "\t" + "]" + "\n";
	private String xml = "";
	public JsonZonePartInfo(BaseFormatZoneLine[] zoneLines, int zoneCount){
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
