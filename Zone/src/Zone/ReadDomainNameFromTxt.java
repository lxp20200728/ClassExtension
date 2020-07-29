package Zone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadDomainNameFromTxt {
	private String[] myIPs = new String[10];
	private String[] myDomainNames = new String[10];
	private int myCounter = 0;
	
	public ReadDomainNameFromTxt(){}
	public ReadDomainNameFromTxt(String filePath){
		getDomainNameFromTxt(filePath);
	}
	
	private void getDomainNameFromTxt(String filePath){
		try {
			String encoding="GBK";
	        File file=new File(filePath);
	        if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ����
	        	InputStreamReader read = new InputStreamReader(
				new FileInputStream(file),encoding);//���ǵ������ʽ
	        	BufferedReader bufferedReader = new BufferedReader(read);
	        	String lineTxt = null;
	        	while((lineTxt = bufferedReader.readLine()) != null){
	        		String[] DomainInfoArray = new String[3];
	        		DomainInfoArray = lineTxt.split("\t");
	        		if (DomainInfoArray[2].equals("1")) {
						this.myIPs[myCounter] = DomainInfoArray[0];
						this.myDomainNames[myCounter] = DomainInfoArray[1];
						myCounter ++;
					}
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
	
	public String changeIpToDomainName(String ip){
		for(int i = 0 ; i < myCounter; i ++){
			if(this.myIPs[i].equals(ip))
				return this.myDomainNames[i];
		}
		return ip;
	}
	/**
	 * @return the myIPs
	 */
	public String[] getMyIPs() {
		return myIPs;
	}
	/**
	 * @param myIPs the myIPs to set
	 */
	public void setMyIPs(String[] myIPs) {
		this.myIPs = myIPs;
	}
	/**
	 * @return the myDomainNames
	 */
	public String[] getMyDomainNames() {
		return myDomainNames;
	}
	/**
	 * @param myDomainNames the myDomainNames to set
	 */
	public void setMyDomainNames(String[] myDomainNames) {
		this.myDomainNames = myDomainNames;
	}
}
