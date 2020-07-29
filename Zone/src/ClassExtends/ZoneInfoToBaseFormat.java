package ClassExtends;

import Zone.ZoneInfoClass;
public class ZoneInfoToBaseFormat {//��Ϣ������ ͬʱȷ������line��������ʽ��
	private ZoneInfoClass[] myZoneInfos = new ZoneInfoClass[8];
	private int serverCount = 0;
	private int zoneCount = 0;
	private BaseFormatZoneLine[] myZoneLines= new BaseFormatZoneLine[100];
	private BaseFormatServerLine[] myServerLines = new BaseFormatServerLine[100];
	public ZoneInfoToBaseFormat (ZoneInfoClass[] zoneInfos) {
		this.myZoneInfos = zoneInfos;
	}
	
	public void outPutToXml(int type) {//���ö�Ӧ����и�ʽ���
		initServerLine(type);//���ݲ����������serverline��ʽ
		initZoneLine(type);//���ݲ����������zoneline��ʽ
		if (type == 0) {//���ݲ�������������ʽ�������ڲ����ݻ�����line��ʽ����part���ֵĸ�ʽ
			BaseFormatClass myXmlInfoClass = new XmlInfoClass(myServerLines, serverCount, myZoneLines, zoneCount);
			System.out.print(myXmlInfoClass.getPrinterInfo());
		}else{
			BaseFormatClass myXmlInfoClass = new JsonInfoClass(myServerLines, serverCount, myZoneLines, zoneCount);
			System.out.print(myXmlInfoClass.getPrinterInfo());
		}
	}
	
	public void initServerLine(int type){
		for(int i = 0 ; i < myZoneInfos.length; i ++){
			if (type == 0) {
				XmlServerLine myServerLine = new XmlServerLine(myZoneInfos[i].getZoneIP(), myZoneInfos[i].getZonePort());
				if (!findServerLineExist(myServerLine)) {
					myServerLines[serverCount] = myServerLine;
					serverCount ++;
				}
			}else{
				JsonServerLine myServerLine = new JsonServerLine(myZoneInfos[i].getZoneIP(), myZoneInfos[i].getZonePort());
				if (!findServerLineExist(myServerLine)) {
					myServerLines[serverCount] = myServerLine;
					serverCount ++;
				}
			}	
		}
	}
	
	private Boolean findServerLineExist(BaseFormatServerLine myServerLine) {
		for(int i = 0; i < serverCount; i++){
			if(myServerLines[i].getIp() == null)
				return false;
			if(myServerLine.getIp().equals(myServerLines[i].getIp()) && myServerLine.getPort() == myServerLines[i].getPort())
				return true;
		}
		return false;
	}
	
	public void initZoneLine(int type){
		for(int i = 0; i < myZoneInfos.length; i ++){
			if (myZoneInfos[i].getZoneName().charAt(0) == '$') {
				continue;
			}
			BaseFormatServerLine curServerLine;
			if (type == 0) {
				curServerLine = new XmlServerLine(myZoneInfos[i].getZoneIP(), myZoneInfos[i].getZonePort());
			}else{
				curServerLine = new JsonServerLine(myZoneInfos[i].getZoneIP(), myZoneInfos[i].getZonePort());
			}
			
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
			if (type == 0) {
				myZoneLines[zoneCount] = new XmlZoneLine(myZoneInfos[i].getZoneName(), findServerLineIndex(curServerLine), capacity);
			}else{
				myZoneLines[zoneCount] = new JsonZoneLine(myZoneInfos[i].getZoneName(), findServerLineIndex(curServerLine), capacity);
			}
			
			zoneCount ++;
		}
	}
	
	public int findServerLineIndex(BaseFormatServerLine curServerLine) {
		for(int i = 0; i < serverCount; i++){
			if(myServerLines[i].getIp() == null)
				return serverCount;
			if(curServerLine.getIp().equals(myServerLines[i].getIp()) && curServerLine.getPort() == myServerLines[i].getPort())
				return i + 1;
		}	
		return serverCount;
	}
	
}
