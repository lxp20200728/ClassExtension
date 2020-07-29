package Zone;

public class ZoneInfoClass {
	private String zoneName;
	private String zoneIP;
	private int zonePort;
	private int zoneCurPeople;
	private int zoneMaxPeople;
	//public var zoneIP:String;
	public ZoneInfoClass(String name, String ip, int port, int curPeople, int maxPeople) {
	    this.setZoneName(name);
	    this.setZoneIP(ip);
	    this.setZonePort(port);
	    this.setZoneCurPeople(curPeople);
	    this.setZoneMaxPeople(maxPeople);
	}
	/**
	 * @return the zoneName
	 */
	public String getZoneName() {
		return zoneName;
	}

	/**
	 * @param zoneName the zoneName to set
	 */
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	/**
	 * @return the zoneIP
	 */
	public String getZoneIP() {
		return zoneIP;
	}
	/**
	 * @param zoneIP the zoneIP to set
	 */
	public void setZoneIP(String zoneIP) {
		this.zoneIP = zoneIP;
	}
	/**
	 * @return the zonePort
	 */
	public int getZonePort() {
		return zonePort;
	}
	/**
	 * @param zonePort the zonePort to set
	 */
	public void setZonePort(int zonePort) {
		this.zonePort = zonePort;
	}
	/**
	 * @return the zoneCurPeople
	 */
	public int getZoneCurPeople() {
		return zoneCurPeople;
	}
	/**
	 * @param zoneCurPeople the zoneCurPeople to set
	 */
	public void setZoneCurPeople(int zoneCurPeople) {
		this.zoneCurPeople = zoneCurPeople;
	}
	/**
	 * @return the zoneMaxPeople
	 */
	public int getZoneMaxPeople() {
		return zoneMaxPeople;
	}
	/**
	 * @param zoneMaxPeople the zoneMaxPeople to set
	 */
	public void setZoneMaxPeople(int zoneMaxPeople) {
		this.zoneMaxPeople = zoneMaxPeople;
	}
}
