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
		File directory = new File("");//设定为当前文件夹
		String path = directory.getAbsolutePath();
		//System.out.print(path);
		String filePath = curPath + "zoneInfo.txt";
		System.out.println(filePath);
		int count = 0;
		readZoneInfoFromTxt(myZoneInfo, filePath, count);
// 		changeIpToDomainName(myZoneInfo);
		int type = getUserCommand();
		ZoneInfoToBaseFormat mBaseFormat = new ZoneInfoToBaseFormat(myZoneInfo);//new 一个基本格式对象
		mBaseFormat.outPutToXml(type);//参数决定输出方式
//		ZoneInfoToXml myZoneInfoToXml = new ZoneInfoToXml(myZoneInfo); //Zone包内xml格式自调用
//		myZoneInfoToXml.outPutToXml();
	}
	public static void readZoneInfoFromTxt(ZoneInfoClass[] myZoneInfo, String filePath, int count){
		try {
			String encoding="GBK";
	        File file=new File(filePath);
	        if(file.isFile() && file.exists()){ //判断文件是否存在
	        	InputStreamReader read = new InputStreamReader(
				new FileInputStream(file),encoding);//考虑到编码格式
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
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
	}
	
	private static void changeIpToDomainName(ZoneInfoClass[] myZoneInfo){//根据域名更换ip
		String domainFilePath = curPath + "domainName.txt";
		ReadDomainNameFromTxt mDomainNameFromTxt = new ReadDomainNameFromTxt(domainFilePath);
		for(int i = 0 ; i < myZoneInfo.length; i++){
			myZoneInfo[i].setZoneIP(mDomainNameFromTxt.changeIpToDomainName(myZoneInfo[i].getZoneIP()));
		}
		
	}
	private static int getUserCommand(){ //请求用户输入选择对应模式
		int t = -1;
		Scanner scanner = new Scanner(System.in);
		while(t == -1){
			System.out.println("请选择输出方式（0或1）：");
			System.out.println("0：xml格式              1：Json格式");
			String str = scanner.nextLine();
			if(str.length() == 1 && (str.charAt(0) == '0' || str.charAt(0) == '1')){
				t = Integer.valueOf(str);
			}
		}
		return t;
	}
}
