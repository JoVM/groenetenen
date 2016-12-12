package be.vdab.valueobjects;

public class PostcodeReeks {
	private int vanpostcode;
	private int totpostcode;

	public int getVanpostcode() {
		return vanpostcode;
	}

	public void setVanpostcode(int vanpostcode) {
		this.vanpostcode = vanpostcode;
	}

	public int getTotpostcode() {
		return totpostcode;
	}

	public void setTotpostcode(int totpostcode) {
		this.totpostcode = totpostcode;
	}

	public boolean bevat(int postcode) {
		// bevat de reeks een bepaalde postcode ? (gebuikt in de repository
		// layer)
		return postcode >= vanpostcode && postcode <= totpostcode;
	}
}
