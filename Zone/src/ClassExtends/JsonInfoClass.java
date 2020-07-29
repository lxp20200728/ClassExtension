package ClassExtends;

public class JsonInfoClass extends BaseFormatClass {
	private String head = "{" + "\n";
	private String end = "}" + "\n";
	public JsonInfoClass(BaseFormatServerLine[] myServerLines, int serverCount, BaseFormatZoneLine[] myZoneLines, int zoneCount){
		super(myServerLines, serverCount, myZoneLines, zoneCount);
	}
	
	@Override
	public String getPrinterInfo() {
		return head + mBaseServersPartInfo.getServerPartInfo() + mBaseZonesPartInfo.getZonePartInfo() + end;
	}
	
}
