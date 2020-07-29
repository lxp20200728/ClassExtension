package ClassExtends;

public abstract class BaseFormatClass {//基础格式类    内部根据line格式定义part格式
	protected BaseServersPartInfo mBaseServersPartInfo = null;
	protected BaseZonesPartInfo mBaseZonesPartInfo = null;
	public BaseFormatClass(BaseFormatServerLine[] myServerLines, int serverCount, BaseFormatZoneLine[] myZoneLines, int zoneCount) {
		//System.out.println(myServerLines[0].getClass().getName()+" && " + myZoneLines[0].getClass().getName());
		if (myServerLines[0].getClass().getName().contains("XmlServerLine")) {
			this.mBaseServersPartInfo  = new XmlServersPartInfo(myServerLines, serverCount);
		}else{
			this.mBaseServersPartInfo  = new JsonServersPartInfo(myServerLines, serverCount);
		}
		if (myZoneLines[0].getClass().getName().contains("XmlZoneLine")) {
			this.mBaseZonesPartInfo  = new XmlZonesPartInfo(myZoneLines, zoneCount);
		}else{
			this.mBaseZonesPartInfo  = new JsonZonePartInfo(myZoneLines, zoneCount);
		}
	}
	public abstract String getPrinterInfo();
}
