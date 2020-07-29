package Zone;

public class XmlInfoClass {
	private String head = "<root>" + "\n";
	private String end = "</root>" + "\n";
	private XmlServersPartInfo mXmlServersPartInfo = null;
	private XmlZonesPartInfo mXmlZonePartInfo = null;
	public XmlInfoClass(){}
	public XmlInfoClass(ServerLine[] myServerLines, int serverCount, ZoneLine[] myZoneLines, int zoneCount){
		this.setmXmlServersPartInfo(new XmlServersPartInfo(myServerLines, serverCount));
		this.setmXmlZonePartInfo(new XmlZonesPartInfo(myZoneLines, zoneCount));
	}
	
	public String getXmlInfo() {
		return head + this.mXmlServersPartInfo.getXmlZoneInfo() + this.mXmlZonePartInfo.getXmlZoneInfo() + end;
	}
	
	/**
	 * @return the mXmlServersPartInfo
	 */
	public XmlServersPartInfo getmXmlServersPartInfo() {
		return mXmlServersPartInfo;
	}
	/**
	 * @param mXmlServersPartInfo the mXmlServersPartInfo to set
	 */
	public void setmXmlServersPartInfo(XmlServersPartInfo mXmlServersPartInfo) {
		this.mXmlServersPartInfo = mXmlServersPartInfo;
	}
	/**
	 * @return the mXmlZonePartInfo
	 */
	public XmlZonesPartInfo getmXmlZonePartInfo() {
		return mXmlZonePartInfo;
	}
	/**
	 * @param mXmlZonePartInfo the mXmlZonePartInfo to set
	 */
	public void setmXmlZonePartInfo(XmlZonesPartInfo mXmlZonePartInfo) {
		this.mXmlZonePartInfo = mXmlZonePartInfo;
	}
}
