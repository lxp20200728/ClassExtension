package ClassExtends;

public abstract class BaseZonesPartInfo {//�ռ䲿���� �� ���zonelines
	protected BaseFormatZoneLine[] myZoneLines = new BaseFormatZoneLine[100];
	protected int zoneCount = 0;
	public BaseZonesPartInfo(BaseFormatZoneLine[] zoneLines , int count){
		this.myZoneLines = zoneLines;
		this.zoneCount = count;
	}
	public abstract String getZonePartInfo();
}
