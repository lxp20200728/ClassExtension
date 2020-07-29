package Zone;

public class ZoneInfoToXml {
	private ZoneInfoClass[] myZoneInfos = new ZoneInfoClass[8];
	private int serverCount = 0;
	private int zoneCount = 0;
	private ZoneLine[] myZoneLines= new ZoneLine[100];
	private ServerLine[] myServerLines = new ServerLine[100];
	public ZoneInfoToXml (ZoneInfoClass[] zoneInfos) {
		this.myZoneInfos = zoneInfos;
	}
	
	public void outPutToXml() {
		initServerLine();
		initZoneLine();
		XmlInfoClass myXmlInfoClass = new XmlInfoClass(myServerLines, serverCount, myZoneLines, zoneCount);
		System.out.print(myXmlInfoClass.getXmlInfo());
	}
	public void initServerLine(){
		for(int i = 0 ; i < myZoneInfos.length; i ++){
			ServerLine myServerLine = new ServerLine(myZoneInfos[i].getZoneIP(), myZoneInfos[i].getZonePort());
			if (!findServerLineExist(myServerLine)) {
				myServerLines[serverCount] = myServerLine;
				serverCount ++;
			}
		}
	}
	
	private Boolean findServerLineExist(ServerLine myServerLine) {
		for(int i = 0; i < serverCount; i++){
			if(myServerLines[i].getIp() == null)
				return false;
			if(myServerLine.getIp().equals(myServerLines[i].getIp()) && myServerLine.getPort() == myServerLines[i].getPort())
				return true;
		}
		return false;
	}
	
	public void initZoneLine(){
		for(int i = 0; i < myZoneInfos.length; i ++){
			if (myZoneInfos[i].getZoneName().charAt(0) == '$') {
				continue;
			}
			ServerLine curServerLine = new ServerLine(myZoneInfos[i].getZoneIP(), myZoneInfos[i].getZonePort());
			int capacity = 100 * myZoneInfos[i].getZoneCurPeople() / myZoneInfos[i].getZoneMaxPeople();
			if(capacity >= 0 && capacity < 10){
				capacity = 1;
			}else if (capacity < 30) {
				capacity = 2;
			}else if (capacity < 40) {
				capacity = 3;
			}else if (capacity <50) {
				capacity = 4;
			}else if (capacity < 70) {
				capacity = 5;
			}else if (capacity < 80) {
				capacity = 6;
			}else{
				capacity = 7;
			}
			myZoneLines[zoneCount] = new ZoneLine(myZoneInfos[i].getZoneName(), findServerLineIndex(curServerLine), capacity);
			zoneCount ++;
		}
	}
	
	public int findServerLineIndex(ServerLine curServerLine) {
		for(int i = 0; i < serverCount; i++){
			if(myServerLines[i].getIp() == null)
				return serverCount;
			if(curServerLine.getIp().equals(myServerLines[i].getIp()) && curServerLine.getPort() == myServerLines[i].getPort())
				return i + 1;
		}	
		return serverCount;
	}
	
}
