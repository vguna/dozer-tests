package test.model;

public class MyDto extends AbstractDto {

	private String otherName;
	private String excludeMe;

	public String getExcludeMe() {
		return excludeMe;
	}

	public void setExcludeMe(String excludeMe) {
		this.excludeMe = excludeMe;
	}

	public String getOtherName() {
		return otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}
}
