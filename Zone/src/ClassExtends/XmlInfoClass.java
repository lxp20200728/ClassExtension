package ClassExtends;

public class XmlInfoClass extends BaseFormatClass {
	private String head = "<root>" + "\n";
	private String end = "</root>" + "\n";
	public XmlInfoClass(BaseFormatServerLine[] myServerLines, int serverCount, BaseFormatZoneLine[] myZoneLines, int zoneCount){
		super(myServerLines, serverCount, myZoneLines, zoneCount);
	}
	
	@Override
	public String getPrinterInfo() {
		return head + mBaseServersPartInfo.getServerPartInfo() + mBaseZonesPartInfo.getZonePartInfo() + end;
	}
	
}
