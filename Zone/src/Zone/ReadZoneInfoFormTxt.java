package Zone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import ClassExtends.ZoneInfoToBaseFormat;

public class ReadZoneInfoFormTxt {
	private static String curPath = System.getProperty("user.dir") + "\\src\\Zone\\";
	public static void main(String[] args){
		ZoneInfoClass[] myZoneInfo = new ZoneInfoClass[8];
		File directory = new File("");//�趨Ϊ��ǰ�ļ���
		String path = directory.getAbsolutePath();
		//System.out.print(path);
		String filePath = curPath + "zoneInfo.txt";
		System.out.println(filePath);
		int count = 0;
		readZoneInfoFromTxt(myZoneInfo, filePath, count);
// 		changeIpToDomainName(myZoneInfo);
		int type = getUserCommand();
		ZoneInfoToBaseFormat mBaseFormat = new ZoneInfoToBaseFormat(myZoneInfo);//new һ��������ʽ����
		mBaseFormat.outPutToXml(type);//�������������ʽ
//		ZoneInfoToXml myZoneInfoToXml = new ZoneInfoToXml(myZoneInfo); //Zone����xml��ʽ�Ե���
//		myZoneInfoToXml.outPutToXml();
	}
	public static void readZoneInfoFromTxt(ZoneInfoClass[] myZoneInfo, String filePath, int count){
		try {
			String encoding="GBK";
	        File file=new File(filePath);
	        if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ����
	        	InputStreamReader read = new InputStreamReader(
				new FileInputStream(file),encoding);//���ǵ������ʽ
	        	BufferedReader bufferedReader = new BufferedReader(read);
	        	String lineTxt = null;
	        	while((lineTxt = bufferedReader.readLine()) != null){
	        		String[] zoneInfoArray = new String[5];
	        		zoneInfoArray = lineTxt.split("\t");
	        		myZoneInfo[count] = new ZoneInfoClass(zoneInfoArray[0], zoneInfoArray[1], Integer.parseInt(zoneInfoArray[2]), Integer.parseInt(zoneInfoArray[3]), Integer.parseInt(zoneInfoArray[4]));
	        		count ++;
	        	}
	        	read.close();
			}else{
				System.out.println("�Ҳ���ָ�����ļ�");
			}
		} catch (Exception e) {
			System.out.println("��ȡ�ļ����ݳ���");
			e.printStackTrace();
		}
	}
	
	private static void changeIpToDomainName(ZoneInfoClass[] myZoneInfo){//������������ip
		String domainFilePath = curPath + "domainName.txt";
		ReadDomainNameFromTxt mDomainNameFromTxt = new ReadDomainNameFromTxt(domainFilePath);
		for(int i = 0 ; i < myZoneInfo.length; i++){
			myZoneInfo[i].setZoneIP(mDomainNameFromTxt.changeIpToDomainName(myZoneInfo[i].getZoneIP()));
		}
		
	}
	private static int getUserCommand(){ //�����û�����ѡ���Ӧģʽ
		int t = -1;
		Scanner scanner = new Scanner(System.in);
		while(t == -1){
			System.out.println("��ѡ�������ʽ��0��1����");
			System.out.println("0��xml��ʽ              1��Json��ʽ");
			String str = scanner.nextLine();
			if(str.length() == 1 && (str.charAt(0) == '0' || str.charAt(0) == '1')){
				t = Integer.valueOf(str);
			}
		}
		return t;
	}
}
